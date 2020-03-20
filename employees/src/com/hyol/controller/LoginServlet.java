package com.hyol.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.hyol.model.EmployeesDao;
import com.hyol.vo.Employees;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Login  get");
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Login  post");
		
		// form태그로 넘겨준 정보 저장
		Employees employees = new Employees();
		employees = new Employees();
		employees.setEmpNo(Integer.parseInt(request.getParameter("no")));
		employees.setLastName(request.getParameter("name"));
		System.out.println(employees.toString());
		employeesDao = new EmployeesDao();
		int sessionEmpNo = employeesDao.compareEmployees(employees);
		if (sessionEmpNo == 0) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		// 세션에 저장(seno라는 이름으로 저장)
		HttpSession session = request.getSession();
		session.setAttribute("seno", sessionEmpNo);
		request.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(request, response);
	}

}
