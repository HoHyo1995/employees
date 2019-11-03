package controller;
import java.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;
import vo.*;

@WebServlet("/departments/getDepartmentsList")
public class GetDepartmentsListServlet extends HttpServlet {
	// 리스트 타입의 list라는 변수 생성
	private List<Departments> list;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 확인
		HttpSession session = request.getSession();
		if(session.getAttribute("sessionEmpNo") == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return ;
		}		
		// DepratmentsDao에 있는 메소드를 사용하기 위해 객체선언
		DepartmentsDao departmentsDao = new DepartmentsDao();
		// 메소드에 리턴되는값이 List타입이므로 new 연산자를 굳이 사용해서 list변수에 List를 생성할 필요는 없다.,
		list = departmentsDao.selectDepartmentsList();
		
		//Attribute메소드를 사용해서 list값을 리퀘스트에 넣어준다.
		request.setAttribute("list", list);
		//포워드 ㄱㄱ
		request.getRequestDispatcher("/WEB-INF/views/departments/departmentsList.jsp").forward(request, response);
	}
}
