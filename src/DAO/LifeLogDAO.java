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
			/*�Ʒ����� PreparedStatement��ü�� ���� �������ִ� �ڵ���̴�.*/
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
	
	public int deleteLifeLog(String llId) {
		
		final String deletelldSql = "delete from life_log_body where ll_id_fk=?;";
		final String deletellpSql = "delete from life_log_photo where ll_id_fk=?;";
		final String deletellSql = "delete from life_log where ll_id=?;";
		int success = 0;
		PreparedStatement pstmt = null;
		Connection conn = null;
		
		try {
			conn = DBConnection.getInstance().getConn();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(deletelldSql);
			/*�Ʒ����� PreparedStatement��ü�� ���� �������ִ� �ڵ���̴�.*/
			pstmt.setString(1, llId);
			success = pstmt.executeUpdate();
			if(success > 0) {
				
				pstmt = conn.prepareStatement(deletellpSql);
				pstmt.setString(1, llId);
				success = pstmt.executeUpdate();
				
				pstmt = conn.prepareStatement(deletellSql);
				pstmt.setString(1, llId);
				success = pstmt.executeUpdate();
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
	
	public int modifyLifeLog(String ll_id, String isPublic, String body, String url) {
		
		final String llSql = "update life_log set upload_date=?, isPublic=? where ll_id=?;";
		final String llbSql = "update life_log_body set body=? where ll_id_fk=?;";
		final String llpSql = "update life_log_photo set url=? where ll_id_fk=?;";
		
		int success = 0;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getInstance().getConn();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(llSql);
			/*�Ʒ����� PreparedStatement��ü�� ���� �������ִ� �ڵ���̴�.*/
			pstmt.setString(1,new Timestamp(new java.util.Date().getTime()).toString());
			pstmt.setString(2, isPublic);pstmt.setString(3, ll_id);
			success = pstmt.executeUpdate();
			if(success > 0) {
		
					pstmt = conn.prepareStatement(llbSql);
					pstmt.setString(1, body);pstmt.setString(2, ll_id);
					success = pstmt.executeUpdate();
					
					pstmt = conn.prepareStatement(llpSql);
					pstmt.setString(1, url);pstmt.setString(2, ll_id);
					success = pstmt.executeUpdate();
	
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