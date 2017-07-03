<%--
  Created by IntelliJ IDEA.
  User: yvo.romp
  Date: 02/07/2017
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>graphPlotter</title>
    <script src="https://code.highcharts.com/highcharts.js"></script>
    <script src="https://code.highcharts.com/modules/exporting.js"></script>
    <script src="/graphFunctions.js"></script>
    <link rel="stylesheet" href="/graphStyle.css" type="text/css">
</head>
<body>
<jsp:include page="header.jsp"/>


<div id="container" style="min-width: 400px; height: 400px; margin: 0 auto;"></div>
<%--<script src="/graphFunctions.js"></script>--%>
<script>getData(${weakhourmap}, ${mediumhourmap}, ${highhourmap})</script>

</body>
</html>
