<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.filmrental.model.Rents" %>
<%@ page import="com.filmrental.model.Films" %>
<%@ page import="java.math.BigInteger" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>USER</title>
</head>
<body>

<h1>YOU ARE LOGGED IN AS: ${userName}</h1>

<br>
<table style="widtd:100%">
  <tr>
   <th>RENTED TITLES:</th>
  </tr>
  
  <% List<Rents> listRents = (List<Rents>) request.getAttribute("filmsOwned"); 
	 for(int i = 0; listRents != null && i<listRents.size(); i++) {
		out.println("<tr>");
		out.print("<td>"+listRents.get(i).getFilm().getTitle()+"</td>");
		out.print("<td><form action='returnFilm' method='post'>"+
		"<input type= 'hidden' name='returnId' value=' "+listRents.get(i).getId()+"'/>" +	
		"<button>RETURN</button></form></td>");
		out.println("</tr>");
	 }
  %>
</table>
  
<br>


<table style="widtd:100%">
  <tr>
   <th>TITLES AVAILABLE TO RENT:</th>
   <th></th>
  </tr>
   <% List<Films> listAvail = (List<Films>) request.getAttribute("filmsAvailable"); 
	 for(int i=0; listAvail != null && i<listAvail.size(); i++) {
		out.println("<tr>");
		out.print("<td>"+listAvail.get(i).getTitle()+"</td>");
		out.print("<td>"+listAvail.get(i).getCopies()+" copies left. </td>");
		out.print("<td><form action='rentFilm' method='post'>"+
		"<input type= 'hidden' name='filmId' value= '"+listAvail.get(i).getId()+"'/>" +	
		"<button>RENT</button></form></td>");
		out.println("</tr>");
	 }
  %>
  </table>

<br>


Compile the following form to request a title to be added to our collection:
  <form method="post" action="addFilmRequest">
  Title: <input type="text" name="filmTitle"/>
  Year: <input type="text" name="year"/>
  <button>Request</button>
  </form>

</body>