package com.hyol.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hyol.model.EmployeesDao;
import com.hyol.vo.Employees;


@WebServlet("/selectEmployees")
public class SelectEmployeesServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----selectEmployeesServlet-----");
		// 로그인 검사
		HttpSession session = request.getSession();
		if(session.getAttribute("seno") == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		// 페이징
		int currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int rowPerPage = 10;
		
		employeesDao = new EmployeesDao();
		List<Employees> list = employeesDao.getEmployees(currentPage, rowPerPage);
		System.out.println(list);
		int lastPage = employeesDao.getEmployeesCountWhere(rowPerPage);
		System.out.println("총 페이지 수"+lastPage);
		
		request.setAttribute("list", list);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("lastPage", lastPage);
		request.getRequestDispatcher("/WEB-INF/view/employeesList.jsp").forward(request, response);
	}
}
