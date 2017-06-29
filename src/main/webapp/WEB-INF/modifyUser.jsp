<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <script src="p_angular.js"></script>
        <link rel="stylesheet" href="/style.css" type="text/css">
        <title>Modify User</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>

        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        <c:if test="${empty error}">
            <h1>Modifying user ${target_user.name}</h1>
            <div class="permissions">
                <c:forEach var="tperm" items="${permissions_Table}">
                    <input type="checkbox" onchange="updatePerm(${target_user.id},${tperm.id},this)"
                    <c:forEach var="uperm" items="${target_user.permissions}">
                    <c:if test="${tperm.permission eq uperm.permission}">
                           checked
                    </c:if>
                    </c:forEach>
                    >${tperm.description}<br>
                </c:forEach>
            </div>
        </c:if>


    </body>
</html>