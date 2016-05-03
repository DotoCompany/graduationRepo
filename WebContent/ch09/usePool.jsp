<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*,javax.sql.*, javax.naming.*" %>
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<link rel="stylesheet" href="style.css"/>

<table>
  <tr  class="label">
  	<td>아이디
  	<td>비밀번호
  	<td>이름
  	<td>가입일자
  	<td>주소
  	<td>전화번호
  
<%
  Connection conn=null;
  PreparedStatement pstmt=null;
  ResultSet rs=null;

  try{
	 
	 // InitialContext 객체로 Context 객체 생성
	 Context initCtx = new InitialContext();
	 // lookup() 메소드를 이용하여, 환경 세팅해 놓은 것을 찾는다.
	 Context envCtx = (Context) initCtx.lookup("java:comp/env");
	 DataSource ds = (DataSource)envCtx.lookup("jdbc/recalldb");
	 // DataSource 객체의 getConnection()메소드로 Connection 객체를 받아옴.
	 conn = ds.getConnection();
	 
	 
	 System.out.println("Creating table in given database...");
	 
	 String sql = "create or replace table user_tb ( " + 
			 "email varchar(100) not null primary key, " +
			 "name varchar(30) not null , " +
			 "password varchar(50) not null, " +
			 "reg_date timestamp not null);";
			 
	 pstmt = conn.prepareStatement(sql);
	 pstmt.executeUpdate();
     System.out.println("Created table in given database...");


  }catch(Exception e){ 
	 e.printStackTrace();
  }finally{
	 if(rs != null) 
	    try{rs.close();}catch(SQLException sqle){}
	 if(pstmt != null) 
		try{pstmt.close();}catch(SQLException sqle){}
	 if(conn != null) 
		try{conn.close();}catch(SQLException sqle){}
  }
%>
</table>