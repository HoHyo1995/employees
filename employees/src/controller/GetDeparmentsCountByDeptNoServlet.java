package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;
import java.util.*;
@WebServlet("/departments/getDepartmentsCountByDeptNo")
public class GetDeparmentsCountByDeptNoServlet extends HttpServlet {
	DepartmentsDao departmentsDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 객체생성
		departmentsDao = new DepartmentsDao();
		// 리턴값을 받을 변수 생성 
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		// 변수를 이용해 리턴값을 받는다.
		list = departmentsDao.selectDepartmentsCountByDeptNo();
		// 리퀘스트에 담는다
		request.setAttribute("list", list);
		// 포워딩한다
		request.getRequestDispatcher("/WEB-INF/views/departments/selectDepartmentsCountByDeptNo.jsp").forward(request, response);
	}
}
