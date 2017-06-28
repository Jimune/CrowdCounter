<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html ng-app="selectUser">
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
        <div ng-controller="findUser">
            <input type="text" ng-model="inputfield" name="finduserinput">
            <tr ng-repeat="user in users">
                <td><a ng-model="modifySelect" href="/admin.modifyUser.{{user.id}}">{{user.name}}</td>
            </tr>
        </div>
    </body>
</html>