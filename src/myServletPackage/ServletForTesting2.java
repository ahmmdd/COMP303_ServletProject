package myServletPackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servletPack.FilterServlet;

@WebServlet("/ServletFT2")
public class ServletForTesting2 extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "This Servlet uses the filter Servlet";
		String c = "Mohammed";
		out.println("<!DOCTYPE html>\n <html> \n"+
				"<head><title>This servlet uses filter servlet"+
				"</title></head>\n <body bgcolor=\"#fdf5e6\">\n"+
				"<h1>" + title + "</h1> \n"+
				"<p><h1>" + FilterServlet.performFilter(c)+ "</h1></p>\n\n" +
				"</body></html>");
	}
}
