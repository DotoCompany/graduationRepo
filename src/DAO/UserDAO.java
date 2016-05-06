package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DBConnection;
import model.UserDTO;

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
		try {
			conn = DBConnection.getInstance().getConn();
			String sql = " insert into user_tb (email,name,password,reg_date) values(?,?,?,now());";
			pstmt = conn.prepareStatement(sql);
			/*아랫줄은 PreparedStatement객체에 값을 대입해주는 코드들이다.*/
			pstmt.setString(1, userDTO.getEmail());pstmt.setString(2, userDTO.getName());pstmt.setString(3, userDTO.getPassword());
			success = (byte)pstmt.executeUpdate();
			conn.commit();
		} catch( SQLException sqle ) {
			sqle.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException sqle2) {
				sqle.printStackTrace();
			} 
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch ( SQLException sqle ) {
				sqle.printStackTrace();
			} // catch end
		} // finally end
		return success;
	}
	public byte insertUser(String email,String name,String password) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		
		byte success = 0;
		try {
			conn = DBConnection.getInstance().getConn();
			conn.setAutoCommit(false);
			String sql = " insert into user_tb (email,name,password,reg_date) values(?,?,?,now());";
			pstmt = conn.prepareStatement(sql);
			/*아랫줄은 PreparedStatement객체에 값을 대입해주는 코드들이다.*/
			pstmt.setString(1, email);pstmt.setString(2, name);pstmt.setString(3, password);
			success = (byte)pstmt.executeUpdate();
			conn.commit();
		} catch( SQLException sqle ) {
			sqle.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException sqle2) {
				sqle.printStackTrace();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch(Exception ex){
			ex.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
			} catch ( SQLException sqle ) {
				sqle.printStackTrace();
			} catch(Exception ex) {
				ex.printStackTrace();// catch end
			}
		} // finally end
		return success;
	}
	/**
	 * 아마도, 로그인 시 사용하게 될 search 메소드일 듯 합니다.
	 * @param email 사용자 이메일
	 * @param password 사용자 비밀번호
	 * @return 사용자 이메일과 비밀번호에 매칭되는 값
	 */
	public UserDTO searchUserByEmailAndPassword(String email,String password) {
		PreparedStatement pstmt = null;
		UserDTO userDTO = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getInstance().getConn();
			String sql = "select * from user_tb where email=? and password = ?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,email);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				userDTO = new UserDTO(rs.getString("email"),rs.getString("name"),rs.getString("password"));
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
}
