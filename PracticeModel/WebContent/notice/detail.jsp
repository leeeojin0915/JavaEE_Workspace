<%@page import="com.PracticeModel.domain.Notice"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%
	Notice notice = (Notice) request.getAttribute("notice");
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

* {
	box-sizing: border-box;
}

input[type=text], select, textarea {
	width: 100%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	margin-top: 6px;
	margin-bottom: 16px;
	resize: vertical;
}

input[type=button] {
	background-color: #4CAF50;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=button]:hover {
	background-color: #45a049;
}

.container {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function () {
	var bt_edit=$("input[type='button']")[0];
	var bt_del=$("input[type='button']")[1];
	
	$(bt_edit).click(function () {
		edit();
	});
	$(bt_del).click(function () {
		del();
	});
});
function regist() {
	$("form").attr({
		action:"regist.jsp",
		method:"post"
	});
	$("form").submit();
}
function edit() {
	if(confirm("수정하시겠어요?")){
	$("form").attr({
		action:"/notice/update.do",
		method:"post"
	});
	$("form").submit();
	}
}
function del() {
	if(confirm("삭제하시겠어요?")){
		location.href="/notice/delete.do?notice_id=<%=notice.getNotice_id()%>";
		}
	}
</script>
</head>
<body>

	<h3>글 상세보기</h3>

	<div class="container">
		<form>
			<input type="hidden" name="notice_id"
				value="<%=notice.getNotice_id()%>"> <input type="text"
				name="title" value="<%=notice.getTitle()%>"> <input
				type="text" name="writer" value="<%=notice.getWriter()%>">
			<textarea name="content" style="height: 200px"><%=notice.getContent()%></textarea>

			<input type="button" value="수정"> <input type="button"
				value="삭제"> <input type="button" value="목록보기"
				onClick="location.href='/notice/list.do'">
		</form>
	</div>

</body>
</html>