package myServletPackage;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/RegistrationForm")
public class RegistrationForm extends HttpServlet {
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
			String firstName = "<b>First Name: </b>";
			String lastName = "<b>Last Name: </b>";
			String cellPhone = "<b>Cell Phone: </b>";
			String emailAddress = "<b>Email Address: </b>";

			String getFirstName = request.getParameter("FirstName");
			String getLastName = request.getParameter("LastName");
			String getCellPhone = request.getParameter("CellPhone");
			String getEmailAddress = request.getParameter("Email");

			out.println(doctype + bHTML + bHead + bTitle + title + eTitle
					+ eHead + bBody + bH1 + title + eH1 + bUl + bLi + bB
					+ firstName + eB);
			
			/* First Name */
			if (getFirstName == null || (getFirstName = htmlFilter(getFirstName.trim())).length() == 0) {
				out.println("<b><font color = \"FF0000\">Missing First Name</font></b>\n" + eLi);
			} else { out.println(getFirstName + eLi); }
			
			/* Last Name */
			 out.println(bLi + bB + lastName + eB);
			if (getLastName == null || (getLastName = htmlFilter(getLastName.trim())).length() == 0) {
				out.println("<b><font color = \"FF0000\">Missing Last Name</font></b>\n" + eLi);
			} else { out.println(getLastName + eLi); }

			/* Cell Phone */
			 out.println(bLi + bB + cellPhone + eB);
			if (getCellPhone == null || (getCellPhone = htmlFilter(getCellPhone.trim())).length() == 0) {
				out.println("<b><font color = \"FF0000\">Missing Cell Phone Number</font></b>\n" + eLi);
			} else { out.println(getCellPhone + eLi); }

			/* Email Address */
			 out.println(bLi + bB + emailAddress + eB);
			if (getEmailAddress == null || (getEmailAddress = htmlFilter(getEmailAddress.trim())).length() == 0) {
				out.println("<b><font color = \"FF0000\">Missing Email Address</font></b>\n" + eLi);
			} else { out.println(getCellPhone + eLi); }
			
			out.println(eUl + eBody + eHTML);
		} finally {
			out.close();
		}
	}

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
}
