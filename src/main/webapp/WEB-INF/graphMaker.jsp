<%--
  Created by IntelliJ IDEA.
  User: yvo.romp
  Date: 28/06/2017
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>graphMaker</title>
    <link rel="stylesheet" href="/style.css" type="text/css">
    <link rel="stylesheet" href="/graphStyle.css" type="text/css">


</head>
<body>
<jsp:include page="header.jsp"/>
<div style="top: 40%;left: 30%; position:absolute" id="data">
    <form method="post" action="graphMaker">
        <label for="location">Location: </label>
        <input type="text" name="location" id="location">
        <label for="date">Date: </label>
        <input type="text" id="date" name="date">
        <input type="submit" value="make graph!">
    </form>
</div>

</body>
</html>
