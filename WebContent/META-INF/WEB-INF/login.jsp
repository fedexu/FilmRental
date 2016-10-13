<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LOGIN</title>
</head>
<body>

  <h1>Login here please:</h1>
  <form method="post" action="login">
  <c:if test="${not empty username}"><font color ="red"> ${username} is not a registered user!</font><br></c:if>
  Username: <input type="text" name="username"/>
  <button>Login</button>
  </form>
</body>
</html>