<%@page import="board.model.ImageBoardDAO"%>
<%@page import="java.io.File"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/lib.jsp"%>
<%
	//넘겨받은 board_id를 이용하여 삭제
	String board_id=request.getParameter("board_id");
	String filename=request.getParameter("filename");
	out.print("지우게 될 게시물 board_id는"+ board_id);
	
	//삭제업무(db,파일)
	
	//파일삭제(파일을 다룰 수 있는 클래스: java.io.File)
	File file=new File("D:/koreaIT/Workspace/javaEE_workspace/BoardApp2/WebContent/data/"+filename);
	if(file.delete()){
		ImageBoardDAO boardDAO=new ImageBoardDAO();
		boardDAO.delete(Integer.parseInt(board_id));//db삭제
		out.print(getMsgURL("삭제처리되었습니다.", "/imageboard/list.jsp"));
	}else{
		out.print(getMsgBack("삭제처리에 실패했습니다."));
	}
%>