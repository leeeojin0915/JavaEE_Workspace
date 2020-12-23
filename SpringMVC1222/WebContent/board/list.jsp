<%@page import="com.model2.domain.Board"%>
<%@page import="common.board.Pager"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%
	List<Board> list=(List)request.getAttribute("boardList");
	Pager pager=new Pager();
	pager.init(request, list);
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
table {
	border-collapse: collapse;
	border-spacing: 0;
	width: 100%;
	border: 1px solid #ddd;
}

th, td {
	text-align: left;
	padding: 16px;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}
</style>
</head>
<body>
	<table>
		<tr>
			<th>NO</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
		<%
		int num=pager.getNum();
		int curPos=pager.getCurPos();
		for(int i=1;i<pager.getPageSize();i++){
			if(num<1)break;
			Board board=list.get(curPos++);
		%>
		<tr>
			<td><%=num-- %></td>
			<td><a href="/board/detail?board_id=<%=board.getBoard_id() %>"><%=board.getTitle() %></a>[<%=board.getCnt()%>]</td>
			<td><%=board.getWriter() %></td>
			<td><%=board.getRegdate().substring(0,10)%></td>
			<td><%=board.getHit() %></td>
		</tr>
		<%} %>
		<tr>
			<td colspan="5" style="text-align:center">
				[1][2][3]
			</td>
		</tr>
		<tr>
			<td colspan="5">
				<button onClick="location.href='regist_form.jsp'">글등록</button>
			</td>
		</tr>
	</table>

</body>
</html>