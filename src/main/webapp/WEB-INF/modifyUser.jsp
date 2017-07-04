<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html ng-app="modUser">
    <head>
        <title>Modify User</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>

        <div class="container">
            <c:if test="${not empty error}">
                <div class="error">${error}</div>
            </c:if>
            <c:if test="${empty error}">
                <div class="row" ng-controller="permBoxes">
                    <div class="col-md-4" ng-model="permList">
                        <h1>Modifying permissions for user ${target_user.name}</h1>
                        <div class="checkbox checkbox-primary" ng-repeat="permission in permissionsTable">
                            <input id="checkbox-{{permission.id}}" type="checkbox" value="{{permission.description}}"
                                   ng-click="update(permission.id)"
                                   ng-checked="userPermissions.indexOf(permission.id) > -1">
                            <label for="checkbox-{{permission.id}}">{{permission.description}}</label>
                        </div>
                        <input type="button" class="btn btn-lg btn-primary" value="Update" ng-click="save()">
                    </div>
                    <div class="col-md-8 height-limit">
                        <h1>Login session history:</h1>
                        <div class="row">
                            <div class="col-md-4">Logged in from</div>
                            <div class="col-md-4">Logged in at</div>
                            <div class="col-md-4">Logged out at</div>
                        </div>
                        <c:forEach var="sess" items="${target_user.sessions}">
                            <div class="row">
                                <div class="col-md-4">${sess.ip}</div>
                                <div class="col-md-4">${sess.login}</div>
                                <div class="col-md-4">${sess.logout}</div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </c:if>
        </div>
    </body>
</html>