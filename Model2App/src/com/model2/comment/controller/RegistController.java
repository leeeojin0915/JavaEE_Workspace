/*
 * 댓글 등록요청을 처리하는 컨트롤러
 * */
package com.model2.comment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.comment.model.CommentDAO;
import com.model2.controller.Controller;
import com.model2.domain.Comment;

public class RegistController implements Controller{
	CommentDAO commentDAO=new CommentDAO();
	
	//댓글의 등록은 비동기요청으로 들어오기 때문에 응답정보는 페이지를 보여주는게 아니라
	//데이터를 전송해야 함
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터값이 넘어오는지 부터 확인
		String msg=request.getParameter("msg");
		String author=request.getParameter("author");
		String board_id=request.getParameter("board_id");
//		System.out.println("msg:"+msg);
//		System.out.println("author:"+author);
		
		//vo에 담기
		Comment comment=new Comment();
		comment.setMsg(msg);
		comment.setAuthor(author);
		comment.setBoard_id(Integer.parseInt(board_id));
		
		int result=commentDAO.insert(comment);
		
		//4단계생략 저장 할 것 X
		//DML 수행결과 저장
		request.setAttribute("result", result);//boxing??이머야...
	}

	public String getResultView() {
		return "/view/comment/regist";//등록결과를 클라이언트에게 보여줄 jsp 키 값
	}

	public boolean isForward() {
		return true;
	}

}
