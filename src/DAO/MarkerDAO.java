package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DBConnection;
import DTO.MarkerDTO;

public class MarkerDAO {

	private static MarkerDAO markerDAO;
	static {
		markerDAO = new MarkerDAO();
	}
	public static MarkerDAO getInstance() {
		return markerDAO;
	}
	private MarkerDAO(){
		
	}
	
	
	public int insertMarker(MarkerDTO markerDto) {
		Connection conn = null; 
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			conn = DBConnection.getInstance().getConn();
			conn.setAutoCommit(false);
			
			String sql = " insert into marker (u_id_fk,address,lat,lng,m_time) values(?,?,?,?,?);";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,markerDto.getuId());pstmt.setString(2,markerDto.getAddress());
			pstmt.setString(3,markerDto.getLat());pstmt.setString(4,markerDto.getLng());pstmt.setString(5,markerDto.getM_time());
			
			res = (byte)pstmt.executeUpdate();
			
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
		return res;
			
	}
	
	
	public int deleteMarkerByUser(String uId) {
		
		Connection conn = null; 
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			conn = DBConnection.getInstance().getConn();
			conn.setAutoCommit(false);
			
			String deleteSql = "delete from marker where u_id_fk=?;";
			pstmt = conn.prepareStatement(deleteSql);
            pstmt.setString(1, uId);
            pstmt.executeUpdate();
            
            res = (byte)pstmt.executeUpdate();
			
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
		return res;
	}
	
	
	public int deleteMarkerByTimestamp(String uId, String timestamp) {
		
		Connection conn = null; 
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			conn = DBConnection.getInstance().getConn();
			conn.setAutoCommit(false);
			
			String deleteSql = "delete from marker where u_id_fk=? and m_time<?;";
			pstmt = conn.prepareStatement(deleteSql);
            pstmt.setString(1, uId);
            pstmt.setString(2, timestamp);
            pstmt.executeUpdate();
            
            res = (byte)pstmt.executeUpdate();
			
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
		return res;
	}
	
	public List<MarkerDTO> getMarkerByUser(String uId) {
		Connection conn = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MarkerDTO> userList = null;
		MarkerDTO markerDTO = null;
		
		try {
			conn = DBConnection.getInstance().getConn();
			userList = new ArrayList<MarkerDTO>();
			
			String sql = "select * from marker where u_id_fk=?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,uId);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				markerDTO = new MarkerDTO(rs.getString("m_id"), rs.getString("u_id_fk"), rs.getString("address"),
						rs.getString("lat"),rs.getString("lng"),rs.getString("m_time"));
				userList.add(markerDTO);
			}
			
		} catch ( Exception ex ) {
			ex.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
				conn.close();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return userList;
	}
	
}
