package com.java.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dao.DBData;
import com.java.model.AccountModel;

public class AccountServlet extends HttpServlet{
	
	DBData db=new DBData();
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd=null;
		
		String action=req.getParameter("action");
		if(action.equals("login"))
			{
				
				rd=req.getRequestDispatcher("/login.jsp");
			}
		else if(action.equals("signup"))
			{
			
				AccountModel accountModel=new AccountModel();
				
				req.setAttribute("accounts", accountModel);
				req.setAttribute("action","signup");
				rd=req.getRequestDispatcher("/signup.jsp");
			}
		rd.forward(req, resp);
	}

	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher rd=null;
		
		String action=req.getParameter("action");
		if(action.equals("login"))
			{
				AccountModel acc=new AccountModel();
				
				
				rd=req.getRequestDispatcher("/signup.jsp");
			}
		else if(action.equals("signup"))
			{
			
				AccountModel acc=new AccountModel();
				acc.setEmail(req.getParameter("email").toString());
				acc.setUsername(req.getParameter("username").toString());
				acc.setPassword(req.getParameter("password"));
				acc.setRepeatpassword(req.getParameter("repeatpassword"));
				
				db.saveAccount(acc);
				req.setAttribute("accounts", acc);
				req.setAttribute("action","login");
				rd=req.getRequestDispatcher("/login.jsp");
			}
		rd.forward(req, resp);
	}
}
