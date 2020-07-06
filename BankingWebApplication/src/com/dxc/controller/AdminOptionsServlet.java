package com.dxc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.pojos.BankUser;
import com.dxc.services.AdminServiceImpl;
import com.dxc.services.IAdminService;

@WebServlet("/adminoption")
public class AdminOptionsServlet extends HttpServlet {
	
	IAdminService admins= new AdminServiceImpl();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String choice = request.getParameter("btn");
		//System.out.println(choice);
		HttpSession session = request.getSession();
		switch(choice)
		{
		case "Add User":
			try
			{
			int accno=Integer.parseInt(request.getParameter("accno"));
			String name= request.getParameter("name");
			double balance=Double.parseDouble(request.getParameter("balance"));
			boolean a=admins.addUser(accno, name, balance);
			if(a)
			{
				session.setAttribute("message","User Added Successfuly ");
				response.sendRedirect("view.jsp");
			}
			else
			{
				session.setAttribute("message","Some error occured!!! please try again ");
				response.sendRedirect("view.jsp");
			}
			}
			catch(Exception e)
			{
				session.setAttribute("message", "Enter all values!!!!");
				response.sendRedirect("view.jsp");
			}
			break;
			
		case "Search User":
			try
			{
			int saccno=Integer.parseInt(request.getParameter("accno"));
			BankUser user=admins.userDetails(saccno);
			if(user==null)
			{
				session.setAttribute("message", "Account number not found");
				response.sendRedirect("view.jsp");	
			}
			else
			{
			session.setAttribute("userdetails", user);
			response.sendRedirect("show.jsp");			  
			}
			}
			catch(Exception e)
			{
				session.setAttribute("message", "Enter accno!!!!");
				response.sendRedirect("view.jsp");
			}
			break;
			
		case "Modify User":
			try
			{
			int maccno=Integer.parseInt(request.getParameter("accno"));
			String mname=request.getParameter("name");
			boolean b=admins.modifyUser(maccno, mname);
			if(b)
			{
				session.setAttribute("message", "User updated Successfuly..");
				response.sendRedirect("view.jsp");	
			}
			else
			{
				session.setAttribute("message", "User account not found!!!!");
				response.sendRedirect("view.jsp");				  
			}
			}
			catch(Exception e)
			{
				session.setAttribute("message", "Enter accno!!!!");
				response.sendRedirect("view.jsp");
			}
			break;
			
		case "Balance Check":
			try
			{
			int baccno=Integer.parseInt(request.getParameter("accno"));
			double bal=admins.balanceCheck(baccno);
			
			if(bal<0)
			{
				session.setAttribute("message", "Account number not found");
				response.sendRedirect("view.jsp");	
			}
			else
			{
			String msg="Account Balance is: "+bal;
			session.setAttribute("message", msg);
			response.sendRedirect("view.jsp");			  
			}
			}
			catch(Exception e)
			{
				session.setAttribute("message", "Enter accno!!!!");
				response.sendRedirect("view.jsp");
			}
			break;
			
		case "close":
			try
			{
			int caccno=Integer.parseInt(request.getParameter("accno"));
			boolean c = admins.closeAccount(caccno);
			System.out.println(c);
			if(c)
			{
				session.setAttribute("message", "Account Closed Successfuly");
				response.sendRedirect("view.jsp");	
			}
			else
			{
			session.setAttribute("message", "Account number not found");
			response.sendRedirect("view.jsp");			  
			}
			}
			catch(Exception e)
			{
				session.setAttribute("message", "Enter accno!!!!");
				response.sendRedirect("view.jsp");
			}
			break;
			
			
		case "display":
			List<BankUser> ls=admins.showAll();
			if(ls.isEmpty())
			{
				session.setAttribute("message", "No user details available!!");
				response.sendRedirect("view.jsp");
			}
			else
			{
			session.setAttribute("allusers", ls);
			response.sendRedirect("showall.jsp");
			}
			break;
			
		case "logout":
			response.sendRedirect("home.html");
			break;
			
		default:
			session.setAttribute("message", "Something went wrong!!!");
			response.sendRedirect("view.jsp");
			break;
		
		}
	}

}
