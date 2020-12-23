/*
 * 기존의 jsp가 담당하고 있었던 컨트롤러의 업무를 현재클래스로 분리
 *그래야 jsp는 순수한 디자인이 딕 ㅣ대문에 유지보수시 교체까지 가능
 * */
package blood.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.Controller;

import blood.model.BloodAdvisor;

public class BloodController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String blood=request.getParameter("blood");
		
		//3단계
		BloodAdvisor advisor=new BloodAdvisor();
		String msg=advisor.getAdvice(blood);
		
		//결과에 대한 출력은 디자인인 view가 담당하므로 서블릿에서 처리하면 ㅏㄴ 된다
		//결과 jsp에서 메세지를 보여주려면 서버의 메모리에[ 임시적으로 저장해놓을 필욕 ㅏ있다
		//현재로서는 세셪ㄴ에 담자
		HttpSession httpSession=request.getSession();
		httpSession.setAttribute("msg", msg);
	} 
	public String getViewPage() {
		return "/blood/blood_result.jsp";
	}

}
