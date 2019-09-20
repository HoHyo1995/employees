package controller;
import model.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/index 요청");
		
		
		this.employeesDao = new EmployeesDao();
		int employeesRowCount = employeesDao.selectEmployeesCount();
		
		// forward:/WEB-INF/views/index.jsp
		/*
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		rd.forward(request, response);
		*/
		
		// employeesRowCount를 request에 담는다
		request.setAttribute("employeesRowCount", employeesRowCount);
		
		request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
	}

}
