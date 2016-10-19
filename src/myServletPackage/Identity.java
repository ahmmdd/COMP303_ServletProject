package myServletPackage;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet("/IF")
public class Identity extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Reading First and Last Name";
		out.println("<html>\n<head>\n<title>"+ title +"</title> "+ 
					"</head>\n<body bgcolor = \"#FDF5E6\">\n<h1>Reading First and Last Name</h1>"+
					"<ul>\n <li><b>First Name</b>: "+ request.getParameter("firstName") +"\n "+
					"</li>\n<li><b>Last Name</b>: "+ request.getParameter("lastName") +
					"\n </li></ul></body></html>");
	}
}
