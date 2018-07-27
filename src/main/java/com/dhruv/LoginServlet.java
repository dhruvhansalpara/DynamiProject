package com.dhruv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        
        String un = request.getParameter("uname");
        String pwd = request.getParameter("pass");
        if (un.equals("test")) {
            HttpSession session = request.getSession(true); // reuse existing
            session.setAttribute("user", un);
           //session.setMaxInactiveInterval(30); // 30 seconds
            response.sendRedirect("Home.jsp");
        } else {
        
            response.sendRedirect("login.jsp");
        } // TODO Auto-generated method stub
        
        
        
	}

}
