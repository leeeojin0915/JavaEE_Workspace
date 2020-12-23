package com.PracticeModel.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.PracticeModel.controller.Controller;
import com.PracticeModel.domain.Notice;
import com.PracticeModel.model.NoticeDAO;

public class RegistController implements Controller{
	NoticeDAO noticeDAO=new NoticeDAO();
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title=request.getParameter("title");
		String writer=request.getParameter("writer");
		String content=request.getParameter("content");
		Notice notice=new Notice();
		notice.setTitle(title);
		notice.setWriter(writer);
		notice.setContent(content);
		
		int result=noticeDAO.insert(notice);
		//가져와야할 정보만 저장=4단계
	}

	public String getResultView() {
		return "/view/notice/regist";
	}

	public boolean isForward() {
		return false;
	}

}
