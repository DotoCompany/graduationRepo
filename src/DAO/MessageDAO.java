package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.MessageDTO;
import model.DBConnection;

public class MessageDAO {
	private static final MessageDAO messageDAO;
	static {
		messageDAO = new MessageDAO();
	}
	public static MessageDAO getInstance() {
		return messageDAO;
	}
	public MessageDAO(){}
	public ArrayList<MessageDTO> getMessage(String userCode,String friendCode) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		ArrayList<MessageDTO> arrayList = new ArrayList<MessageDTO>();
		try {
			conn = DBConnection.getInstance().getConn();
			String sql = "select * from message_view where (from_id_fk=? and to_id_fk=?) or (from_id_fk=? and to_id_fk=?) order by msg_id;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userCode);
			pstmt.setString(2, friendCode);
			pstmt.setString(3, friendCode);
			pstmt.setString(4, userCode);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				arrayList.add(new MessageDTO(rs.getString("msg_id"),rs.getString("body"),rs.getString("sent_time"),rs.getString("to_name"),rs.getString("from_name")));
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
