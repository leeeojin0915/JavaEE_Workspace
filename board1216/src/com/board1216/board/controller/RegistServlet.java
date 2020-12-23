package com.board1216.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board1216.board.model.Notice2;
import com.board1216.board.model.NoticeDAO2;

public class RegistServlet extends HttpServlet{
		NoticeDAO2 dao2=new NoticeDAO2();
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String title=request.getParameter("title");
		String writer=request.getParameter("writer");
		String content=request.getParameter("content");
		
		Notice2 notice2=new Notice2();
		notice2.setTitle(title);
		notice2.setWriter(writer);
		notice2.setContent(content);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.print(title);
		out.print(writer);
		out.print(content);
		
		int result=dao2.insert(notice2);
		if(result==0) {
			out.print("<script>");
			out.print("alert('등록실패')");
			out.print("history.back();");
			out.print("</script>");
		}else {
			out.print("<script>");
			out.print("alert('등록성공')");
			out.print("location.href='/board/list.jsp'");
			out.print("</script>");
		}
	}
}
