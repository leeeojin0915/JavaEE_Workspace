<%@page import="board.model.CommentsDAO"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@include file="/inc/lib.jsp" %>
<%
	//여기서 쿼리실행 할 것은 아니지만 계획을 위해
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="comments" class="board.model.Comments"/>
<jsp:setProperty property="*" name="comments"/>
<%
	if(new CommentsDAO().insert(comments)==0){
		out.print(getMsgBack("댓글 등록 실패"));
	}else{
		out.print(getMsgURL("댓글이 등록되었습니다.", "detail.jsp?news_id="+comments.getNews_id()));
	}
%>


<%/*select t.topcategory_id, t.name, count(s.name) from topcategory t, subcategory s
    	where t.topcategory_id = s.topcategory_id
    	group by t.topcateogory_id, t.name;
	--뉴스와 댓글 게시판을 조인하여 그룹화
	select n.news_id, n.title ,count(comments_id) from news n, comments c where n.news_id=c.news_id 
	group by n.news_id, title;

조인의 종류는 크게 2가지
1)inner join(부,자간 공통 컬럼을 통해 엮는다)
	-우리가 그동안 사용했던 조인은 inner join
  ->단점)공통되지 않는 레코드는 누락됨
2)outer join은 (부,자간 공통 컬럼+공통되지 않은 것까지 몽땅 가져옴)
  select 
  form news n left outer join comments c
  on n.news_id=c.news_id;

select * from topcategory t, subcategory s where t.topcategory_id=s.topcategory_id
-> group by t.topcategory_id;

*/
    	
    	
    	%>