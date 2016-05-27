package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.crypt.BCrypt;
import util.crypt.SHA256;
import DTO.UserDTO;
import model.DBConnection;

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
			
			
			String sql = " insert into user_tb (email_id,name,pwd,reg_date) values(?,?,?,now());";
			pstmt = conn.prepareStatement(sql);
			/*�Ʒ����� PreparedStatement��ü�� ���� �������ִ� �ڵ���̴�.*/
			pstmt.setString(1, userDTO.getEmailId());pstmt.setString(2, userDTO.getName());pstmt.setString(3, bcPass);
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
			
        	System.out.println(" bcPass : " + bcPass);
        	
			String sql = " insert into user_tb (email_id,name,pwd,reg_date) values(?,?,?,now());";
			pstmt = conn.prepareStatement(sql);
			/*�Ʒ����� PreparedStatement��ü�� ���� �������ִ� �ڵ���̴�.*/
			pstmt.setString(1, email);pstmt.setString(2, name);pstmt.setString(3, bcPass);
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
			
			/* Decryption */
			String orgPass = pwd;
            String shaPass = sha.getSha256(orgPass.getBytes());
			
			String sql = "select * from user_tb where email_id=?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,email);
			rs = pstmt.executeQuery();
			
			System.out.println(" shaPass : " + shaPass);
			
			if (rs.next()) {
			
				String dbPwd = rs.getString("pwd");
				System.out.println(" dbPwd : " + dbPwd);
				if(BCrypt.checkpw(shaPass,dbPwd)) {
					userDTO = new UserDTO(rs.getString("u_id"), rs.getString("email_id"),rs.getString("name"),dbPwd,rs.getString("reg_date"));
				}
				
			}
		} catch ( Exception ex ) {
			ex.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return userDTO;
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
            
            String sql = "select * from user_tb where u_id=?;";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userDTO.getuId());
            rs = pstmt.executeQuery();
                
            if(rs.next()){
            	conn.setAutoCommit(false);
            	
				String dbPwd= rs.getString("pwd"); 
				if(BCrypt.checkpw(shaPass,dbPwd)){
					
					String updateSql = "update uset_tb set email_id=?, name=? where u_id=?;";
                    pstmt = conn.prepareStatement(updateSql);
                    pstmt.setString(1, userDTO.getEmailId());
                    pstmt.setString(2, userDTO.getName());
                    pstmt.setString(3, userDTO.getuId());
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
}
