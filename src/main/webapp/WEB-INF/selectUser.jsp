<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
        <script src="/p_angular.js"></script>
        <link rel="stylesheet" href="/style.css" type="text/css">
        <title>Select User</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <br><br><br><br>
        <c:if test="${not empty error}"><div class="error">${error}</div></c:if>
        <input type="text" id="finduserinput" onkeyup="fetchData()">
        <table id="datatable">

        </table>
    </body>
</html>