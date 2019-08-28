

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccountServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd=null;
		
		String action=req.getParameter("action");
		if(action.equals("login"))
			{
				rd=req.getRequestDispatcher("/login.jsp");
			}
		else if(action.equals("signup"))
			{
				rd=req.getRequestDispatcher("/signup.jsp");
			}
		rd.forward(req, resp);
	}

	public void doPost(HttpServletRequest req,HttpServletResponse resp) {
		
	}
}
