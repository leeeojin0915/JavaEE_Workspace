/*
 * 코멘트 게시판의 리스트 요청을 처리하는 컨트롤러
 * 이 컨트롤러는 서블릿이 아니다 단지 서블릿 
 *  */

package com.model2.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.board.model.BoardDAO;
import com.model2.controller.Controller;

public class ListController implements Controller{
	BoardDAO boardDAO=new BoardDAO();
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("코멘트 게시판 목록 요청을 처리합니다.");
		List list=boardDAO.selectAll();
		
		request.setAttribute("boardList", list);
	}

	public String getResultView() {
		return "/view/board/list";
	}

	public boolean isForward() {
		return true;
	}

}
