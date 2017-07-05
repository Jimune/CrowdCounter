<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Table Data</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="container">
    <table class="table">
        <h1>Table data for ${location} on ${date}</h1>
        <tr>
            <th>Hour</th>
            <th>Weak Signal</th>
            <th>Medium Signal</th>
            <th>Strong Signal</th>
        </tr>
        <c:forEach var="i" begin="0" end="23">
            <tr>
                <td>${i}:00 - <c:if test="${i != 23}">
                    ${i + 1}:00
                </c:if>
                    <c:if test="${i == 23}">
                        0:00
                    </c:if></td>
                <td>${weakhourmap[i]}</td>
                <td>${mediumhourmap[i]}</td>
                <td>${highhourmap[i]}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>