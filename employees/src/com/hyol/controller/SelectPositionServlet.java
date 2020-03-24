package com.hyol.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SelectPosition")
public class SelectPositionServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----selectPositionServlet-----");
		// 세션검사
		HttpSession session = request.getSession();
		if(session.getAttribute("seno") == null) {
			response.sendRedirect(request.getContextPath()+"/login");
		}
		
		
		request.getRequestDispatcher("/WEB-INF/view/positionView.jsp").forward(request, response);
	}

}
