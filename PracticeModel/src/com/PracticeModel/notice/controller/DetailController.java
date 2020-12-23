package com.PracticeModel.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.PracticeModel.controller.Controller;
import com.PracticeModel.domain.Notice;
import com.PracticeModel.model.NoticeDAO;

public class DetailController implements Controller{
	NoticeDAO noticeDAO=new NoticeDAO();
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String notice_id=request.getParameter("notice_id");
		Notice notice=noticeDAO.select(Integer.parseInt(notice_id));
		
		request.setAttribute("notice", notice);
	}

	public String getResultView() {
		return "/view/notice/detail";
	}

	public boolean isForward() {
		return true;
	}
}
