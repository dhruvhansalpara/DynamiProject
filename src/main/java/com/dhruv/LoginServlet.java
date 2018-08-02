package com.dhruv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dhruv.user.UserManager;


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
        
		UserManager userManager=new UserManager();
        String email = request.getParameter("email");
        String pwd = request.getParameter("pass");
        boolean isValid=userManager.validateUser(email, pwd);
        if (isValid) {
        	
        	String firstName=userManager.getFirstName(email);
            HttpSession session = request.getSession(true); // reuse existing
            session.setAttribute("user", firstName);
            
        
           //session.setMaxInactiveInterval(30); // 30 seconds
            response.sendRedirect("/userlistview?action=list");
        } else {
        
            response.sendRedirect("login.jsp");
        } // TODO Auto-generated method stub
        
        
        
	}

}
