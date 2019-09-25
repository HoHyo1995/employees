package controller;
import vo.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;
import java.util.*;
@WebServlet("/employees/getEmployeesListByPage")
public class GetEmployeesListByPageServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 객체생성(employeesDao의 메소드를 사용하기위해서)
		employeesDao = new EmployeesDao();
		// currentPage 설정
		// 시작 페이지를 1로 잡음
		int currentPage = 1;
		if (request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		// 페이지당 볼 갯수는 index에서 10씩 본다고 했으므로 10으로 설정
		int rowPerPage = 10;
		// employeesDao의 메소드를 이용하여  출력값을 받아오고 새로 생성한 변수에 복사한다.
		List<Employees> list = employeesDao.getEmployeesListByPage(currentPage, rowPerPage);
		// 다음 페이지가 마지막장에서는 없어야하는데 그러기위해서 마지막페이지를 구하는 메소드가 필요하다
		int lastPage = employeesDao.selectLastPage(rowPerPage);
		
		// jsp에서 출력하기 위해서는 request에 담겨있는 값을 받아와야해서 넣어준다
		request.setAttribute("list", list);
		// 이전, 다음 페이지를 만들떄 currentPage값도 필요함 (조건을 넣어줘야해서)
		request.setAttribute("currentPage", currentPage);
		// 마지막장에서 다음이 안떠야하기떄문에  lastPage도 jsp로 넘겨준다
		request.setAttribute("lastPage", lastPage);
		// 포워드 할 주소를 정해준다
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesListByPage.jsp").forward(request, response);
	}
	
}
