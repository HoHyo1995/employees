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
	// 변수 선언
	private EmployeesDao employeesDao;
	private DepartmentsDao departmentsDao;
	private DeptEmpDao deptEmpDao;
	private DeptManagerDao deptManagerDao;
	private SalariesDao salariesDao;
	private TitlesDao titlesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 객체를 생성
		this.employeesDao = new EmployeesDao();
		this.departmentsDao = new DepartmentsDao();
		this.deptEmpDao = new DeptEmpDao();
		this.deptManagerDao = new DeptManagerDao();
		this.salariesDao = new SalariesDao();
		this.titlesDao = new TitlesDao();
		// 행을 구하는 메소드의 리턴값들을 변수에 복사
		int employeesRowCount = employeesDao.selectEmployeesCount();
		System.out.println("employees행"+employeesRowCount);
		int departmentsRowCount = departmentsDao.selectDepartmentsCount();
		System.out.println("departments행"+departmentsRowCount);
		int deptEmpRowCount = deptEmpDao.selectDeptEmpCount();
		System.out.println("deptEmp행"+deptEmpRowCount);
		int deptManagerRowCount = deptManagerDao.selectDeptManagerCount();
		System.out.println("dpetManager행"+deptManagerRowCount);
		int salariesRowCount = salariesDao.selectSalariesCount();
		System.out.println("salaries행"+salariesRowCount);
		int titlesRowCount = titlesDao.selectTitlesCount();
		System.out.println("titles행"+titlesRowCount);
		
		// employeesRowCount를 request에 담는다
		// request에 각 변수들을 담는다
		request.setAttribute("employeesRowCount", employeesRowCount);
		request.setAttribute("departmentsRowCount", departmentsRowCount);
		request.setAttribute("deptEmpRowCount", deptEmpRowCount);
		request.setAttribute("deptManagerRowCount", deptManagerRowCount);
		request.setAttribute("salariesRowCount", salariesRowCount);
		request.setAttribute("titlesRowCount", titlesRowCount);
		
		request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
	}

}
