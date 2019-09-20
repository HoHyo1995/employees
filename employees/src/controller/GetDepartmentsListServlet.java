package controller;
import java.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;
import vo.*;

@WebServlet("/departments/getDepartmentsList")
public class GetDepartmentsListServlet extends HttpServlet {
	// 리스트 타입의 list라는 변수 생성
	private List<Departments> list;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DepratmentsDao에 있는 메소드를 사용하기 위해 객체선언
		DepartmentsDao departmentDao = new DepartmentsDao();
		list = 
		
	}
}
