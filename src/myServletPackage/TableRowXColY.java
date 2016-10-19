package myServletPackage;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletTableRowXColY")
public class TableRowXColY extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Lsb2_9 - Table Row X Column Y";
		
		out.println(
				"<!DOCTYPE html>\n<HTML>\n" +
				"<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
				"<BODY BGCOLOR=\"#FDF5E6\">\n" +
				"<H1 ALIGN=\"CENTER\">" + title + "</H1>\n");
		out.println("<table border=1 cellspacing=1 cellpadding=5>\n");
		for (int i=1;i<=10 ;i++) {
			out.println("<tr>");
			for (int j=1;j<=10;j++)              {
				out.println("<td>" +  (i + ", " + j) + "</td>");
			}             
			out.println("<tr>");
		}
		out.println("</table>");
		out.println("</BODY></HTML>");
	}
}
