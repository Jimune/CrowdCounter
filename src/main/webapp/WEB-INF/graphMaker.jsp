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
         src="https://s-media-cache-ak0.pinimg.com/originals/9c/3f/5e/9c3f5e7411c638cb6c07253ed32a89f4.gif"
         style="visibility: hidden;">


</head>
<body>
<jsp:include page="header.jsp"/>

<div class="container">
    <form class="form-signin" id="form" method="post" action="/graphMaker">
        <label class="sr-only" for="location">Location: </label>
        <input class="form-control top" type="text" name="location" id="location" placeholder="Location"
               onkeyup="fetchLocation()" required autofocus>
        <div class="list-group" id="datatable" style="z-index: 2; position: fixed;"></div>
        <label class="sr-only" for="date">Date: </label>
        <input class="form-control bottom" type="text" id="date" name="date" placeholder="Date (yyyy-mm-dd)" required>
        <input class="btn btn-lg btn-primary btn-block" type="submit" value="Make graph!"
               onclick="setImageVisible('myImg',true)">
    </form>
</div>

</body>
</html>
