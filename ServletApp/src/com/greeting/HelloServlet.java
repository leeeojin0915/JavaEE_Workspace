package com.greeting;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿이란? 자바클래스 중 오직 웹서버에서만 해석 및 실행 되어 질 수 있는 클래스
/*
 * 수업주제 : 서블릿의 생명주기 알아보기
 * 태어나는 시점? 최초의 요청이 있을 때 고양이 즉, 웹컨테이너에 의해 인스턴스가 메모리에 올라옴
 * 인스턴스가 생성될때 서블릿으로서 가져야할 정보를 고양이에게 넘겨받을 수 있는데 이때 사용되는 메서드가 init()
 * 즉, 서블릿은 태어날때 초기화 메서드에 의해 많은 정보를 갖게됨
 * */
public class HelloServlet extends HttpServlet{
	//이 메서드는 서블릿이 태어난 직후에 초기화 작업에 사용됨
	//또한 이 메서드는 Tomcat과 같은 웹 컨테이너에 의해 호출된다. 즉, 서블릿의 생성 및 생명주기 메서드
	//의 호출자는 바로 톰켓이다.
	public void init(ServletConfig config) throws ServletException {
		String msg=config.getInitParameter("msg");
		System.out.println("init() 호출시 넘겨받은 파라미터 정보는"+msg);
		
		//jsp내장객체 웹어플리케이션의 전역적 정보를 가진 객체..application
		ServletContext context=config.getServletContext();//jsp에서의 application 내장객체
		System.out.println(context.getRealPath("/"));
	}
	
	//서블릿이 일단 생성된 후, 초기화 까지 마치면 클라이언트의 요청을 처리할 준비가 된 것이고,
	//클라이언트의 요청을 처리하는 메서드가 바로 Service메서드
	//서비스메서드가 요청을 처리하려면 클라이언트의 요청정보와 클라이언트에게 보낼 응답정보를 필요하기 때문에
	//service() 메서드의 매개변수로 request,response객체가 전달되어야한다(고양이가다함)
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//클라이언트가 전송한 요청 정보 중 파라미터를 끄집어 내서 출력해본다
		String id=request.getParameter("id");
		//클라이언트에 전송
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.print("당신이 전송한 파라미터는 "+id);
	}
	//서블릿이 소멸할때 호출되는 메서드
	//서블릿이 보유한 자원을 반납할때 등에 사용(스트림,db닫음)
	public void destroy() {
		System.out.println("죽어요");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.print("hello servlet do");
	}
}
