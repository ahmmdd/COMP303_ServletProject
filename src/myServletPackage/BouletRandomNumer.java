package myServletPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ServletHelp.RandomUtilities;

@WebServlet("/ServletBouletRandomNumer")
public class BouletRandomNumer extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter myOutput = response.getWriter();
		
		myOutput.println("<!DOCTYPE html>\n <html>\n" + 
				"<head><title>Servlet Generating a HTML</title></head>\n<body bgcolor=\"fdf5e6\">\n" +
				"<h1>A Boulet List</h1>\n" + 
				"<h1>Great Inspiration for the Hangman Game</h1>\n" + 
				"<ul>\n" +
				"<li>" + RandomUtilities.randomInt(100) + "</li>\n" +
				"<li>" + RandomUtilities.randomInt(100) + "</li>\n" +
				"<li>" + RandomUtilities.randomInt(100) + "</li>\n" +
				"<li>" + RandomUtilities.randomInt(100) + "</li>\n" +
				"<li>" + RandomUtilities.randomInt(100) + "</li>\n" +
				"<li>" + RandomUtilities.randomInt(100) + "</li>\n" +
				"<li>" + RandomUtilities.randomInt(100) + "</li>\n" +
				"<li>" + RandomUtilities.randomInt(100) + "</li>\n" +
				"<li>" + RandomUtilities.randomInt(100) + "</li>\n" +
				"<li>" + RandomUtilities.randomInt(100) + "</li>\n" +
				"</ul>\n" + "</body></html>");
		
	}
}
