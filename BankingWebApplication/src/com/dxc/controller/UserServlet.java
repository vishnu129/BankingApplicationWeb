package com.dxc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.services.IUserService;
import com.dxc.services.UserServiceImpl;


@WebServlet("/user")
public class UserServlet extends HttpServlet {
	
	IUserService user= new UserServiceImpl();
 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		try
		{
		int acc = Integer.parseInt(request.getParameter("accno"));
		String password = request.getParameter("password");
		
		
		
		boolean stat= user.userLogin(acc, password);
		response.setContentType("text/html");
		if(stat ==true)
		{
		session.setAttribute("accno", acc);
		response.sendRedirect("useroptions.jsp");
		}
		else
		{
			session.setAttribute("message", "User Login Failed!!! check credentials");
			response.sendRedirect("view.jsp");
		}
		}
		catch(Exception e)
		{
			session.setAttribute("message", "No id or password entered!!!");
			response.sendRedirect("view.jsp");
		}
		}

}
