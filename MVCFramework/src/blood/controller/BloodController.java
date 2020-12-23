/*
 * ������ jsp�� ����ϰ� �־��� ��Ʈ�ѷ��� ������ ����Ŭ������ �и�
 *�׷��� jsp�� ������ �������� �� �Ӵ빮�� ���������� ��ü���� ����
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
		
		//3�ܰ�
		BloodAdvisor advisor=new BloodAdvisor();
		String msg=advisor.getAdvice(blood);
		
		//����� ���� ����� �������� view�� ����ϹǷ� �������� ó���ϸ� ���� �ȴ�
		//��� jsp���� �޼����� �����ַ��� ������ �޸𸮿�[ �ӽ������� �����س��� �ʿ� ���ִ�
		//����μ��� ���l���� ����
		HttpSession httpSession=request.getSession();
		httpSession.setAttribute("msg", msg);
	} 
	public String getViewPage() {
		return "/blood/blood_result.jsp";
	}

}
