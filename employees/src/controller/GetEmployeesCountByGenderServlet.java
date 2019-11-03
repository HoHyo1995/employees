package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;
import model.*;

@WebServlet("/employees/getEmployeesCountByGender")
public class GetEmployeesCountByGenderServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 확인
		HttpSession session = request.getSession();
		if(session.getAttribute("sessionEmpNo") == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return ;
		}
		// 객체 생성
		employeesDao = new EmployeesDao();
		// 메소드로 리턴값을 값 변수 생성후 복사
		List<Map<String, Object>> list = employeesDao.selectEmployeesCountGroupByGender();
		// 리퀘스트에 담기
		request.setAttribute("list", list);
		// 포워드
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesCountByGender.jsp").forward(request, response);
	}
}
