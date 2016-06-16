package admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import DTO.UserDTO;
import admin.dto.AdminUser;
import model.DBConnection;
import util.crypt.BCrypt;
import util.crypt.SHA256;


public class AdminUserDAO {
	
	private static AdminUserDAO userDAO;
	static {
		userDAO = new AdminUserDAO();
	}
	public static AdminUserDAO getInstance() {
		return userDAO;
	}
	private AdminUserDAO(){
		
	}
	
	
	
	public byte insertUser(AdminUser adminDTO) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		byte success = 0;
		SHA256 sha = SHA256.getInsatnce();
		
		try {
			conn = DBConnection.getInstance().getConn();
			conn.setAutoCommit(false);
			
			/* Encryption */
			String orgPass = adminDTO.getPwd();
            String shaPass = sha.getSha256(orgPass.getBytes());
        	String bcPass = BCrypt.hashpw(shaPass, BCrypt.gensalt());
			
			
			String sql = " insert into admin_user (email_id,pwd,name,contact,reg_date,status) values(?,?,?,?,?,?);";
			pstmt = conn.prepareStatement(sql);
			/*아랫줄은 PreparedStatement객체에 값을 대입해주는 코드들이다.*/
			pstmt.setString(1, adminDTO.getEmailId());pstmt.setString(2, bcPass);pstmt.setString(3, adminDTO.getName());
			pstmt.setString(4, adminDTO.getContact());pstmt.setString(5, new Timestamp(new java.util.Date().getTime()).toString());pstmt.setString(6, adminDTO.getStatus());
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
	
	
	public AdminUser getUser(String email,String pwd) {
		PreparedStatement pstmt = null;
		AdminUser userDTO = null;
		Connection conn = null;
		ResultSet rs = null;
		SHA256 sha = SHA256.getInsatnce();
		
		try {
			conn = DBConnection.getInstance().getConn();
			
			/* 유저로부터 입력받은 pwd를 1차 암호화 */
			String orgPass = pwd;
            String shaPass = sha.getSha256(orgPass.getBytes());
			
			String sql = "select * from admin_user where email_id=?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,email);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
			
				String dbPwd = rs.getString("pwd");
				
				/*유저로부터 입력받은 pwd와 DB의 pwd를 비교 */
				if(BCrypt.checkpw(shaPass,dbPwd)) {
					userDTO = new AdminUser(rs.getString("a_id"),rs.getString("email_id"),dbPwd ,rs.getString("name"),rs.getString("contact"),rs.getString("reg_date"),rs.getString("status"));
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
	
}