<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Change Password</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="container">
    <form class="form-signin" method="post" action="account.changePassword">
        <h2 class="form-signin-heading">Change Password</h2>
        <div class="row error"><c:if test="${not empty error}">${error}</c:if></div>
        <div class="row success"><c:if test="${not empty success}">${success}</c:if></div>
        <label class="sr-only" for="origPass">Old Password: </label>
        <input class="form-control top" type="password" name="origPass" id="origPass" placeholder="Old Password"
               required
               autofocus>
        <label class="sr-only" for="newPass">Password: </label>
        <input class="form-control middle" type="password" name="newPass" id="newPass" placeholder="New Password"
               required>
        <label class="sr-only" for="repeatPass">Confirm Password: </label>
        <input class="form-control bottom" type="password" name="repeatPass" id="repeatPass"
               placeholder="Confirm password" required>
        <input class="btn btn-lg btn-primary btn-block" type="submit" value="Update">
    </form>
</div>
</body>
</html>