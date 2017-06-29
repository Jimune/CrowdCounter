<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="/style.css" type="text/css">
    <title>Create new Permission</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="content center login-container">
    <c:if test="${not empty error}">
        <div class="error">${error}</div>
        <br></c:if>

    <form method="post" action="admin.createPerm">
        <label class="align-left username" for="perm">Permission: </label>
        <input class="align-right username" type="text" name="perm" id="perm"><br>
        <label class="align-left password" for="desc">Description: </label>
        <input class="align-right password" type="text" name="desc" id="desc"><br>
        <input class="align-right submit-button" type="submit" value="Create">
    </form>
</div>

<table>
    <tr>
        <td>Permission:</td>
        <td>Description:</td>
        <td></td>
    </tr>
    <c:forEach var="tperm" items="${permissions_Table}">
        <tr>
            <td>${tperm.permission}</td>
            <td>${tperm.description}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>