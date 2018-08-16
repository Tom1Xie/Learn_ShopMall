package com.tomxieshopmall.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean isRegisterSuccessful = true;
		
		request.setCharacterEncoding("UTF-8");
		
		request.getParameterMap();

		if (isRegisterSuccessful) {
			// if the customer registered successfully

			response.sendRedirect(request.getContextPath() + "/registerSuccess.jsp");
		} else {
			// if the registration failed,just jump to "registerFail.jsp"
			response.sendRedirect(request.getContextPath() + "/registerFail.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
