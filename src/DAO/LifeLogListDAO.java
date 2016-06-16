package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import DTO.LifeLogViewDTO;
import model.DBConnection;

public class LifeLogListDAO {
	private static final LifeLogListDAO lifeLogListDAO;
	static {
		lifeLogListDAO = new LifeLogListDAO();
	}
	private LifeLogListDAO(){};
	public static LifeLogListDAO getInstance(){return lifeLogListDAO;}
	public ArrayList<LifeLogViewDTO> searchLifeLog(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<LifeLogViewDTO> arrayList = new ArrayList<LifeLogViewDTO>();
		try {
			conn = DBConnection.getInstance().getConn();
			String sql = "select * from life_log_view";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				arrayList.add(new LifeLogViewDTO(Integer.toString(rs.getInt("u_id")), Integer.toString(rs.getInt("ll_id")), rs.getTimestamp("upload_date").toString(), rs.getString("ispublic"),rs.getString("url"),rs.getString("body"),Integer.toString(rs.getInt("seq")), Float.toString(rs.getFloat("lat")), Float.toString(rs.getFloat("lng"))));
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
