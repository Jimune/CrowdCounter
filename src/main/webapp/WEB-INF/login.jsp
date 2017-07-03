<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>

        <div class="container">
            <form class="form-signin" method="post" action="login">
                <h2 class="form-signin-heading">Please login</h2>
                <div class="error"><c:if test="${not empty error}">${error}</c:if></div>
                <br>
                <div class="success"><c:if test="${not empty success}">${success}</c:if></div>
                <br>
                <label class="sr-only" for="name">Username: </label>
                <input class="form-control top" type="text" name="name" id="name" placeholder="Username" required
                       autofocus>
                <label class="sr-only" for="pass">Password: </label>
                <input class="form-control bottom" type="password" name="pass" id="pass" placeholder="Password"
                       required>
                <input class="btn btn-lg btn-primary btn-block" type="submit" value="Login">
            </form>
        </div>
    </body>
</html>