<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.filmrental.model.User"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to FilmRental BlackBlaster</title>
</head>
<body>
	<form:form action="login" method="post" modelAttribute="userlogin">
		<div>
			<h1>Benvenuto su FilmRental BlackBlaster</h1>
		</div>
		<br/>
		<div>
			<h2>Inserisci i tuoi dati di accesso</h2>
		</div>
		<br/>
		<div>
			<h3>Username:</h3>
			<form:input type="text" path="username" />
		</div>
		<br/>
		<div>
			<h3>Password:</h3>
			<form:input type="password" path="password" />
		</div>
		<br />
		<button type="submit">Submit</button>
	</form:form>
	<br/>

	<c:if test="${loginfailure != null}">
		${loginfailure}
	</c:if>
	
</body>
</html>