package controller;
import vo.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;
import java.util.*;
@WebServlet("/employees/getEmployeesListBetween")
public class GetEmployeesListBetweenServlet extends HttpServlet {
	private EmployeesDao employeesDao;
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		// 로그인 확인
		HttpSession session = request.getSession();
		if(session.getAttribute("sessionEmpNo") == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return ;
		}
   		// 객체생성
   		employeesDao = new EmployeesDao();
   		// index에서 넘겨준 post방식의 begin, end 값을 변수로 받는다
   		int begin = Integer.parseInt(request.getParameter("begin"));
   		int end = Integer.parseInt(request.getParameter("end"));
   		// 메소드의 리턴값을 리스트 변수에 사한다. 
   		List<Employees> list = employeesDao.selectEmployeesListBetween(begin, end);
   		// list값을 리퀘스트에 담아준다
   		request.setAttribute("list", list);
   		// 포워드
   		request.getRequestDispatcher("/WEB-INF/views/employees/employeesListBetween.jsp").forward(request, response);
	}

}
