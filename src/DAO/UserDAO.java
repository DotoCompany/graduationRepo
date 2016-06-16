package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;



import DTO.UserDTO;
import admin.dto.UserStatsDTO;
import model.DBConnection;
import util.crypt.BCrypt;
import util.crypt.SHA256;

public class UserDAO {
	
	private static UserDAO userDAO;
	static {
		userDAO = new UserDAO();
	}
	public static UserDAO getInstance() {
		return userDAO;
	}
	private UserDAO(){
		
	}
	
	
	
	/**
	 * User���� input method.
	 * @param userVO
	 * @return insert ������ 1 ���� ���н� 0����
	 */
	public byte insertUser(UserDTO userDTO) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		byte success = 0;
		SHA256 sha = SHA256.getInsatnce();
		
		try {
			conn = DBConnection.getInstance().getConn();
			conn.setAutoCommit(false);
			
			/* Encryption */
			String orgPass = userDTO.getPwd();
            String shaPass = sha.getSha256(orgPass.getBytes());
        	String bcPass = BCrypt.hashpw(shaPass, BCrypt.gensalt());
			
			
			String sql = " insert into user_tb (email_id,name,pwd,reg_date) values(?,?,?,?);";
			pstmt = conn.prepareStatement(sql);
			/*�Ʒ����� PreparedStatement��ü�� ���� �������ִ� �ڵ���̴�.*/
			pstmt.setString(1, userDTO.getEmailId());pstmt.setString(2, userDTO.getName());pstmt.setString(3, bcPass);
			pstmt.setString(4, new Timestamp(new java.util.Date().getTime()).toString());
			success = (byte)pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e ) {
	        e.printStackTrace();
	        if (conn != null) {
	            try {
	                System.err.print("Transaction is being Rolled back");
	                conn.rollback();
	            } catch(SQLException se) {
	                se.printStackTrace();
	            }
	        }
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	if (conn != null) {
	            try {
	                System.err.print("Transaction is being Rolled back");
	                conn.rollback();
	            } catch(SQLException se) {
	                se.printStackTrace();
	            }
	        }
	    } finally {
	    	if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) {
            	try { 
            		conn.setAutoCommit(true);
                	conn.close(); 
            	} catch(SQLException ex) {}
            } 
	    }
		return success;
	}
	public byte insertUser(String email,String name,String pwd) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		byte success = 0;
		SHA256 sha = SHA256.getInsatnce();
		
		try {
			conn = DBConnection.getInstance().getConn();
			conn.setAutoCommit(false);
			
			/* Encryption */
			String orgPass = pwd;
            String shaPass = sha.getSha256(orgPass.getBytes());
        	String bcPass = BCrypt.hashpw(shaPass, BCrypt.gensalt());
        	
			String sql = " insert into user_tb (email_id,name,pwd,reg_date) values(?,?,?,?);";
			pstmt = conn.prepareStatement(sql);
			/*�Ʒ����� PreparedStatement��ü�� ���� �������ִ� �ڵ���̴�.*/
			pstmt.setString(1, email);pstmt.setString(2, name);pstmt.setString(3, bcPass);
			pstmt.setString(4, new Timestamp(new java.util.Date().getTime()).toString());
			success = (byte)pstmt.executeUpdate();
			
			conn.commit();
		} catch (SQLException e ) {
	        e.printStackTrace();
	        if (conn != null) {
	            try {
	                System.err.print("Transaction is being Rolled back");
	                conn.rollback();
	            } catch(SQLException se) {
	                se.printStackTrace();
	            }
	        }
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	if (conn != null) {
	            try {
	                System.err.print("Transaction is being Rolled back");
	                conn.rollback();
	            } catch(SQLException se) {
	                se.printStackTrace();
	            }
	        }
	    } finally {
	    	if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) {
            	try { 
            		conn.setAutoCommit(true);
                	conn.close(); 
            	} catch(SQLException ex) {}
            } 
	    }
		return success;
	}
	
	/**
	 * �Ƹ���, �α��� �� ����ϰ� �� search �޼ҵ��� �� �մϴ�.
	 * @param email ����� �̸���
	 * @param password ����� ��й�ȣ
	 * @return ����� �̸��ϰ� ��й�ȣ�� ��Ī�Ǵ� ��
	 */
	public UserDTO getUser(String email,String pwd) {
		PreparedStatement pstmt = null;
		UserDTO userDTO = null;
		Connection conn = null;
		ResultSet rs = null;
		SHA256 sha = SHA256.getInsatnce();
		
		try {
			conn = DBConnection.getInstance().getConn();
			
			/* �����κ��� �Է¹��� pwd�� 1�� ��ȣȭ */
			String orgPass = pwd;
            String shaPass = sha.getSha256(orgPass.getBytes());
			
			String sql = "select * from user_tb where email_id=?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,email);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
			
				String dbPwd = rs.getString("pwd");
				
				/*�����κ��� �Է¹��� pwd�� DB�� pwd�� �� */
				if(BCrypt.checkpw(shaPass,dbPwd)) {
					userDTO = new UserDTO(rs.getString("u_id"),rs.getString("image") ,rs.getString("email_id"),rs.getString("name"),dbPwd,rs.getString("reg_date"));
				}
				
			}
		} catch ( Exception ex ) {
			ex.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
				conn.close();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return userDTO;
	}
	
	/**
	 * ��ü ������ �ҷ����� �޼ҵ�. Admin ���������� ���
	 * @return List<UserDTO>
	 */
	public List<UserDTO> getAllUsers() {
		
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		List<UserDTO> userList = null;
		
		try {
			userList = new ArrayList<UserDTO>();
			conn = DBConnection.getInstance().getConn();
			
            String sql = "select * from user_tb";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
                
            while(rs.next()){
            	
            	userList.add(new UserDTO(rs.getString("u_id"),"",rs.getString("email_id"),rs.getString("name"),"",rs.getString("reg_date")));
            	
			}
		} catch (SQLException e ) {
	        e.printStackTrace();
	    } catch (Exception e) {
	    	e.printStackTrace();
	    } finally {
	    	if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) {
            	try { 
                	conn.close(); 
            	} catch(SQLException ex) {}
            } 
	    }
		
		return userList;
	}
	
	/**
	 * �б⺰�� ������ �� ���� ��ȯ�ϴ� �޼ҵ�. Admin���� ���� ����.
	 * @return List<UserStatsDTO>
	 */
	public List<UserStatsDTO> getUserStats() {
		
		final String sql =  "select ceil(extract(MONTH FROM reg_date)/3) as quarter, count(u_id) as user_cnt " +
				"from user_tb " + "group by ceil(extract(MONTH FROM reg_date)/3) " + "order by quarter";
		
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		List<UserStatsDTO> userList = null;
		
		try {
			userList = new ArrayList<UserStatsDTO>();
			conn = DBConnection.getInstance().getConn();
			
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
                
            while(rs.next()){
            	
            	userList.add(new UserStatsDTO(rs.getString("quarter"),rs.getString("user_cnt")));
            	
			}
		} catch (SQLException e ) {
	        e.printStackTrace();
	    } catch (Exception e) {
	    	e.printStackTrace();
	    } finally {
	    	if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) {
            	try { 
                	conn.close(); 
            	} catch(SQLException ex) {}
            } 
	    }
		return userList;
	}
	
	/**
	 * ������ EmailId �� Name�� �����ϱ� ���� �޼ҵ�
	 * @param userDTO
	 * @return 1 : update����  / 0 : update����
	 * @throws SQLException
	 */
	public byte updateUser(UserDTO userDTO) {
		
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		byte success = 0;
		SHA256 sha = SHA256.getInsatnce();
		
		try {
			conn = DBConnection.getInstance().getConn();
			
			String orgPass = userDTO.getPwd();
            String shaPass = sha.getSha256(orgPass.getBytes());
        	String bcPass = BCrypt.hashpw(shaPass, BCrypt.gensalt());

            
            String sql = "select * from user_tb where email_id=?;";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userDTO.getEmailId());
            rs = pstmt.executeQuery();
                
            if(rs.next()){
            	conn.setAutoCommit(false);
					String updateSql = "update user_tb set name=?, pwd=? where email_id=?;";
                    pstmt = conn.prepareStatement(updateSql);
                    pstmt.setString(1, userDTO.getName());
                    pstmt.setString(2, bcPass);
                    pstmt.setString(3, userDTO.getEmailId());
                    pstmt.executeUpdate();
                    
                    success = 1;
				}else
					success = 0;
				
				conn.commit();
		} catch (SQLException e ) {
	        e.printStackTrace();
	        if (conn != null) {
	            try {
	                System.err.print("Transaction is being Rolled back");
	                conn.rollback();
	            } catch(SQLException se) {
	                se.printStackTrace();
	            }
	        }
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	if (conn != null) {
	            try {
	                System.err.print("Transaction is being Rolled back");
	                conn.rollback();
	            } catch(SQLException se) {
	                se.printStackTrace();
	            }
	        }
	    } finally {
	    	if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) {
            	try { 
            		conn.setAutoCommit(true);
                	conn.close(); 
            	} catch(SQLException ex) {}
            } 
	    }
		return success;
	}
	
	/**
	 * u_id�� ������ �����ϱ� ���� �޼ҵ�
	 * @param uId
	 * @return 1 : delete����  / 0 : delete����
	 * @throws SQLException
	 */
	public byte deleteUserById(String uId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs= null;
        byte success=0;
        
        try {
			conn = DBConnection.getInstance().getConn();
			conn.setAutoCommit(false);
			
            String sql = "select pwd from user_tb where u_id = ?;";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, uId);
            rs = pstmt.executeQuery();
            
			if(rs.next()){
				conn.setAutoCommit(false);
				
				String deleteSql = "delete from user_tb where u_id=?;";
				pstmt = conn.prepareStatement(deleteSql);
                pstmt.setString(1, uId);
                pstmt.executeUpdate();
				
				success = 1;
				conn.commit();
			}
		} catch (SQLException e ) {
	        e.printStackTrace();
	        if (conn != null) {
	            try {
	                System.err.print("Transaction is being Rolled back");
	                conn.rollback();
	            } catch(SQLException se) {
	                se.printStackTrace();
	            }
	        }
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	if (conn != null) {
	            try {
	                System.err.print("Transaction is being Rolled back");
	                conn.rollback();
	            } catch(SQLException se) {
	                se.printStackTrace();
	            }
	        }
	    } finally {
	    	if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) {
            	try { 
            		conn.setAutoCommit(true);
                	conn.close(); 
            	} catch(SQLException ex) {}
            } 
	    }
		return success;
    }
	
	/**
	 * ������ �����ϱ� ���� �޼ҵ�
	 * @param emailId
	 * @param pwd
	 * @return 1 : delete����  / 0 : delete����
	 * @throws SQLException
	 */
	public byte deleteUser(String emailId, String pwd) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs= null;
        byte success=0;
        
        SHA256 sha = SHA256.getInsatnce();
        try {
			conn = DBConnection.getInstance().getConn();
			conn.setAutoCommit(false);
			
			String orgPass = pwd;
            String shaPass = sha.getSha256(orgPass.getBytes());

            String sql = "select pwd from user_tb where email_id = ?;";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, emailId);
            rs = pstmt.executeQuery();
            
			if(rs.next()){
				conn.setAutoCommit(false);
				
				String dbPwd= rs.getString("pwd"); 
				if(BCrypt.checkpw(shaPass,dbPwd)){
					String deleteSql = "delete from user_tb where email_id=?;";
					pstmt = conn.prepareStatement(deleteSql);
                    pstmt.setString(1, emailId);
                    pstmt.executeUpdate();
                    success = 1;
				}else
					success = 0;
				
				conn.commit();
			}
		} catch (SQLException e ) {
	        e.printStackTrace();
	        if (conn != null) {
	            try {
	                System.err.print("Transaction is being Rolled back");
	                conn.rollback();
	            } catch(SQLException se) {
	                se.printStackTrace();
	            }
	        }
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	if (conn != null) {
	            try {
	                System.err.print("Transaction is being Rolled back");
	                conn.rollback();
	            } catch(SQLException se) {
	                se.printStackTrace();
	            }
	        }
	    } finally {
	    	if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) {
            	try { 
            		conn.setAutoCommit(true);
                	conn.close(); 
            	} catch(SQLException ex) {}
            } 
	    }
		return success;
    }
	/**
	 * �˻��� �˻��� �� ȣ��Ǵ� �޼ҵ�.
	 * @param searchBox
	 * @return
	 */
	public ArrayList<UserDTO> searchUser(String searchBox) {
		ArrayList<UserDTO> arrayList = new ArrayList<UserDTO>();
		PreparedStatement pstmt = null;;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = DBConnection.getInstance().getConn();
			String sql = "select * from user_tb where email_id Like ? or name Like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, '%'+searchBox+'%');
			pstmt.setString(2, '%'+searchBox+'%');
			rs = pstmt.executeQuery();
			while(rs.next()) {
				arrayList.add(new UserDTO( Integer.toString(rs.getInt("u_id")),rs.getString("image"), rs.getString("email_id"),rs.getString("name"),rs.getTimestamp("reg_date").toString()  ));
			}
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
				rs.close();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return arrayList;
		
		
	}
}
