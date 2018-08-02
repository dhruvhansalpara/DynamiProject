package com.dhruv.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		 HttpSession session = request.getSession(true); // reuse existing
		 String usrName=(String)session.getAttribute("user");
		
		if (usrName!=null || true) {
			UserManager manager = new UserManager();
			List<User> listUser = manager.getUsers();
			request.setAttribute("userList", listUser);
			// response.sendRedirect("home.jsp");

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Home.jsp");
			requestDispatcher.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
