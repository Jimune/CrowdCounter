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

        <div class="content center login-container">
            <c:if test="${not empty error}"><div class="error">${error}</div><br></c:if>
            <form method="post" action="admin.createAccount">
                <label class="align-left username" for="name">Username: </label>
                <input class="align-right username" type="text" name="name" id="name"><br>
                <label class="align-left password" for="pass">Password: </label>
                <input class="align-right password" type="password" name="pass" id="pass"><br>
                <label class="align-left confirm-password" for="confpass">Confirm Password: </label>
                <input class="align-right confirm-password" type="password" name="confpass" id="confpass"><br>
                <input class="align-right submit-button" type="submit" value="Create">
            </form>
        </div>
    </body>
</html>