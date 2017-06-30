<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="/style.css" type="text/css">
        <title>Add new user</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>

        <div class="container">
            <form class="form-signin" method="post" action="admin.createAccount">
                <h2 class="form-signin-heading">Create new user</h2>
                <div class="error"><c:if test="${not empty error}">${error}</c:if></div>
                <br>
                <label class="sr-only" for="name">Username: </label>
                <input class="form-control username" type="text" name="name" id="name" placeholder="Username" required
                       autofocus><br>
                <label class="sr-only" for="pass">Password: </label>
                <input class="form-control pre-password" type="password" name="pass" id="pass" placeholder="Password"
                       required><br>
                <label class="sr-only" for="confpass">Confirm Password: </label>
                <input class="form-control password" type="password" name="confpass" id="confpass"
                       placeholder="Confirm password" required><br>
                <input class="btn btn-lg btn-primary btn-block" type="submit" value="Create">
            </form>
        </div>
    </body>
</html>