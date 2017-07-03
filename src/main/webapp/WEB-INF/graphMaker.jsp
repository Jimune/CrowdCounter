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
    <script src="/graphFunctions.js"></script>
    <link rel="stylesheet" href="/graphStyle.css" type="text/css">
    <img id="myImg"
         src="https://68.media.tumblr.com/a6177f6b977637597850b273022c81ed/tumblr_nurhzkuKQO1syz1nro1_500.gif"
         style="visibility: hidden;">


</head>
<body>
<jsp:include page="header.jsp"/>

<div class="container">
    <form class="form-signin" id="form" method="post" action="/graphMaker">
        <label class="sr-only" for="location">Location: </label>
        <input class="form-control top" type="text" name="location" id="location" placeholder="Location" required
               autofocus>
        <label class="sr-only" for="date">Date: </label>
        <input class="form-control bottom" type="text" id="date" name="date" placeholder="Date (yyyy-mm-dd)" required
               autofocus>
        <input class="btn btn-lg btn-primary btn-block" type="submit" value="make graph!"
               onclick="setImageVisible('myImg',true)">
    </form>
</div>

</body>
</html>
