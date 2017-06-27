<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="nl.yc.crowdcounter.model.*" %>
<div class="header">
	<ul>
		<li><a href="index">Home</a></li>
		<%
		    if (request.getAttribute("user") != null)
		    for (Permission perm : ((User) request.getAttribute("user")).getPermissions()) {
                if (perm.getPermission().equals("can_admin")) {
        %>
                    <li><a href="#">Admin</a>
                    	<ul>
                    	<%
                    		for (Permission p : ((User) request.getAttribute("user")).getPermissions()) {
                    			if (p.getPermission().equals("add_user")) {
                    	%>
                                    <li><a href="/admin.createAccount">Add User</a></li>

                    	<%	    } else if (p.getPermission().equals("modify_user")) {
                    	%>
                    	            <li><a href="/admin.modifyUser">Modify User</a></li>

                    	<%      } else if (p.getPermission().equals("")) {
                    	%>
                    	            <li><a href="/dev.createPerm">Create Perm</a></li>

                    	<%      }
                    		}
                    	%>

                    </ul></li>

        <%		}
        	}
		%>

		<c:if test="${not empty user}">
			<li class="last"><a href="#">Logged in as ${user.name}</a>
				<ul>
				    <%
				    for (Permission p : ((User) request.getAttribute("user")).getPermissions()) {
				        if (p.getPermission().equals("change_pass")) {
				    %>
				            <li><a href="/account.changePass">Change Password</a></li>

				    <%  }
				    }
				    %>
					<li><a href="/logout">Logout</a></li>
				</ul>
		    </li>
		</c:if>
		<c:if test="${empty user}">
			<li class="last"><a href="/login">Log in</a></li>
		</c:if>
	</ul>
</div>
