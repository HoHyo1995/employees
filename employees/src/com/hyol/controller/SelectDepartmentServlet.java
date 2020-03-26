package com.hyol.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.hyol.model.DepartmentsDao;
import com.hyol.vo.Counting;


@WebServlet("/selectDepartments")
public class SelectDepartmentServlet extends HttpServlet {
	private DepartmentsDao departmentsDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션 검사
		HttpSession session = request.getSession();
		if(session.getAttribute("seno") == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		
		departmentsDao = new DepartmentsDao();
		List<Counting> list = departmentsDao.getTotalEmloyees();
		System.out.println(list);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/view/departmentsView.jsp").forward(request, response);
	}
}
