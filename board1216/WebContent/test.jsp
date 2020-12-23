<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%
	InitialContext context=new InitialContext();//jndi검색객체
	DataSource source=(DataSource)context.lookup("java:/comp/env/jdbc/mysql");
	Connection con=source.getConnection();
	out.print(con);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
</style>
<script>
</script>
</head>
<body>
test
</body>
</html>