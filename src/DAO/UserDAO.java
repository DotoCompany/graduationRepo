package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.DBConnection;
import model.UserDTO;

public class UserDAO {
	private Connection conn;
	private static UserDAO userDAO;
	static {
		userDAO = new UserDAO();
	}
	public static UserDAO getInstance() {
		return userDAO;
	}
	private UserDAO(){
		try {
			conn = DBConnection.getInstance().getConn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * User���� input method.
	 * @param userVO
	 * @return insert ������ 1 ���� ���н� 0����
	 */
	public byte insertUser(UserDTO userDTO) {
		PreparedStatement pstmt = null;
		byte success = 0;
		try {
			String sql = " insert into user_tb (email,name,password,reg_date) values(?,?,?,now());";
			pstmt = conn.prepareStatement(sql);
			/*�Ʒ����� PreparedStatement��ü�� ���� �������ִ� �ڵ���̴�.*/
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
		byte success = 0;
		try {
			String sql = " insert into user_tb (email,name,password,reg_date) values(?,?,?,now());";
			pstmt = conn.prepareStatement(sql);
			/*�Ʒ����� PreparedStatement��ü�� ���� �������ִ� �ڵ���̴�.*/
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
		} finally {
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
}
