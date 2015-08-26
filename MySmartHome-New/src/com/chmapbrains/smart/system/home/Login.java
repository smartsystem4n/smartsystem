package com.chmapbrains.smart.system.home;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		if(request.getParameter("username").equals("admin") && request.getParameter("password").equals("admin")) 
		{
			//RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/home.html");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/home-image-switch.jsp");
			dispatcher.forward(request,response);
		}
		else
		{
			response.sendRedirect("login.html");
		}
	}

}
