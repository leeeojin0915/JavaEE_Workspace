package com.model2.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.board.model.BoardDAO;
import com.model2.controller.Controller;
import com.model2.domain.Board;

public class DetailController implements Controller{
	BoardDAO boardDAO=new BoardDAO();
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Board board=boardDAO.select(Integer.parseInt(request.getParameter("board_id")));
		
		request.setAttribute("board", board);
		System.out.println("��ú��� ��Ʈ�ѷ����� �Ѱܹ��� ��û��ü "+request);
		System.out.println("��ú��� ��Ʈ�ѷ����� board"+board);
	}

	public String getResultView() {
		return "/view/board/detail";
	}

	public boolean isForward() {
		return true;
	}
	

}
