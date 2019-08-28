package com.java.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dao.DBData;
import com.java.model.EmployeeModel;

public class EmployeeServlet extends HttpServlet {
	
	DBData db=new DBData();
public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		
	RequestDispatcher rd=null;
	//DBData db=new DBData();
	String action=req.getParameter("action");
	
	System.out.println(action+" Line 25");
	
	if(action!=null)
	{
		if(action.equals("new"))
		{
			EmployeeModel emp=new EmployeeModel();
			req.setAttribute("employee", emp);
			req.setAttribute("action", "new");
			rd=req.getRequestDispatcher("/register.jsp");
		}
		else if(action.equals("update"))
		{
			int id=Integer.parseInt(req.getParameter("id").toString());
			System.out.println("ID:"+id);
			
			EmployeeModel emp=db.getEmployeeById(id);
			req.setAttribute("employee", emp);
			req.setAttribute("action", "update");
			
			rd=req.getRequestDispatcher("/register.jsp");
		}
		else if(req.getParameter("action").toString().equals("delete"))
		{
			
			int id=Integer.parseInt(req.getParameter("id").toString());
			System.out.println("ID:"+id);
			
			EmployeeModel emp=new EmployeeModel();
			emp.setEmployeeId(id);
			
			db.deleteEmployee(emp);
			System.out.println("Successfully Deleted...");
			
			List<EmployeeModel> employeeModels=db.getAllEmployeeModels();
			req.setAttribute("employees", employeeModels);
			rd=req.getRequestDispatcher("/index.jsp");
		}
		
	}
	else {
		List<EmployeeModel> employeeModels=db.getAllEmployeeModels();
		
		req.setAttribute("employees", employeeModels);
		rd=req.getRequestDispatcher("/index.jsp");
	}	
	rd.forward(req, resp);
	}

public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		String action=req.getParameter("action").toString();
		
		System.out.println(action+" Line 77");
		RequestDispatcher rd=null;
		if(action.equals("new")) {
			
			EmployeeModel emp=new EmployeeModel();
			emp.setEmployeeName(req.getParameter("name").toString());
			emp.setNic(req.getParameter("nic").toString());
			emp.setDesignation(req.getParameter("designation").toString());
			emp.setEmail(req.getParameter("email").toString());
			emp.setCompany(req.getParameter("company").toString());
			
			//DBData db=new DBData();
			db.saveEmployee(emp);
			
			System.out.println(req.getParameter("employeeId").toString());
			System.out.println(req.getParameter("employeeId").toString());
			List<EmployeeModel> employeeModels=db.getAllEmployeeModels();
			req.setAttribute("employees", employeeModels);
			rd=req.getRequestDispatcher("/index.jsp");
			
		}else if(action.equals("update"))
		{
			EmployeeModel emp=new EmployeeModel();
			emp.setEmployeeName(req.getParameter("name").toString());
			emp.setNic(req.getParameter("nic").toString());
			emp.setDesignation(req.getParameter("designation").toString());
			emp.setEmail(req.getParameter("email").toString());
			emp.setCompany(req.getParameter("company").toString());
			
			System.out.println(req.getParameter("employeeId").toString());
			System.out.println(req.getParameter("employeeId").toString());
			emp.setEmployeeId(Integer.parseInt(req.getParameter("employeeId").toString()));
			
			//DBData db=new DBData();
			db.updateEmployee(emp);
			
			
			List<EmployeeModel> employeeModels=db.getAllEmployeeModels();
			req.setAttribute("employees", employeeModels);
			rd=req.getRequestDispatcher("/index.jsp");
		}
		
		rd.forward(req, resp);
	}
}
