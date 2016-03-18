package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 해당 클래스는 DB가 잘 동작 하는지 test하기 위한 DAO입니다.
 * DAO지만 싱글톤이 미적용 되어 있습니다.
 * @author kwongyo
 *
 */
public class TestDAO {
	/**
	 * DB Query 날리기 위하여 사용하는 Connection 객체.
	 */
	private Connection conn;
	public TestDAO() {
		conn = DBConnection.getInstance().getConn();
	}
	public String[] searchDatabases() {
		String sql = "show databases;";
		PreparedStatement pstmt=null;
		List<String> arrayList =new ArrayList<String>();
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				arrayList.add(rs.getString(1));
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return arrayList.toArray(new String[arrayList.size()]);
	}
	public static void main(String[]args) {
		String[] str = new TestDAO().searchDatabases();
		for(String tmp : str) {
			System.out.println(tmp);
		}
	}
}
