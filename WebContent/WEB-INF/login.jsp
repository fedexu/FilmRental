<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.filmrental.model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to FilmRental BlackBlaster</title>
</head>
<body>
	<form action="/FilmRental/login" method="post">
		<div>
			<h1>Benvenuto su FilmRental BlackBlaster</h1>
		</div>
		</br>
		<div>
			<h2>Inserisci i tuoi dati di accesso</h2>
		</div>
		</br>
		<div>
			<h3>Username:</h3>
			<input type="text" name="Username" />
		</div>
		</br>
		<div>
			<h3>Password:</h3>
			<input type="password" name="U_Pass" />
		</div>
		</br>
		<button type="submit">Submit</button>
	</form>
	</br>
	
	<script>
var session_username = "<%=session.getAttribute("Username")%>";
console.log("session username"+session_username)

</script>


	<%
		if (request.getAttribute("error") != null && request.getAttribute("error").equals("error")) {
	%>
	<div>
		<h1>No ! You must do a login before !</h1>
	</div>
	<%
		}
	%>
	<%-- <% if (request.getAttribute("logout")==null) {%> --%>
	<%-- <% if(request.getAttribute("logfailure")!=null && request.getAttribute("logfailure").equals("logfailure")){ %> --%>
	<!-- <div><h1>Login failure. Please use a valid account !</h1></div> -->
	<%-- <%} --%>
	<%-- }else { %> --%>
	<!-- <div><h1>Logged out.</h1></div> -->
	<%-- <%}%> --%>

	<script>
var error = "<%=request.getAttribute("error")%>";
		console.log("error" + error);
	</script>
</body>
</html>