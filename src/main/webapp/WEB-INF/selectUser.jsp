<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Select User</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>

        <div class="container">
            <div class="form-signin">
                <h2>Search for user</h2>
                <c:if test="${not empty error}">
                    <div class="error">${error}</div>
                </c:if>
                <input class="form-control" type="text" id="finduserinput" onkeyup="fetchData()"
                       onkeydown="if (event.keyCode == 13) checkEnter()" placeholder="Username">
                <div class="list-group" id="datatable">

                </div>
            </div>
        </div>
    </body>
</html>