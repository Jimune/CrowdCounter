<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Add new user</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>

        <div class="container">
            <form class="form-signin" method="post" action="admin.createAccount">
                <h2 class="form-signin-heading">Create new user</h2>
                <div class="row error"><c:if test="${not empty error}">${error}</c:if></div>
                <div class="row success"><c:if test="${not empty success}">${success}</c:if></div>
                <label class="sr-only" for="name">Username: </label>
                <input class="form-control top" type="text" name="name" id="name" placeholder="Username" required
                       autofocus>
                <label class="sr-only" for="pass">Password: </label>
                <input class="form-control middle" type="password" name="pass" id="pass" placeholder="Password"
                       required>
                <label class="sr-only" for="confpass">Confirm Password: </label>
                <input class="form-control bottom" type="password" name="confpass" id="confpass"
                       placeholder="Confirm password" required>
                <input class="btn btn-lg btn-primary btn-block" type="submit" value="Create">
            </form>
        </div>
    </body>
</html>