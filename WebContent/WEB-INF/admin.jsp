<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.filmrental.model.Films" %>
<%@ page import="com.filmrental.model.Rents" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADMIN</title>
</head>
<body>
  <h1>WELCOME ADMINISTRATOR ${username} </h1>
  
  <h2>RENTS CURRENTLY ACTIVE:</h2>
  <table style="widtd:100%">
  <tr>
    <th>Username</th>
	<th>Title</th>
  </tr>
  
  <% List<Rents> listRents = (List<Rents>) request.getAttribute("currentRents"); 
	 for(int i = 0; i<listRents.size(); i++) {
		out.println("<tr>");
		out.print("<td>"+listRents.get(i).getUser().getUsername()+"</td>");
		out.print("<td>"+listRents.get(i).getFilm().getTitle()+"</td>");
		out.println("</tr>");
	 }
  %>
  </table>
  <br>
  
  <h2>ADD A FILM:</h2>
  <form action="addToCollection" method="post">
  TITLE: <input type= "text" name="filmTitle"/>
  QUANTITY: <input type="text" name="quantity"/>
  <button>RENT</button></form>
  <br>
  
  <h2>SUGGESTIONS:</h2>
  <table style="widtd:100%">
  <tr>
    <th>Title</th>
  </tr>
  <% List<Films> listFilms = (List<Films>) request.getAttribute("suggestedTitles"); 
	 for(int i = 0; i<listFilms.size(); i++) {
		out.println("<tr>");
		out.print("<td>"+listFilms.get(i).getTitle()+"</td>");
		out.print("<td><form action='addToCollection' method='post'>"+
		"<input type= 'hidden' name='filmTitle' value='"+listFilms.get(i).getTitle()+"'/>" +	
		"Quantity: <input type= 'number' name='quantity'/><button>ADD</button></form></td>");
		out.println("</tr>");
		
	 }
  %>
  </table>

</body>
</html>