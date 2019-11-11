package controller;

import java.io.IOException;
import vo.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	// login form
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	// login action
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// login.jsp에서 넘겨준 form태그를 받아서 확인한다.
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		int empNo = Integer.parseInt(request.getParameter("empNo"));
		System.out.println("firstName = "+firstName+"lastName = "+lastName+"empNo = "+empNo);
		// Employees 타입에 받은값들을 집어 넣는다.
		Employees employees = new Employees();
			employees.setFirstName(firstName);
			employees.setLastName(lastName);
			employees.setEmpNo(empNo);
		// login 메소드를 사용하기위한 객체 생성
		employeesDao = new EmployeesDao();
		// login메소드에서 리턴받은 값 받기
		int sessionEmpNo = employeesDao.login(employees);
		// 리턴받은값이 0이면 로그인 정보가 틀린것이므로 다시 로그인창으로 돌아간다.
		if(sessionEmpNo == 0) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		
		HttpSession session = request.getSession();
		// 세션에 로그인 정보를 넣어준다
		session.setAttribute("sessionEmpNo", sessionEmpNo);
		//포워드
		response.sendRedirect(request.getContextPath()+"/index");
		
	}

}
