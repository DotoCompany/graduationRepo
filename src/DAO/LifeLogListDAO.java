package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.LifeLogViewDTO;
import model.DBConnection;

public class LifeLogListDAO {
	private static final LifeLogListDAO lifeLogListDAO;
	static {
		lifeLogListDAO = new LifeLogListDAO();
	}
	private LifeLogListDAO(){};
	public ArrayList<LifeLogViewDTO> searchLifeLog(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<LifeLogViewDTO> arrayList = new ArrayList<LifeLogViewDTO>();
		try {
			conn = DBConnection.getInstance().getConn();
			String sql = "select * from life_log_view";
			pstmt = conn.prepareStatement(sql);
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
