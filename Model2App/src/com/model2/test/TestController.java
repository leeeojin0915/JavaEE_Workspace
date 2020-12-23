/*
 * 이 클래스는 하위 컨트롤러로서 역할을 수행해야 하므로
 * 반드시 Controller인터페이스를 구현해야한다
 * */
package com.model2.test;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.controller.Controller;
public class TestController implements Controller{

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//3단계
		String msg="테스트 입니다";
		//4단계결과 저장
		HttpSession session=request.getSession();
		session.setAttribute("result", msg);
	}

	public String getResultView() {
		return "/view/test/result";//파일명이 하드코딩 되어있다.
	}

	@Override
	public boolean isForward() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
