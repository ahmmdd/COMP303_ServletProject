/**
 * Team 3
 * Member(s):
 * 			  Mohammed Juned Ahmed
 * 			  Avneet Kaur
 * 			  Micheal John Chua
 * 			  Derek Wong
 */
package myServletPackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ServletHelp.GrindTable;

@WebServlet("/ServletMagicSquare")
public class MagicSquare extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String doctype = "<!DOCTYPE html>\n";
		String html = "<html>\n";
		String title = "Assignment 2 - MagicSquare";
		int size = Integer.parseInt(request.getParameter("size"));
		out.println(doctype + html +
				"<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
				"<BODY BGCOLOR=\"#FDF5E6\">\n" +
				"<H1 ALIGN=\"CENTER\">" + title + "</H1>\n"+
				"<table align=center border=1 cellspacing=1 cellpadding=5>\n"+
				GrindTable.returnMagicSquare(size) + "</table></BODY></HTML>");
	}
}
