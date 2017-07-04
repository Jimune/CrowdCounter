<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="/jquery-3.2.1.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
      integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
      integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.min.css">
<script src="/functions.js"></script>
<link rel="stylesheet" href="/style.css" type="text/css">

<nav class="navbar-fixed-top navbar navbar-default">
    <div class="container">
        <ul class="nav navbar-nav">
            <li role="presentation"><a href="index">Home</a></li>
            <c:if test="${not empty user}">
                <li role="presentation" class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#"
                       role="button" aria-haspopup="true" aria-expanded="false">Graph<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/graphMaker">Create new graph</a></li>
                    </ul>
                </li>
            </c:if>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <c:if test="${not empty user}">
                <c:forEach var="aperm" items="${user.permissions}">
                    <c:if test="${aperm.permission eq 'can_admin'}">
                        <li role="presentation" class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#"
                               role="button" aria-haspopup="true" aria-expanded="false">Admin<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <c:forEach var="perm" items="${user.permissions}">
                                    <c:if test="${perm.permission eq 'add_user'}">
                                        <li><a href="/admin.createAccount">Add User</a></li>
                                    </c:if>
                                    <c:if test="${perm.permission eq 'modify_user'}">
                                        <li><a href="/admin.modifyUser.select">Modify User</a></li>
                                    </c:if>
                                    <c:if test="${perm.permission eq 'create_perm'}">
                                        <li><a href="/admin.createPerm">Create Perm</a></li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </li>
                    </c:if>
                </c:forEach>
                <li role="presentation" class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#"
                       role="button" aria-haspopup="true" aria-expanded="false">Logged in as ${user.name}<span
                            class="caret"></span></a>
                    <ul class="dropdown-menu dropdown-menu-right">
                        <c:forEach var="perm" items="${user.permissions}">
                            <c:if test="${perm.permission eq 'change_pass'}">
                                <li><a href="/account.changePassword">Change Password</a></li>
                                <li role="separator" class="divider"></li>
                            </c:if>
                        </c:forEach>
                        <li><a href="/logout">Logout</a></li>
                    </ul>
                </li>
            </c:if>
            <c:if test="${empty user}">
                <li role="presentation" class="navbar-right"><a href="/login">Log in</a></li>
            </c:if>
        </ul>
    </div>
</nav>