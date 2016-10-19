package myServletPackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletHtml")
public class ServletGeneratesHtml extends HttpServlet{
		@Override
		public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			response.setContentType("text/html");
			PrintWriter myOutput = response.getWriter();
			myOutput.println("<!DOCTYPE html>\n <html>\n" + 
					"<head><title>Servlet Generating a HTML</title></head>\n<body bgcolor=\"fdf5e6\">\n" +
					"<h1>Test of a Servlet Generating HTML</h1>\n" + 
					"<p>This is a HTML page, ..... no doubt!.</p>\n" + 
					"</body></html>");
		}
}
