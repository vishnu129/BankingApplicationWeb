 package com.dxc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.services.AdminServiceImpl;
import com.dxc.services.IAdminService;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	
	IAdminService admin = new AdminServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
		int id = Integer.parseInt(request.getParameter("id"));
		String password = request.getParameter("password");
		boolean stat= admin.adminLogin(id, password);
		
		if(stat ==true)
		{
		response.sendRedirect("adminoptions.jsp");
		}
		else
		{
			HttpSession session = request.getSession();
			session.setAttribute("message", "Admin Login Failed");
			response.sendRedirect("view.jsp");
		}
		}
		catch(Exception e)
		{
			HttpSession session = request.getSession();
			session.setAttribute("message", "No id or password entered!!!");
			response.sendRedirect("view.jsp");
		}
		
	}

}
