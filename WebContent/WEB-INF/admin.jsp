<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.filmrental.model.Film"%>
<%@ page import="com.filmrental.model.User"%>
<%@ page import="com.filmrental.model.FilmRent"%>
<%@ page import="com.filmrental.model.FilmRequest"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Filmrental BlackBlaster</title>
</head>
<body>
	<div>
		<h1>Welcome home, master!</h1>

		<form action="/FilmRental/login/user/view" method="post">
			<input type="hidden" name="logout" value="logout" />
			<button type="submit">Logout</button>
		</form>
	</div>
	</br>
	<div>
		<h2>Films Available</h2>
		<div>
			<%
				if (request.getAttribute("ErrorDelete") != null) {
			%>
			<%=request.getAttribute("ErrorDelete")%>
			<%
				}
			%>
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

						List<Film> list = (List<Film>) request.getAttribute("films");

						for (Film f : list) {
				%>
				<form action="/FilmRental/login/admin/removefromcollaction"
					method="post">
					<tr>
						<td><%=f.getFilm_Id()%><input type="hidden" name="Film_Id"
							value="<%=f.getFilm_Id()%>" /></td>
						<td><%=f.getTitle()%><input type="hidden" name="Title"
							value="<%=f.getTitle()%>" /></td>
						<td><%=f.getRegist()%><input type="hidden" name="Regist"
							value="<%=f.getRegist()%>" /></td>
						<td><%=f.getExit_Year()%><input type="hidden"
							name="Exit_Year" value="<%=f.getExit_Year()%>" /></td>
						<td><%=f.getQuantity()%><input type="hidden" name="Quantity"
							value="<%=f.getQuantity()%>" /></td>
						<td><button type="submit">Delete this Copy</button> <input
							type="hidden" name="deletefilm" value="on" /></td>
					</tr>
				</form>
				<%
					}
				%>

			</table>
		</div>
		<%
			}
		%></br>
	</div>
	</br>
	<div>
		<h2>Add Film to Collection</h2>
			<%
			if (request.getAttribute("ErrorRequest") != null) {
		%>
		<h2><%=request.getAttribute("ErrorRequest")%></h2>
		<%
			}
		%>
		<table>

			<tr>
				<td>Title:</td>
				<td>Regist:</td>
				<td>Exit_Year:</td>
				<td>Quantity:</td>
				<td></td>
			</tr>

			<form action="/FilmRental/login/admin/addtocollaction" method="post">
				<tr>
					<td><input type="txt" name="Add_Title" /></td>
					<td><input type="txt" name="Add_Regist" /></td>
					<td><input type="txt" name="Add_Exit_Year" /></td>
					<td><input type="txt" name="Add_Quantity" /></td>
					<td><button type="submit">Add film</button> <input
						type="hidden" name="addfilm" value="on" /></td>
				</tr>
			</form>
		</table>
	</div>
	</br>
	<div>
		<h2>Films from Suggestions</h2>
				<%
			if (request.getAttribute("ErrorAdd") != null) {
		%>
		<h2><%=request.getAttribute("ErrorAdd")%></h2>
		<%
			}
		%>

		<table>

			<tr>
				<td>User_Id:</td>
				<td>Title:</td>
				<td>Regist:</td>
				<td>Exit_Year:</td>
				<td>Quantity:</td>
				<td></td>
			</tr>

			<%
				if (request.getAttribute("allrequest") != null) {
					int i = 0;
					List<FilmRequest> allrequest = (List<FilmRequest>) request.getAttribute("allrequest");

					for (FilmRequest req : allrequest) {
			%>
			<form action="/FilmRental/login/admin/addtocollaction" method="post">
				<tr>
					<td><%=req.getUser_Id()%></td>
					<td><%=req.getTitle()%><input type="hidden"
						name="Add_Title" value="<%=req.getTitle()%>" /></td>
					<td><%=req.getRegist()%><input type="hidden"
						name="Add_Regist" value="<%=req.getRegist()%>" /></td>
					<td><%=req.getExit_Year()%><input type="hidden"
						name="Add_Exit_Year" value="<%=req.getExit_Year()%>" /></td>
					<td><input type="txt" name="Add_Quantity" /></td>
					<td><button type="submit">Add film</button> <input
						type="hidden" name="addfilm" value="on" /></td>
				</tr>
			</form>
			<%
				}
			%>
			<%
				}
			%>
		</table>

	</div>
	</br>
</body>
</html>