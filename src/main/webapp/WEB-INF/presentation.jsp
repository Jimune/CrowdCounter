<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Presentation</title>
    <link rel="stylesheet" href="/reveal.js/css/reveal.css">
    <link rel="stylesheet" href="/reveal.js/css/theme/league.css" id="theme">
    <link rel="stylesheet" href="/reveal.js/lib/css/zenburn.css">
    <script type="text/javascript" src="/reveal.js/plugin/highlight/highlight.js"></script>
</head>
<body>

<div class="reveal default center" data-background-transition="fade">
    <div class="slides">
        <section> <%-- Front slide --%>
            <h2>CrowdCounter</h2>
            <h3>Yvo Romp & Jim Mulder</h3>
        </section>

        <section> <%-- First slide --%>
            <h2>Over ons</h2>
            <h3>Hoe zijn we hier terecht gekomen</h3>
        </section>

        <section> <%-- Second slide  --%>
            <section> <%-- Top slide --%>
                <h2>Waarom</h2>
                <ul>
                    <li>Uitdagend project</li>
                    <li>Nieuwe dingen leren</li>
                </ul>
            </section>

            <section> <%-- Middle slide --%>
                <h2>Hoe</h2>
                <ul>
                    <li>Geduld</li>
                    <li>Git</li>
                    <li>Teamwork</li>
                    <li>IntelliJ</li>
                    <li>Nieuwe technieken en frameworks</li>
                </ul>
            </section>

            <section> <%-- Bottom slide --%>
                <h2>Wat</h2>
                <ul>
                    <li>CrowdCounter</li>
                    <li>Front-end</li>
                    <li>Back-end</li>
                    <li>Totaal oplossing</li>
                </ul>
            </section>
        </section>

        <section> <%-- Third slide --%>
            <section> <%-- Top slide --%>
                <h2>Leerpunten</h2>
                <ul>
                    <li>Oorspronkelijk doel
                        <ul>
                            <li>Raspberry Pi</li>
                            <li>Arduino's</li>
                        </ul>
                    </li>
                    <li>AngularJS</li>
                    <li>Implementatie Query's</li>
                    <li>Git</li>
                </ul>
            </section>

            <section> <%-- Middle slide --%>
                <h2>Wat ging goed</h2>
                <ul>
                    <li>Samenwerking
                        <ul>
                            <li>Info delen</li>
                            <li>Layout bepalen</li>
                        </ul>
                    </li>
                    <li>Doel bijstellen</li>
                    <li>Overzicht</li>
                    <li>Voorbereidend werk</li>
                </ul>
            </section>

            <section> <%-- Bottom slide --%>
                <h2>Bijkomstigheden</h2>
                <ul>
                    <li>Eerste week van de casus</li>
                    <li>Basis uitleg</li>
                    <li>Wifi "Sniffer"</li>
                </ul>
            </section>
        </section>

        <section> <%-- Fourth slide --%>
            <h2>UML</h2>
            <section> <%-- Top slide --%>
                <img src="/diagram.png" style="transform: translateY(5%);">
            </section>

            <section> <%-- Bottom slide --%>
                <img src="/diagram_short.png"
                     style="transform: translateX(-11.5%) translateY(8%); max-width: 130%; max-height: 130%; width: 130%; height: 130%;">
            </section>
        </section>

        <section>
            <h2>Demo</h2>
        </section>

        <section>
            <h2>Jim</h2>
            <section>
                <h3>Security</h3>
                <pre><code class="java">@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Accessibility {

    boolean requireLogin() default true;
    String[] requiredPermissions() default {};

}</code></pre>
            </section>
            <section>
                <h3>Security</h3>
                <pre><code class="java" style="transform: translateX(-5%); width: 110%;">public class PermissionFilter extends HandlerInterceptorAdapter {

    @Autowired
    UserCrudRepo repo;

    @Override
    public boolean preHandle(HttpServletRequest request,
                    HttpServletResponse response, Object handler) {
        HandlerMethod hm = (HandlerMethod) handler;
        Method m = hm.getMethod();
        Accessibility a = m.getDeclaredAnnotation(Accessibility.class);

        if (a != null) {
            if (a.requireLogin()) {
                HttpSession session = request.getSession(false);</code></pre>
            </section>
            <section></section>
            <section></section>
        </section>

        <section>
            <h2>Yvo</h2>
            <section></section>
            <section></section>
            <section></section>
            <section></section>
        </section>

        <section>
            <h2>Vragen</h2>
        </section>
    </div>
</div>

<script src="/reveal.js/lib/js/head.min.js"></script>
<script src="/reveal.js/js/reveal.js"></script>
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
        dependencies: [{
                src: '/reveal.js/plugin/highlight/highlight.js', async: true, callback: function () {
                hljs.initHighlightingOnLoad();
            }
            }]
    });
</script>
</body>
</html>