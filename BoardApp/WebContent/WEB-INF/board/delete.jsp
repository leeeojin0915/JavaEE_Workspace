<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="db.DBManager"%>
<%@ page import="java.sql.*"%>
<%@ include file="/inc/lib.jsp"%>
<%
	DBManager dbManager=new DBManager();
	Connection con=dbManager.getConnection();
	PreparedStatement pstmt=null;

	String notice_id=request.getParameter("notice_id");
	String sql="delete from notice where notice_id="+notice_id;

	out.print(sql);

	pstmt=con.prepareStatement(sql);
	int result=pstmt.executeUpdate();
	//삭제 후 완료 메세지
	if(result==0){
		out.print(getMsgBack("삭제실패"));
	}else{
		out.print(getMsgURL("삭제성공","/board/list.jsp"));
	}
	dbManager.release(con,pstmt);
%>
