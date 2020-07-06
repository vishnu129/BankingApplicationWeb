package com.dxc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.services.IUserService;
import com.dxc.services.UserServiceImpl;
import com.sun.xml.internal.ws.resources.HttpserverMessages;

@WebServlet("/useroption")
public class UserOptionsServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		
		HttpSession session = request.getSession();
		IUserService users = new UserServiceImpl();
		
		int accno=(int)session.getAttribute("accno");
		
		String ch = request.getParameter("btn");
		//System.out.println(accno);
		//System.out.println(ch);
		
		switch(ch)
		{
		case "Deposit":
			try
			{
			double amount=Double.parseDouble(request.getParameter("amount"));
			double dbal=users.deposit(accno, amount);
			String mdeposit="New Balance is "+dbal+ " Rs";
			session.setAttribute("message", mdeposit);
			response.sendRedirect("view.jsp");
			}
			catch(Exception e)
			{
				session.setAttribute("message", "Enter amount!!!!");
				response.sendRedirect("view.jsp");
			}
			break;
		
		case "Transfer":
			try
			{
			int reciever = Integer.parseInt(request.getParameter("raccno"));
			double tamount = Double.parseDouble(request.getParameter("amount"));
			double balcheck=users.balanceCheck(accno);
			
			if(tamount>balcheck)
			{
				session.setAttribute("message", "Insufficient Balance in account!!!!!!!!!");
				response.sendRedirect("view.jsp");
			}
			else
			{
				
				double check = users.deposit(reciever, tamount);
				if(check<0)
				{
					session.setAttribute("message", "Reciever Account number not found!!");
					response.sendRedirect("view.jsp");
					
				}
				else
				{
				double afterbal=users.withdraw(accno, tamount);
				String withdrawm="New Balance of Account number: "+accno+" is "+afterbal+ " Rs";
				session.setAttribute("message", withdrawm);
				response.sendRedirect("view.jsp");
				}
			}
			
			}
			catch(Exception e)
			{
				session.setAttribute("message", "Enter accno and amount!!!!");
				response.sendRedirect("view.jsp");
			}
			
			break;
			
		case "Withdraw":
			try
			{
			double amount=Double.parseDouble(request.getParameter("amount"));
			double bal=users.balanceCheck(accno);
			if(amount>bal)
			{
				session.setAttribute("message", "Insufficient Balance in account!!!!!!!!!");
				response.sendRedirect("view.jsp");
			}
			else
			{
				double newbal=users.withdraw(accno, amount);
				String withdrawm="New Balance is "+newbal+ " Rs";
				session.setAttribute("message", withdrawm);
				response.sendRedirect("view.jsp");
				
			}
			}
			catch(Exception e)
			{
				session.setAttribute("message", "Enter amount!!!!");
				response.sendRedirect("view.jsp");
			}
			break;
			
		case "balance":
			double bal= users.balanceCheck(accno);
			String msg="Account Balance is: "+bal;
			session.setAttribute("message", msg);
			response.sendRedirect("view.jsp");
			break;
			
		case "statement":
			List<Double> state = new ArrayList<>();
			state=users.statement(accno);
			session.setAttribute("statement", state);
			response.sendRedirect("statement.jsp");
			break;
			
		case "Change":
			try
			{
			String pass=request.getParameter("password");
			String pass1=request.getParameter("password2");
			if(pass.equals(pass1))
			{
			users.changePassword(accno, pass);
			session.setAttribute("message", "Password changed Successfuly");
			response.sendRedirect("view.jsp");
			}
			
			else
			{
				session.setAttribute("message", "Password dont match!!");
				response.sendRedirect("view.jsp");
			}
			}
			catch(Exception e)
			{
				session.setAttribute("message", "Enter New Password!!!!");
				response.sendRedirect("view.jsp");
				
			}
			
			break;
			
		case "logout":
			session.invalidate();
			response.sendRedirect("home.html");
			break;
			
		default:
			session.setAttribute("message", "Something went wrong!!!");
			response.sendRedirect("view.jsp");
			break;
		}
	}

}

