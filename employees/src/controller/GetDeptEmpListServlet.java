package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DeptEmpDao;
import vo.DeptEmp;


@WebServlet("/deptEmp/getDeptEmpList")
public class GetDeptEmpListServlet extends HttpServlet {
	private DeptEmpDao deptEmpDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 확인
		HttpSession session = request.getSession();
		if(session.getAttribute("sessionEmpNo") == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return ;
		}
		// 페이징 (기본페이지 1로 지정)
		int currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		System.out.println("curretnPage의 값은"+ currentPage);
		// limit 넘어 온지 안넘어 온지 확인 기본은 10이다
		int limit = 10;
		if(request.getParameter("limit") !=null) {
			limit = Integer.parseInt(request.getParameter("limit"));
		}
		System.out.println("limit의 값은"+ limit);
		int rowPerPage = limit;
		if(request.getParameter("rowPerPage") !=null) {
			rowPerPage = Integer.parseInt(request.getParameter("rowPerPage"));
		}
		// 객체생성
		deptEmpDao = new DeptEmpDao();
		// 마지막 페이지를 위해서 전체행의 수를 카운트 한다
		int totalRow = deptEmpDao.selectDeptEmpCount();
		// 리스트 출력을 위한 값을 받기 위해 현재페이지와 페이지당 출력갯수를 인수로 보낸다
		List<DeptEmp> list = deptEmpDao.getDeptEmpList(currentPage, rowPerPage);
		// request에 담아서 보내준다
		request.setAttribute("list", list);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalRow", totalRow);
		request.setAttribute("rowPerPage", rowPerPage);
		// 포워드
		request.getRequestDispatcher("/WEB-INF/views/deptEmp/deptEmpList.jsp").forward(request, response);
	}
}
