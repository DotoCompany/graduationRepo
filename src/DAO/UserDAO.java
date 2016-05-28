package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import model.DBConnection;
import util.crypt.BCrypt;
import util.crypt.SHA256;
import DTO.UserDTO;

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
	 * User정보 input method.
	 * @param userVO
	 * @return insert 성공시 1 리턴 실패시 0리턴
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
			/*아랫줄은 PreparedStatement객체에 값을 대입해주는 코드들이다.*/
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
			/*아랫줄은 PreparedStatement객체에 값을 대입해주는 코드들이다.*/
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
	 * 아마도, 로그인 시 사용하게 될 search 메소드일 듯 합니다.
	 * @param email 사용자 이메일
	 * @param password 사용자 비밀번호
	 * @return 사용자 이메일과 비밀번호에 매칭되는 값
	 */
	public UserDTO getUser(String email,String pwd) {
		PreparedStatement pstmt = null;
		UserDTO userDTO = null;
		Connection conn = null;
		ResultSet rs = null;
		SHA256 sha = SHA256.getInsatnce();
		
		try {
			conn = DBConnection.getInstance().getConn();
			
			/* 유저로부터 입력받은 pwd를 1차 암호화 */
			String orgPass = pwd;
            String shaPass = sha.getSha256(orgPass.getBytes());
			
			String sql = "select * from user_tb where email_id=?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,email);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
			
				String dbPwd = rs.getString("pwd");
				
				/*유저로부터 입력받은 pwd와 DB의 pwd를 비교 */
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
				conn.close();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return userDTO;
	}
	
	/**
	 * 유저의 EmailId 와 Name을 수정하기 위한 메소드
	 * @param userDTO
	 * @return 1 : update성공  / 0 : update실패
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
	 * 유저를 삭제하기 위한 메소드
	 * @param emailId
	 * @param pwd
	 * @return 1 : delete성공  / 0 : delete실패
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
