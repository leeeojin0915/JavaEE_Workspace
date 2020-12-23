<%@ page contentType="text/html;charset=utf-8"%>
<%
	//service메서드 영역 고양이가 d이 jsp로부터 생성한 서블릿 클래스에는
	//각종 예외가 throws처리되어있기 때문에 jsp스틀릿 
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
당신이 선택한 영화에 대한 판단결과<p>
<%=session.getAttribute("msg") %>
<a href="/movie/movie_form.jsp">선택폼으로 가기</a>
</body>
</html>