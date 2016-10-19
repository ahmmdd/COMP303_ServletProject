package myServletPackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ColorSizeWeight")
public class ColorSizeWeight extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request,
					  HttpServletResponse response) 
					  throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String doctype = "<!DOCTYPE html>\n";
		String html = "<html>\n";
		String title = "Readig 3 parapeters";
		
		out.println(doctype + html +
				"<HEAD><TITLE><" + title + "</TITLE></HEAD>\n" +
				"<BODY BGCOLOR=\"#FDF5E6\">\n" +
				"<H1 ALIGN=\"CENTER\">" + title + "</H1>\n"+
				"<ul>\n<li><b>Color: " + request.getParameter("Color") + 
				"\n</b></li>\n<li><b>Size: "+ request.getParameter("Size") + 
				"</b></li>\n<li><b>Weight:" + request.getParameter("Weight") + 
				"</b></li></ul></BODY></HTML>");
	}
}
