/*
 * 삭제 요청을 처리하는 컨트롤러 정의
 * 
 * */
package com.webapp1216.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webapp1216.board.model.NoticeDAO;

public class DeleteServlet extends HttpServlet{
	NoticeDAO noticeDAO=new NoticeDAO();
	//삭제요청?get?post--둘다 가능하지만 어차피 파라미터가 notice_id밖에 없으므로 get으로 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String notice_id=request.getParameter("notice_id");
		int result=noticeDAO.delete(Integer.parseInt(notice_id));
		
		//컨트롤러가 클라이언트가 보게 될 메시지를 처리해야 한다?안한다?
		//alert()은 디자인
		HttpSession session=request.getSession();
		//result=0;
		if(result==0) {
			//실패 페이지를 보여준다 결국 에러에 대한 안내르 보여주는 페이지를 별도로 두고 그 페이지를 보여준다
			session.setAttribute("msg", "글이 삭제되지 않았습니다.관리자에게 문의하세요");
			response.sendRedirect("/error/message.jsp");
		}else {
			response.sendRedirect("/board/list");
		}
		
	}

}
