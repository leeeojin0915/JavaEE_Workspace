<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%
	//데이터베이스와 연결이 된다면 모든 설정이 완료된 것
	InitialContext context=new InitialContext();//jndi검색객체
	DataSource ds=(DataSource)context.lookup("java:comp/env/jdbc/mysql");//톰켓 서버에 설정한 리소스 찾기
	//찾아낸 커넥션풀을 이용하여 커넥션 한 개를 끄집어내고 주소값이 나오면 성공
	Connection con=ds.getConnection();
	out.print(con);
%>