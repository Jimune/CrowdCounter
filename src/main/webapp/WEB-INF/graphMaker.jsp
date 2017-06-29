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
    <script src="https://code.highcharts.com/highcharts.js"></script>
    <script src="https://code.highcharts.com/modules/exporting.js"></script>
    <link rel="stylesheet" href="/style.css" type="text/css">
    <link rel="stylesheet" href="/graphStyle.css" type="text/css">


</head>
<body>
<jsp:include page="header.jsp"/>

<div id="container" style="min-width: 400px; height: 400px; margin: 0 auto"></div>
<script src="/graphPlotter.js"></script>


<div style="top: 85%; position:absolute" id="data"></div>
<input type="button" value="get the data" onclick="getData()" style="top: 80%; position:absolute">


</body>
</html>
