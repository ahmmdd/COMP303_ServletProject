package myServletPackage;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Lorentz")
public class LorentzServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			String doctype = "<!DOCTYPE html>\n";
			String bHTML = "<html>\n";
			String bHead = "<head>\n";
			String bTitle = "<title>\n";
			String eTitle = "</title>\n";
			String eHead = "</head>\n";
			String bBody = "<body BGCOLOR=\"#FDF5E6\">\n";
			String bH1 = "<H1 ALIGN=\"CENTER\">";
			String eH1 = "</H1>\n";
			String bUl = "<ul>\n";
			String bLi = "<li>\n";
			String bB = "<b>\n";
			String eB = "</b>\n";
			String eLi = "</li>\n";
			String eUl = "</ul>\n";
			String eBody = "</body>\n";
			String eHTML = "</html>\n";

			String title = "Registering";
			String firstName = request.getParameter("FirstName");
			String lastName = request.getParameter("LastName");
			double height = Double.parseDouble(request.getParameter("Height"));
			double weight = Double.parseDouble(request.getParameter("Weight"));
			String gender = request.getParameter("Gender");
			double idealWeight, diff;
			
			out.println(doctype + bHTML + bHead + bTitle + title + eTitle
					+ eHead + bBody + bH1 + title + eH1);
			
					
			if(firstName == null || (firstName = htmlFilter(firstName.trim())).length() == 0 ||
				lastName == null || (lastName = htmlFilter(lastName.trim())).length() == 0 ||
				height == null || (height = htmlFilter(height.trim())).length() == 0 ||
				weight == null || (weight = htmlFilter(weight.trim())).length() == 0 || 
				gender == null || (gender = htmlFilter(gender.trim())).length() == 0){
				out.println("<p>Gender: MISSING</p>");
			}else if (gender.toUpperCase().equals("M") || gender.toUpperCase().equals("MALE")) {
				idealWeight = (height - 100) - ((height - 150)/4);
				diff = weight - idealWeight;
				if(diff < 0){
					diff *= -1;
					out.println("Hello " + firstName + " " + lastName + ", you need to gain " + diff + " kg.");
				}else{
					out.println("Hello " + firstName + " " + lastName + ", you need to lose " + diff + " kg.");
				}
	         } else if (gender.toUpperCase().equals("F") || gender.toUpperCase().equals("FEMALE")) {
	        	 idealWeight = ((height - 100) - ((height - 150)/2.5));
	        	 diff = weight - idealWeight;
					if(diff < 0){
						diff *= 1;
						out.println("Hello " + firstName + " " + lastName + ", you need to gain " + diff + " kg.");
					}else{
						out.println("Hello " + firstName + " " + lastName + ", you need to lose " + diff + " kg.");
					}
	         }else{}
			
			
			out.println(eBody + eHTML);
		} finally {
			out.close();
		}
	}
	///*
	private String htmlFilter(String message) {
		if (message == null) return null;
		int len = message.length();
		StringBuffer result = new StringBuffer(len + 20);
		char aChar;

		for (int i = 0; i < len; ++i) {
			aChar = message.charAt(i);
			switch (aChar) {
				case '<': result.append("&lt;"); break;
				case '>': result.append("&gt;"); break;
				case '&': result.append("&amp;"); break;
				case '"': result.append("&quot;"); break;
				default: result.append(aChar);
			}
		}
		return (result.toString());
	}
	//*/
}
