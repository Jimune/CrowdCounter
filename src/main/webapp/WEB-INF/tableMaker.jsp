<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Table Maker</title>
    <script src="/graphFunctions.js"></script>
    <link rel="stylesheet" href="/graphStyle.css" type="text/css">
    <img id="myImg"
         src="https://digitalsynopsis.com/wp-content/uploads/2016/06/loading-animations-preloader-gifs-ui-ux-effects-28.gif"
         style="visibility: hidden;">


</head>
<body>
<jsp:include page="header.jsp"/>

<div class="container">
    <form class="form-signin" id="form" method="post" action="/tableMaker">
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
