package com.hyol.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hyol.model.SalariesDao;
import com.hyol.vo.Salaries;


@WebServlet("/selectSalaries")
public class SelectSalariesEmp extends HttpServlet {
	private SalariesDao salariesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 검사
		HttpSession session = request.getSession();
		if(session.getAttribute("seno") == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		System.out.println("---selectSalariesEmp----");
		salariesDao = new SalariesDao();
		List<Salaries> list = salariesDao.getSalariesEmp();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/view/salariesTop.jsp").forward(request,response);
	}
}
