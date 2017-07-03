<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create new Permission</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="container">
    <form class="form-signin" method="post" action="admin.createPerm">
        <h2 class="form-signin-heading">Create new Permission</h2>
        <div class="row error"><c:if test="${not empty error}">${error}</c:if></div>
        <div class="row success"><c:if test="${not empty success}">${success}</c:if></div>
        <label class="sr-only" for="perm">Permission: </label>
        <input class="form-control top" type="text" name="perm" id="perm" placeholder="Permission" required
               autofocus>
        <label class="sr-only" for="desc">Description: </label>
        <input class="form-control bottom" type="text" name="desc" id="desc" placeholder="Description">
        <input class="btn btn-lg btn-primary btn-block" type="submit" value="Create">
    </form>

    <h3>Existing permissions</h3>
    <div class="row">
        <div class="col-md-2 active"><h4>Permission</h4></div>
        <div class="col-md-6 active"><h4>Description</h4></div>
    </div>

    <c:forEach var="tperm" items="${permissions_Table}">
        <div class="row">
            <div class="col-md-2">${tperm.permission}</div>
            <div class="col-md-6">${tperm.description}</div>
        </div>
    </c:forEach>
</div>
</body>
</html>