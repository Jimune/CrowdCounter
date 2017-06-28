<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html ng-app>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js">
        <title>Modify User</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>

        <table>
            <tr ng-repeat="permission in permissions_Table">
                <td>
            </tr>
        </table>
    </body>
</html>