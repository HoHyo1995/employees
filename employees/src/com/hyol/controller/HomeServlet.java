package com.hyol.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hyol.model.DepartmentsDao;
import com.hyol.model.DeptEmpDao;
import com.hyol.model.DeptManagerDao;
import com.hyol.model.EmployeesDao;
import com.hyol.model.SalariesDao;
import com.hyol.model.TitlesDao;



@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----HomeServlet-----");
		// 세션검사(로그인 확인)
		HttpSession session = request.getSession();
		if(session.getAttribute("seno") == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		
		// 데이터 갯수를 나타내기위해서 객체생성
		DepartmentsDao departmentsDao = new DepartmentsDao();
		DeptEmpDao deptEmpDao = new DeptEmpDao();
		DeptManagerDao dpetMangerDao = new DeptManagerDao();
		EmployeesDao employeesDao = new EmployeesDao();
		SalariesDao salariesDao = new SalariesDao();
		TitlesDao titlesDao = new TitlesDao();
		
		// 받아온 갯수들 저장
		int departmentsCount = departmentsDao.getDepartmentsCount();
		int deptEmpCount = deptEmpDao.getDeptEmpCount();
		int deptManagerCount = dpetMangerDao.getDeptManagerCount();
		int employeesCount = employeesDao.getEmployeesCount();
		int salariesCount = salariesDao.getSalariesCount();
		int titlesCount = titlesDao.getTitlesCount();
		
		// 리퀘스트에 담기
		request.setAttribute("departmentsCount", departmentsCount);
		request.setAttribute("deptEmpCount", deptEmpCount);
		request.setAttribute("deptManagerCount", deptManagerCount);
		request.setAttribute("employeesCount", employeesCount);
		request.setAttribute("salariesCount", salariesCount);
		request.setAttribute("titlesCount", titlesCount);
		request.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(request, response);
	}

}
