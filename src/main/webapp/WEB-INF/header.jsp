<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="header">
	<ul>
		<li><a href="index">Home</a></li>
		<c:if test="${not empty user}">
		    <c:forEach var="aperm" items="${user.permissions}">
		        <c:if test="${aperm.permission eq 'can_admin'}">
		            <li><a href="#">Admin</a>
		                <ul>
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
		        </c:if>
		    </c:forEach>
		</c:if>
		<c:if test="${not empty user}">
            <li class="last"><a href="#">Logged in as ${user.name}</a>
                <ul>
                    <c:forEach var="perm" items="${user.permissions}">
        		        <c:if test="${perm.permission eq 'change_pass'}">
        		            <li><a href="/account.changePassword">Add User</a></li>
        		        </c:if>
        		    </c:forEach>
                    <li><a href="/logout">Logout</a></li>
                </ul>
            </li>
        </c:if>
        <c:if test="${empty user}">
           	<li class="last"><a href="/login">Log in</a></li>
        </c:if>
    </ul>
</div>