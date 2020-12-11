<%@page import="board.model.QnA"%>
<%@page import="board.model.QnADAO"%>
<%@page contentType="text/html;charset=utf-8"%>
<%@include file="/inc/lib.jsp" %>
<%
	//넘겨받은 파라미터 값을 이용하여 답글 달자
	request.setCharacterEncoding("utf-8");
	String writer=request.getParameter("writer");
	String title=request.getParameter("title");
	String content=request.getParameter("content");
	String team=request.getParameter("team");//내본글팀
	String rank=request.getParameter("rank");//내본글랭크
	String depth=request.getParameter("depth");//내본글뎁스
	
	//넘겨받은 파라미터들을 하나의 VO에 보관
	QnA qna=new QnA();
	qna.setWriter(writer);
	qna.setTitle(title);
	qna.setContent(content);
	qna.setTeam(Integer.parseInt(team));
	qna.setRank(Integer.parseInt(rank));
	qna.setDepth(Integer.parseInt(depth));
	
	//답글을 달기 위한 쿼리문을 알아야 한다.
	//DAO에서 수행 할 것이지만 일단 이해를 위해 여기에 적는다
	//1단계 : 후발로 등록된 글이 들어갈 자리 확보(기존 글들을 밀어내는 효과)
	//String sql="update qna set rank=rank+1 where team="+team+" and rank>"+rank;
	//out.print(sql);
	//out.print("<br>");
	//2단계 : 내가 본 글의 바로 밑 답변 insert
	//sql="insert into qna(team,rank,depth) values("+team+","+(rank+1)+","+(depth+1)+")";
	//out.print(sql);
	QnADAO qnaDAO=new QnADAO();
	int result=qnaDAO.reply(qna);
	if(result==0){
		out.print(getMsgBack("답변등록실패"));
	}else{
		out.print(getMsgURL("답변등록성공", "/qna/list.jsp"));
	}
%>