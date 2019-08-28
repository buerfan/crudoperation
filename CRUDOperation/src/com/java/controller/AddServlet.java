package com.java.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.hibernate.Session;

import com.java.dao.DBData;
import com.java.model.Add;
import com.java.model.CustomerModel;
import com.java.model.PersonModel;
import com.mysql.jdbc.Blob;
import com.mysql.jdbc.Constants;

@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB 
maxFileSize=1024*1024*50,      	// 50 MB
maxRequestSize=1024*1024*100) 
public class AddServlet extends HttpServlet {

	
	public void doGet( HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException
	{
		String action=req.getParameter("action");
		RequestDispatcher rd=null;
		if(action.equals("addimage"))
		{
			CustomerModel add=new CustomerModel();
			req.setAttribute("customer", add);
			req.setAttribute("action", "addimage");
			rd=req.getRequestDispatcher("/add.jsp");
		}
		rd.forward(req, resp);
	}
	
	public void doPost( HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException
	{
		String action=req.getParameter("action");
		RequestDispatcher rd=null;
		System.out.println("Line 38:---"+action);
		
		if(action==null)
		{
			CustomerModel cm=new CustomerModel();
			cm.setFirstName(req.getParameter("firstname"));
			//String firstName = cm.getFirstName();
			//String lastName = req.getParameter("lastname");
			
			System.out.println(req.getParameter("firstName"));
			
			/*
			CustomerModel cm=new CustomerModel();
			
			
			Part part=req.getPart("file");
			String fileName=extractFileName(part);
			String savePath=("F:\\BU\\CSE\\Java Project\\CRUDOperation\\WebContent\\images\\"+File.separator+fileName);

			File fileSaveDir=new File(savePath);
			part.write(savePath+File.separator);
			
			System.out.println(cm.getFirstName().toString()+ "Path"+fileName+"Path"+savePath);
		*/
			rd=req.getRequestDispatcher("displaycustomer.jsp");
			/*
			Add add=new Add();
			
			add.setEmail(req.getParameter("email").toString());
			add.setName(req.getParameter("name").toString());
			//add.setIcon(req.getPart("icon").getInputStream());
			
			System.out.println(req.getParameter("email").toString());
			rd=req.getRequestDispatcher("displaycustomer.jsp");
			//DBData db=new DBData();
			//db.saveCustomer(add);
			*/
			
		}
		else
		{
			String firstName=req.getParameter("firstname").toString();
			String lastName=req.getParameter("lastname").toString();
			Part part=req.getPart("chooser");
			String fileName=getFileName(part);
			
			System.out.println("File Name:-"+fileName);
			
			
			//String savePath=("file:///F:/BU/CSE/Java%20Project/CRUDOperation/WebContent/images/"+File.separator+fileName);
			//String savePath=("G:\\images"+File.separator+fileName);
			String savePath=("F:\\BU\\CSE\\Java Project\\CRUDOperation\\WebContent\\images"+File.separator+fileName);

			File fileSaveDir=new File(savePath);
			part.write(savePath+File.separator);
			
			System.out.println(savePath);

			CustomerModel cm=new CustomerModel();
			
			cm.setFirstName(firstName);
			cm.setLastName(lastName);
			cm.setFileName(fileName);
			cm.setPath(savePath);
			
			
			DBData db=new DBData();
			db.saveCustomer(cm);
			
			/*
			PersonModel pm=new PersonModel();
			String firstName=req.getParameter("firstname").toString();
			String lastName=req.getParameter("lastname").toString();
			
			InputStream inputStream=null;
			
			Part path=req.getPart("chooser");
			System.out.println("Line 88");
			
			if(path!=null)
			{
				System.out.println("Path"+path.getName());
				
				//String fileName=Paths.get(, more)
				inputStream=path.getInputStream();
			}
			
			pm.setFirstName(req.getParameter("firstname"));
			pm.setLastName(req.getParameter("lastname"));
			pm.setPhoto((Blob) req.getPart("chooser"));
			
			DBData db=new DBData();
			db.savePerson(pm);
			
			req.setAttribute("firstname", firstName);
			req.setAttribute("lastname", lastName);
			
			System.out.println(firstName);
			*/
			/*
			Part part=req.getPart("file");
			String fileName=getFileName(part);
			String savePath=("F:\\BU\\CSE\\Java Project\\CRUDOperation\\WebContent\\images\\"+File.separator+fileName);

			File fileSaveDir=new File(savePath);
			part.write(savePath+File.separator);
			
			System.out.println(firstName+" Last Name"+lastName+ "Path"+fileName+"Path"+savePath);
			*/
			
			List<CustomerModel> customerModels=db.getAllCustomerModels();
			req.setAttribute("customers", customerModels);
			rd=req.getRequestDispatcher("displaycustomer.jsp");
		}
		rd.forward(req, resp);
	}

	private static String getSubmittedFileName(Part part) {
	    for (String cd : part.getHeader("content-disposition").split(";")) {
	        if (cd.trim().startsWith("filename")) {
	            String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
	            return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.
	        }
	    }
	    return null;
	}
	
	private String extractFileName(Part part) {
	    for (String content : part.getHeader("Content-Disposition").split(";")) {
	        if (content.trim().startsWith("filename"))
	            return content.substring(content.indexOf("=") + 2, content.length() - 1);
	        }
	    return null;
	}
	
	private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        System.out.println("content-disposition header= "+contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length()-1);
            }
        }
        return "";
    }
	
	private String extractFile_Name(Part part) {
		String contentDisp=part.getHeader("content-disposition");
		String[] items=contentDisp.split(";");
		for(String s:items)
		{
			if(s.trim().startsWith("filename"));
			{
				return s.substring(s.indexOf("=")+2, s.length()-1);
			}
		}
		return null;
	}
	
	
}
