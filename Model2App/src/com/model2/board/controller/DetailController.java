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
		System.out.println("상시보기 컨트롤러에서 넘겨받은 요청객체 "+request);
		System.out.println("상시보기 컨트롤러에서 board"+board);
	}

	public String getResultView() {
		return "/view/board/detail";
	}

	public boolean isForward() {
		return true;
	}
	

}
