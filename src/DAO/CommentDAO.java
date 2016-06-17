package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.CommentDTO;
import DTO.CommentViewDTO;
import model.DBConnection;

public class CommentDAO {
	private static final CommentDAO commentDAO;
	static {
		commentDAO = new CommentDAO();
	}
	public static CommentDAO getInstance() {return commentDAO;}
	private CommentDAO(){}
	
	/**
	 * 해당 글에 대한 모든 코멘트를 가져오는 메소드.
	 * @param lifeLogCode
	 * @return
	 */
	public ArrayList<CommentViewDTO> getComment(String lifeLogCode) {
		
		ArrayList<CommentViewDTO> arrayList = new ArrayList<CommentViewDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			 conn = DBConnection.getInstance().getConn();
			 String sql = "select * from comment_view where ll_id=?";
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, lifeLogCode);
			 rs = pstmt.executeQuery();
			 while(rs.next()) {
				 arrayList.add(new CommentViewDTO( rs.getInt("u_id"),rs.getString("email_id"),rs.getString("name"),rs.getString("image"),rs.getInt("c_id"),rs.getInt("ll_id"),rs.getString("body"),rs.getInt("depth"),rs.getTimestamp("time"),rs.getInt("partion"),rs.getInt("seq")) );	 
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
	public int insertComment(int llId,String body, int depth,int partion,int seq,int uId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DBConnection.getInstance().getConn();
			conn.setAutoCommit(false);
			String sql = "insert into comment (ll_id,body,depth,time,partion,seq,u_id) values(?,?,?,now(),?,?,?);";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, llId);
			pstmt.setString(2, body);
			pstmt.setInt(3, depth);
			pstmt.setInt(4,partion);
			pstmt.setInt(5,seq);
			pstmt.setInt(6, uId);
			result = pstmt.executeUpdate();
			conn.commit();
		} catch( Exception ex) {
			ex.printStackTrace();
			try {
				pstmt.close();
				conn.close();
			} catch(Exception exx) {
				exx.printStackTrace();
			}
		}
		return result;
	}
}
