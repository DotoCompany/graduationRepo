package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import model.DBConnection;
import DTO.LifeLogBodyDTO;
import DTO.LifeLogDTO;
import DTO.LifeLogPhotoDTO;

public class LifeLogDAO {
	
	public static final LifeLogDAO lifeLogDAO;
	static {
		lifeLogDAO = new LifeLogDAO();
	}
	
	private LifeLogDAO(){
		
	}
	
	public static LifeLogDAO getInstance() {return lifeLogDAO;}
	
	public int insertLifeLog(LifeLogDTO ll, LifeLogBodyDTO llb, LifeLogPhotoDTO llp) {
		
		final String llSql = "insert into life_log (u_id_fk,m_id_fk,upload_date,isPublic) values(?,?,?,?);";
		final String llSelectSql = "select ll_id from life_log where u_id_fk=? order by upload_date desc limit 1";
		final String llbSql = "insert into life_log_body (ll_id_fk, body, seq) values (?,?,?);";
		final String llpSql = "insert into life_log_photo (ll_id_fk, url) values (?,?);";
				
		
		int success = 0;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getInstance().getConn();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(llSql);
			/*아랫줄은 PreparedStatement객체에 값을 대입해주는 코드들이다.*/
			pstmt.setString(1, ll.getuIdFk());pstmt.setString(2, ll.getmIdFk());
			pstmt.setString(3, new Timestamp(new java.util.Date().getTime()).toString());pstmt.setString(4, ll.getIsPublic());
			success = pstmt.executeUpdate();
			if(success > 0) {
		
				pstmt = conn.prepareStatement(llSelectSql);
				pstmt.setString(1,ll.getuIdFk());
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
				
					String llId = rs.getString("ll_id");
					
					pstmt = conn.prepareStatement(llbSql);
					pstmt.setString(1, llId);pstmt.setString(2, llb.getBody());
					pstmt.setString(3, llb.getSeq());
					success = pstmt.executeUpdate();
					
					pstmt = conn.prepareStatement(llpSql);
					pstmt.setString(1, llId);pstmt.setString(2, llp.getUrl());
					success = pstmt.executeUpdate();
					
				}
			}
			
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
}


//pstmt.setString(4, new Timestamp(new java.util.Date().getTime()).toString());