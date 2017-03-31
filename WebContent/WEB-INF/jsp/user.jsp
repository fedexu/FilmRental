<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.filmrental.model.Film"%>
<%@ page import="com.filmrental.model.User"%>
<%@ page import="com.filmrental.model.FilmRentVO"%>
<%@ page import="java.math.BigDecimal"%>
<%@ page import="com.filmrental.controller.UserSession"%>
<%@ page session="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FilmRental User</title>
</head>
<body>
	<div>
		<%
			UserSession userSession = (UserSession) request.getSession().getAttribute("scopedTarget.userSession");
		%>
		<h1>
			User:<%=userSession.getUsername()%></h1>
		<br />
		<form action="${pageContext.request.contextPath}/login" method="get">
			<input type="hidden" name="logout" value="logout" />
			<button type="submit">Logout</button>
		</form>

	</div>
	<br />
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

			<c:forEach items="${films}" var="film" varStatus="loop">
				<form:form
					action="${pageContext.request.contextPath}/login/user/rentfilm"
					method="post" modelAttribute="addFilmRent">
					<tr>
						<td>${film.filmId}<form:hidden path="filmId"
								value="${film.filmId}" /></td>
						<td>${film.title}<form:hidden path="title"
								value="${film.title}" /></td>
						<td>${film.regist}<form:hidden path="regist"
								value="${film.regist}" /></td>
						<td>${film.exitYear}<form:hidden path="exitYear"
								value="${film.exitYear}" /></td>
						<td>${count[loop.index]}<form:hidden path="quantity"
								value="${film.quantity}" /></td>
						<td><button type="submit">Rent a Copy</button></td>
					</tr>
				</form:form>
			</c:forEach>
		</table>
	</div>
	<br />

	<div>
		<h2>Film Rented</h2>

		<table>
			<tr>
				<td>RENT_ID</td>
				<td>FILM_ID</td>
				<td>TITLE</td>
				<td>ORDER_DATE</td>
				<td></td>
			</tr>

			<c:forEach items="${listrented}" var="filmrent" varStatus="loop">
				<form:form
					action="${pageContext.request.contextPath}/login/user/returnfilm"
					method="post" modelAttribute="returnFilm">
					<tr>
						<td>${filmrent.rentId}<form:hidden path="rentId"
								value="${filmrent.rentId}" /></td>
						<td>${filmrent.film.filmId}</td>
						<td>${filmrent.film.title}</td>
						<td>${filmrent.orderDate}</td>
						<td><button type="submit">Return this copy</button></td>
					</tr>
				</form:form>
			</c:forEach>
		</table>
	</div>
	<br />
	<div>
		<h2>Film Request</h2>

		<c:if test="${requestfailure != null}">
			<h3 style="color: red;">${requestfailure}</h3>
			<br />
		</c:if>

		<table>

			<tr>
				<td>Title:</td>
				<td>Regist:</td>
				<td>Exit_Year:</td>
				<td></td>
			</tr>

			<form:form
				action="${pageContext.request.contextPath}/login/user/addrequest"
				method="post" modelAttribute="request">
				<tr>
					<td><form:input type="txt" path="title" /></td>
					<td><form:input type="txt" path="regist" /></td>
					<td><form:input type="txt" path="exitYear" /></td>
					<td><button type="submit">Submit suggestion</button></td>
				</tr>
			</form:form>

		</table>
		<c:if test="${requestdone != null}">
			<h3 style="color: blue;">${requestdone}</h3>
			<br />
		</c:if>

	</div>
	<br />

</body>
</html>
