package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.FriendDTO;
import model.DBConnection;

public class FriendDAO {
	public static final FriendDAO friendDAO;
	static {
		friendDAO = new FriendDAO();
	}
	
	private FriendDAO(){
		
	}
	public static FriendDAO getInstance() {return friendDAO;}
	public ArrayList<FriendDTO> getFriends(String userCode ){
		PreparedStatement pstmt = null;
		FriendDTO friendDTO = null;
		ArrayList<FriendDTO> arrayList = new ArrayList<FriendDTO>();
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getInstance().getConn();
			String sql = "select * from friend_view where u_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userCode);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				String image = rs.getString("image");
				if(image.equals("0"))
					image ="image/default_profile_image.png";
					
				arrayList.add(new FriendDTO(rs.getString("f_id"),image,rs.getString("name"),rs.getString("email_id")));
				System.out.println("--");
				
			}
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
				conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} 
		return arrayList;
	}
}
