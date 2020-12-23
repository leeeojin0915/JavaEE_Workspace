package com.model2.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.board.model.BoardDAO;
import com.model2.controller.Controller;
import com.model2.domain.Board;

public class EditController implements Controller{
	BoardDAO boardDAO=new BoardDAO();
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Board board=new Board();
		String title=request.getParameter("title");
		String writer=request.getParameter("writer");
		String content=request.getParameter("content");
		String board_id=request.getParameter("board_id");
		board.setBoard_id(Integer.parseInt(board_id));
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		
		//3�ܰ�
		int result=boardDAO.update(board);
		
		//4�ܰ�:���� �� ������������, ������ ������ �����ϱ⿡ ������ ���� �ִ�
		request.setAttribute("result", result);
		request.setAttribute("board", board);
	}

	public String getResultView() {
		return "/view/board/edit";
	}

	public boolean isForward() {
		return true;
	}
	

}
