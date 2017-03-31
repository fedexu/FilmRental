<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.filmrental.model.Film"%>
<%@ page import="com.filmrental.model.User"%>
<%@ page import="com.filmrental.model.FilmRentVO"%>
<%@ page import="java.math.BigDecimal" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FilmRental User</title>
</head>
<body>
	<div>
		<h1>
			User:
			<%=session.getAttribute("Username")%></h1>
		<form action="/FilmRental/login/user/view" method="post">
			<input type="hidden" name="logout" value="logout" />
			<button type="submit">Logout</button>
		</form>
	</div>
	</br>
	<div>
		<h2>Film Rentable</h2>
	</div>
	<div>
		<table>
			<tr>
				<td>FILM_ID</td>
				<td>TITLE</td>
				<td>REGIST</td>
				<td>EXIT_YEAR</td>
				<td>QUANTITY</td>
				<td>
			</tr>
			<%
				if (request.getAttribute("films") != null) {
					int i = 0;
					List<Film> list = (List<Film>) request.getAttribute("films");
					BigDecimal[] number = (BigDecimal[]) request.getAttribute("number");

					for (Film f : list) {
						int n = f.getQuantity() - number[i].intValueExact();
			%>
			<form action="/FilmRental/login/user/rentfilm" method="post">
				<tr>
					<td><%=f.getFilmId()%><input type="hidden"
						name="Film_Id<%=i%>" value="<%=f.getFilmId()%>" /></td>
					<td><%=f.getTitle()%><input type="hidden" name="Title<%=i%>"
						value="<%=f.getTitle()%>" /></td>
					<td><%=f.getRegist()%><input type="hidden" name="Regist<%=i%>"
						value="<%=f.getRegist()%>" /></td>
					<td><%=f.getExitYear()%><input type="hidden"
						name="Exit_Year<%=i%>" value="<%=f.getExitYear()%>" /></td>
					<td><%=n%><input type="hidden" name="Quantity<%=i%>"
						value="<%=n%>" /></td>
					<td><button type="submit">Rent a Copy</button> <input
						type="hidden" name="rentfilm<%=i%>" value="rentfilm" /> <input
						type="hidden" name="rentfilm" value="on" /></td>
				</tr>
			</form>
			<%
				i++;
					}
			%>

		</table>
	</div>
	<%
		}
	%></br>

	<div>
		<h2>Film Rented</h2>
		<%
			List<FilmRentVO> listrented = (List<FilmRentVO>) request.getAttribute("ListRented");
			if (listrented != null) {
		%>
		<table>
			<tr>
				<td>RENT_ID</td>
				<td>FILM_ID</td>
				<td>TITLE</td>
				<td>ORDER_DATE</td>
				<td></td>
			</tr>
			<%
				int j = 0;
					for (FilmRentVO fr : listrented) {
						Film film = fr.getFilm();
			%>
			<form action="/FilmRental/login/user/returnfilm" method="post">
				<tr>
					<td><%=fr.getRentId()%><input type="hidden" name="Rent_Id"
						value="<%=fr.getRentId()%>" /></td>
					<td><%=film.getFilmId()%><input type="hidden" name="Film_Id"
						value="<%=film.getFilmId()%>" /></td>
					<td><%=film.getTitle()%></td>
					<td><%=fr.getOrderDate()%></td>
					<td><button type="submit">Return this copy</button> <input
						type="hidden" name="returnfilm" value="on" /></td>
				</tr>
			</form>
			<%
				}
			%>
		</table>
		<%
			}
		%>
	</div>
	</br>
	<div>
		<h2>Film Request</h2>
		<%
			if (request.getAttribute("ErrorRequest") != null) {
		%>
		<%=request.getAttribute("ErrorRequest")%>
		<%
			}
		%>
		<table>

			<tr>
				<td>Title:</td>
				<td>Regist:</td>
				<td>Exit_Year:</td>
				<td></td>
			</tr>

			<form action="/FilmRental/login/user/addfilmrequest" method="post">
			<tr>
				<td><input type="txt" name="Req_Title" /></td>
				<td><input type="txt" name="Req_Regist" /></td>
				<td><input type="txt" name="Req_Exit_Year" /></td>
				<td><button type="submit">Submit suggestion</button>
					<input type="hidden" name="Request" value="on" /></td>
			</tr>
			</form>

		</table>
		
		<%if(request.getAttribute("AddedRequest")!= null){ %>
		<%=request.getAttribute("AddedRequest")%>
		<%} %>
	</div>
	</br>

</body>
</html>
