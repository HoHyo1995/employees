package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;
import java.util.*;

@WebServlet("/titles/getTitlesListDistinct")
public class GetTitlesListDistinctServlet extends HttpServlet {
	// 객체 변수 선언
	private TitlesDao titlesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//객체 생성
		titlesDao = new TitlesDao();
		// 리턴값을 받기위한 List 변수 생성
		List<String> list = new ArrayList<String>();
		list = titlesDao.selectTitlesListDistinct();
		// reponse에 return값을 담는다
		request.setAttribute("list", list);
		// 포워딩한다
		request.getRequestDispatcher("/WEB-INF/views/titles/titlesListDistinct.jsp").forward(request, response);
	}
}
