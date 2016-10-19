<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Lecture 2</title>
	</head>
	<body>
		<h1>Lecture 2</h1>
		<h3>Based on the date and time on the server (<%= new java.util.Date() %>), we are on track with our Curriculum Schedule</h3>
		<div>
		Servlets are:
			<ul>
				<li>
					Persistent since they are loaded once by the web server and can therefore maintain services between requests (e.g. database connection)
				</li>
				<li>
					Fast because the initialization code is done only once and not with request. Also loaded only once.
				</li>
				<li>
					Platform independent because they are written in Java.
				</li>
				<li>
					Extensible, easier to maintain because Java is OO programming language.
				</li>
			</ul>
		</div>
	</body>
</html>

