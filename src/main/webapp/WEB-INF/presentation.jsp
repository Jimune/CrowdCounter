<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Presentation</title>
    <link rel="stylesheet" href="/reveal/css/reveal.css">
    <link rel="stylesheet" href="/reveal/css/night.css" id="theme">
    <link rel="stylesheet" href="/reveal/css/zenburn.css">
    <script type="text/javascript" src="/reveal/highlight.js"></script>
</head>
<body>

<div class="reveal default center" data-background-transition="fade">
    <div class="slides">
        <section>
            <h1>CrowdCounter</h1>
            <h2>Yvo Romp & Jim Mulder</h2>
        </section>
        <section>
            <section>
                Some random data
            </section>
        </section>
        <section>
            <section>random 1</section>
            <section>random 2</section>
        </section>
    </div>
</div>

<script src="../reveal/head.min.js"></script>
<script src="../reveal/reveal.js"></script>
<script>
    // Full list of configuration options available here:
    // https://github.com/hakimel/reveal.js#configuration
    Reveal.initialize({

        controls: true,
        progress: true,
        history: false,
        center: true,
        slideNumber: 'c',
        rollingLinks: false,
        keyboard: true,
        overview: true,

        theme: Reveal.getQueryHash().theme, // available themes are in /css/theme
        transition: Reveal.getQueryHash().transition || 'default', // default/cube/page/concave/zoom/linear/fade/none
        transitionSpeed: 'default',
        multiplex: {
            secret: '', // null if client
            id: '', // id, obtained from socket.io server
            url: '' // Location of socket.io server
        },

// Optional libraries used to extend on reveal.js
        dependencies: [
            {
                src: '/reveal.js/plugin/highlight/highlight.js', async: true, callback: function () {
                hljs.initHighlightingOnLoad();
            }
            }]
    });</script>
</body>
</html>