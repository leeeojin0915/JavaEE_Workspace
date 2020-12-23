package com.board1216.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board1216.board.model.NoticeDAO2;

public class ListServlet extends HttpServlet{
	NoticeDAO2 dao2=new NoticeDAO2();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List list=dao2.selectAll();
		HttpSession httpSession=request.getSession();
		httpSession.setAttribute("noticeList", list);
		
		response.sendRedirect("/board/list.jsp");
	}

}
