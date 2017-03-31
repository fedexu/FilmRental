<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.filmrental.model.Film"%>
<%@ page import="com.filmrental.model.User"%>
<%@ page import="com.filmrental.model.FilmRent"%>
<%@ page import="com.filmrental.model.FilmRequest"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Filmrental BlackBlaster</title>
</head>
<body>

	<div>
		<h1>Welcome home, master!</h1>

		<form action="${pageContext.request.contextPath}/login" method="get">
			<input type="hidden" name="logout" value="logout" />
			<button type="submit">Logout</button>
		</form>

	</div>
	<br />

	<div>
		<h2>Films Available</h2>
		<div>
			<c:if test="${ErrorDelete != null}">
				<h3 style="color: red;">${ErrorDelete}</h3>
				<br />
			</c:if>
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


				<c:forEach items="${films}" var="film">
					<form:form
						action="${pageContext.request.contextPath}/login/admin/removeFilm"
						method="post" modelAttribute="removeFilm">
						<tr>
							<td><c:out value="${film.filmId}" /> <form:hidden
									path="filmId" value="${film.filmId}" /></td>
							<td><c:out value="${film.title}" /> <form:hidden
									path="title" value="${film.title}" /></td>
							<td><c:out value="${film.regist}" /> <form:hidden
									path="regist" value="${film.regist}" /></td>
							<td><c:out value="${film.exitYear}" /> <form:hidden
									path="exitYear" value="${film.exitYear}" /></td>
							<td><c:out value="${film.quantity}" /> <form:hidden
									path="quantity" value="${film.quantity}" /></td>
							<td><button type="submit">Delete this Copy</button></td>
						</tr>
					</form:form>
				</c:forEach>


			</table>
		</div>
		<br />
	</div>
	<br />

	<div>
		<h2>Add Film to Collection</h2>

		<c:if test="${ErrorRequest != null}">
			<h3 style="color: red;">${ErrorRequest}</h3>
		</c:if>

		<table>

			<tr>
				<td>Title:</td>
				<td>Regist:</td>
				<td>Exit_Year:</td>
				<td>Quantity:</td>
				<td></td>
			</tr>

			<form:form
				action="${pageContext.request.contextPath}/login/admin/addfilm"
				method="post" modelAttribute="addFilm">
				<tr>
					<td><form:input type="txt" path="title" /></td>
					<td><form:input type="txt" path="regist" /></td>
					<td><form:input type="txt" path="exitYear" /></td>
					<td><form:input type="txt" path="quantity" /></td>
					<td><button type="submit">Add film</button></td>
				</tr>
			</form:form>

		</table>

	</div>
	<br />
	<div>
		<h2>Films from Suggestions</h2>

		<c:if test="${ErrorAdd2 != null}">
			<h3 style="color: red;">${ErrorAdd2}</h3>
		</c:if>

		<table>

			<tr>
				<td>User_Id:</td>
				<td>Title:</td>
				<td>Regist:</td>
				<td>Exit_Year:</td>
				<td>Quantity:</td>
				<td></td>
			</tr>

			<c:forEach items="${filmrequest}" var="filmrequest">
				<form:form
					action="${pageContext.request.contextPath}/login/admin/addrequest"
					method="post" modelAttribute="addrequest">
					<tr>
						<td>${filmrequest.userId}<form:hidden path="userId"
								value="${filmrequest.userId}" /></td>
						<td>${filmrequest.title}<form:hidden path="title"
								value="${filmrequest.title}" /></td>
						<td>${filmrequest.regist}<form:hidden path="regist"
								value="${filmrequest.regist}" /></td>
						<td>${filmrequest.exitYear}<form:hidden path="exitYear"
								value="${filmrequest.exitYear}" /></td>
						<td><form:input type="txt" path="quantity" /></td>
						<td><button type="submit">Add film</button></td>
					</tr>
				</form:form>
			</c:forEach>

		</table>

	</div>
	<br />
</body>
</html>