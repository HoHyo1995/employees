package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;
import vo.*;
import java.util.*;

@WebServlet("/employees/getEmployeesListOrderBy")
public class GetEmployeesListOrderByServlet extends HttpServlet {
	// 변수 생성
	private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 객체 생성
		employeesDao = new EmployeesDao();
		// index.jsp에서 넘어오는 order값 받고 확인하기
		String order = request.getParameter("order");
		System.out.println("GetEmployeesListOrderByServlet의 order값은?"+order);
		// 리턴값의 타입이 배열이므로 배열 생성
		// employeesDao에 있는 메소드를 사용하고 인수값은 order값을 넣어 메소드 실행 후 리턴 값 받기
		List<Employees> list = new ArrayList<Employees>();
		list = employeesDao.selectEmployeesOrderBy(order);
		// 리턴받은 값 request에 담아주기
		request.setAttribute("list", list);
		// 포워딩 하기
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesListOrderBy.jsp").forward(request, response);
	}

}
