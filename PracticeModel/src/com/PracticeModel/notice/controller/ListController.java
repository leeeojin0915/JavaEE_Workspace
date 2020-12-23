package com.PracticeModel.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.PracticeModel.controller.Controller;
import com.PracticeModel.model.NoticeDAO;

public class ListController implements Controller{
	NoticeDAO noticeDAO=new NoticeDAO();
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List list=noticeDAO.selectAll();
		
		
		//HttpSession session=request.getSession();
		request.setAttribute("noticeList", list);
		
	}

	public String getResultView() {
		return "/view/notice/list";
	}

	public boolean isForward() {
		return true;
	}

}
