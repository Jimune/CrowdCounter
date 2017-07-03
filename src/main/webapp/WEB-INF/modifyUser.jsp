<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Modify User</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>

        <div class="container">
            <form role="form">
                <c:if test="${not empty error}">
                    <div class="error">${error}</div>
                </c:if>
                <c:if test="${empty error}">
                    <div class="row">
                        <div class="col-md-4">
                            <h1>Modifying permissions for user ${target_user.name}</h1>
                            <c:forEach var="tperm" items="${permissions_Table}">
                                <div class="checkbox checkbox-primary">
                                    <input id="checkbox-${tperm.id}" type="checkbox"
                                           onchange="updatePerm(${target_user.id},${tperm.id},this)"
                                    <c:forEach var="uperm" items="${target_user.permissions}">
                                    <c:if test="${tperm.permission eq uperm.permission}">
                                           checked
                                    </c:if>
                                    </c:forEach>
                                    >
                                    <label for="checkbox-${tperm.id}">
                                            ${tperm.description}
                                    </label>
                                </div>
                            </c:forEach>
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
            </form>
        </div>
    </body>
</html>