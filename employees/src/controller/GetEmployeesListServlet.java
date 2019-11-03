package controller;
import model.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;
import vo.*;


@WebServlet("/employees/getEmployeesList")
public class GetEmployeesListServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 확인
		HttpSession session = request.getSession();
		if(session.getAttribute("sessionEmpNo") == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return ;
		}
		// 한번에 출력할 갯수를 정하기 위해 limit이란 변수를 생성
		int limit = 10;
		// 한번에 출력할 갯수를 웹에서 정할 수 있게 하기위해서 사용 select태그 사용후 request로 받아올 예정
		if(request.getParameter("limit") != null) {
			limit = Integer.parseInt(request.getParameter("limit"));
		}
		// EmployeesDao에있는 ,...list메소드를 사용하기위해 객체를 선언한다
		 employeesDao = new EmployeesDao();
		// return값이 ArrayList<Employees>라서 new연산자를 사용하지 않아도 된다.
		List<Employees> list = employeesDao.selectEmployeesList(limit);
		// request에 list라는 이름으로 list값을 보낸다
		request.setAttribute("list", list);
		// 포워드 ㄱㄱ
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesList.jsp").forward(request, response);
	}



}
