package ch11.logon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import util.crypt.SHA256;
import util.crypt.BCrypt;

public class LogonDBBean {
	
	//LogonDBBean �쟾�뿭 媛앹껜 �깮�꽦 <- �븳媛쒖쓽 媛앹젣留� �깮�꽦�빐�꽌 怨듭쑀
    private static LogonDBBean instance = new LogonDBBean();
    
    //LogonDBBean媛앹껜瑜� 由ы꽩�븯�뒗 硫붿냼�뱶
    public static LogonDBBean getInstance() {
        return instance;
    }
    
    private LogonDBBean() {}
    
    //而ㅻ꽖�뀡 ���뿉�꽌 而ㅻ꽖�뀡 媛앹껜瑜� �뼸�뼱�궡�뒗 硫붿냼�뱶
    private Connection getConnection() throws Exception {
        Context initCtx = new InitialContext();
        Context envCtx = (Context) initCtx.lookup("java:comp/env");
        DataSource ds = (DataSource)envCtx.lookup("jdbc/jsptest");
        return ds.getConnection();
    }
 
    //�쉶�썝 媛��엯 泥섎━(registerPro.jsp)�뿉�꽌 �궗�슜�븯�뒗  �깉 �젅肄붾뱶 異붽� 硫붿냼�뱶
    public void insertMember(LogonDataBean member){
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        SHA256 sha = SHA256.getInsatnce();
        try {
            conn = getConnection();
            
            String orgPass = member.getPasswd();
            String shaPass = sha.getSha256(orgPass.getBytes());
        	String bcPass = BCrypt.hashpw(shaPass, BCrypt.gensalt());
        	
            pstmt = conn.prepareStatement(
            	"insert into member values (?,?,?,?,?,?)");
            pstmt.setString(1, member.getId());
            pstmt.setString(2, bcPass);
            pstmt.setString(3, member.getName());
            pstmt.setTimestamp(4, member.getReg_date());
            pstmt.setString(5, member.getAddress());
            pstmt.setString(6, member.getTel());		
            pstmt.executeUpdate();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
    }
 
	//濡쒓렇�씤 �뤌 泥섎━(loginPro.jsp)�럹�씠吏��쓽 �궗�슜�옄 �씤利� 泥섎━ 諛�
    //�쉶�썝�젙蹂댁닔�젙/�깉�눜瑜� �궗�슜�옄�씤利�(memberCheck.jsp)�뿉�꽌 �궗�슜�븯�뒗 硫붿냼�뱶
    public int userCheck(String id, String passwd){
		Connection conn = null;
        PreparedStatement pstmt = null;
		ResultSet rs= null;
		int x=-1;
        
		SHA256 sha = SHA256.getInsatnce();
		try {
            conn = getConnection();
            
            String orgPass = passwd;
            String shaPass = sha.getSha256(orgPass.getBytes());
        	
            pstmt = conn.prepareStatement(
            	"select passwd from member where id = ?");
            pstmt.setString(1, id);
            rs= pstmt.executeQuery();

			if(rs.next()){//�빐�떦 �븘�씠�뵒媛� �엳�쑝硫� �닔�뻾
				String dbpasswd= rs.getString("passwd"); 
				if(BCrypt.checkpw(shaPass,dbpasswd))
					x= 1; //�씤利앹꽦怨�
				else
					x= 0; //鍮꾨�踰덊샇 ��由�
			}else//�빐�떦 �븘�씠�뵒 �뾾�쑝硫� �닔�뻾
				x= -1;//�븘�씠�뵒 �뾾�쓬
			
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
		return x;
	}
    
    //�븘�씠�뵒 以묐났 �솗�씤 (confirmId.jsp)�뿉�꽌 �븘�씠�뵒�쓽 以묐났 �뿬遺�瑜� �솗�씤�븯�뒗 硫붿냼�뱶
	public int confirmId(String id) {
		Connection conn = null;
        PreparedStatement pstmt = null;
		ResultSet rs= null;
		int x=-1;
        
		try {
            conn = getConnection();
            
            pstmt = conn.prepareStatement(
            	"select id from member where id = ?");
            pstmt.setString(1, id);
            rs= pstmt.executeQuery();

			if(rs.next())//�븘�씠�뵒 議댁옱
				x= 1; //媛숈� �븘�씠�뵒 �엳�쓬
			else
				x= -1;//媛숈� �븘�씠�뵒 �뾾�쓬
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
		return x;
	}

   //�쉶�썝 �젙蹂� �닔�젙 �뤌(modifyForm.jsp)�쓣 �쐞�븳 湲곗〈 媛��엯 �젙蹂대�� 媛��졇�삤�뒗 硫붿냼�뱶
    public LogonDataBean getMember(String id, String passwd){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        LogonDataBean member=null;
        
        SHA256 sha = SHA256.getInsatnce();
        try {
            conn = getConnection();
            
            String orgPass = passwd;
            String shaPass = sha.getSha256(orgPass.getBytes());
            
            pstmt = conn.prepareStatement(
            	"select * from member where id = ?");
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
     
            if (rs.next()) {//�빐�떦 �븘�씠�뵒�뿉 ���븳 �젅肄붾뱶媛� 議댁옱
            	String dbpasswd= rs.getString("passwd");
            	//�궗�슜�옄媛� �엯�젰�븳 鍮꾨�踰덊샇�� �뀒�씠釉붿쓽 鍮꾨�踰덊샇媛� 媛숈쑝硫� �닔�뻾
				if(BCrypt.checkpw(shaPass,dbpasswd)){
                  member = new LogonDataBean();//�뜲�씠�꽣���옣鍮� 媛앹껜�깮�꽦
                  member.setId(rs.getString("id"));
				  member.setName(rs.getString("name"));
                  member.setReg_date(rs.getTimestamp("reg_date"));
                  member.setAddress(rs.getString("address"));
                  member.setTel(rs.getString("tel"));
				}
			}
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
		return member;//�뜲�씠�꽣 ���옣鍮� 媛앹껜 member 由ы꽩
    }
    
    //�쉶�썝 �젙蹂� �닔�젙 泥섎━(modifyPro.jsp)�뿉�꽌 �쉶�썝 �젙蹂� �닔�젙�쓣 泥섎━�븯�뒗 硫붿냼�뱶
    public int updateMember(LogonDataBean member){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs= null;
        int x=-1;
        
        SHA256 sha = SHA256.getInsatnce();
        try {
            conn = getConnection();
            
            String orgPass = member.getPasswd();
            String shaPass = sha.getSha256(orgPass.getBytes());
            
            pstmt = conn.prepareStatement(
                	"select passwd from member where id = ?");
            pstmt.setString(1, member.getId());
            rs = pstmt.executeQuery();
                
            if(rs.next()){//�빐�떦 �븘�씠�뵒媛� �엳�쑝硫� �닔�뻾
				String dbpasswd= rs.getString("passwd"); 
				if(BCrypt.checkpw(shaPass,dbpasswd)){
                    pstmt = conn.prepareStatement(
                     "update member set name=?,address=?,tel=? "+
                     "where id=?");
                    pstmt.setString(1, member.getName());
                    pstmt.setString(2, member.getAddress());
                    pstmt.setString(3, member.getTel());
                    pstmt.setString(4, member.getId());
                    pstmt.executeUpdate();
                    x= 1;//�쉶�썝�젙蹂� �닔�젙 泥섎━ �꽦怨�
				}else
					x= 0;//�쉶�썝�젙蹂� �닔�젙 泥섎━ �떎�뙣
			}
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
        	if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        return x;
    }
    
    //�쉶�썝 �깉�눜 泥섎━(deletePro.jsp)�뿉�꽌 �쉶�썝 �젙蹂대�� �궘�젣�븯�뒗 硫붿냼�뱶
    public int deleteMember(String id, String passwd){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs= null;
        int x=-1;
        
        SHA256 sha = SHA256.getInsatnce();
        try {
			conn = getConnection();
			
			String orgPass = passwd;
            String shaPass = sha.getSha256(orgPass.getBytes());

            pstmt = conn.prepareStatement(
            	"select passwd from member where id = ?");
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            
			if(rs.next()){
				String dbpasswd= rs.getString("passwd"); 
				if(BCrypt.checkpw(shaPass,dbpasswd)){
					pstmt = conn.prepareStatement(
            	      "delete from member where id=?");
                    pstmt.setString(1, id);
                    pstmt.executeUpdate();
					x= 1;//�쉶�썝�깉�눜泥섎━ �꽦怨�
				}else
					x= 0;//�쉶�썝�깉�눜 泥섎━ �떎�뙣
			}
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
		return x;
    }
}