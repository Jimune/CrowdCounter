<%--
  Created by IntelliJ IDEA.
  User: yvo.romp
  Date: 03/07/2017
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" href="/homeScreenStyle.css" type="text/css">

<!-- Carousel
================================================== -->
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img class="first-slide"
                 src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9svdjYk1fJJHDuo0RI4NRfaA1yXUbNjSJNwp2GnGn5Nyi-ceB2Q"
                 alt="First slide">
            <div class="carousel-caption">
                <h1>Get more data from your customers</h1>
                <p></p>
            </div>
        </div>
        <div class="item">
            <img class="second-slide"
                 src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT3qHhOmFwxzMhismTKgjmZUkqisjveoT1JPw3-eWhYHmhAdj4g"
                 alt="Second slide">
            <div class="carousel-caption">
                <h1>Map out all the surrounded connections</h1>
                <p></p>
            </div>
        </div>
        <div class="item">
            <img class="third-slide"
                 src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQAw_ZKcvN5OIJqfCbu6MiOWn00uBnNnTppsgk2jVq-bqrGgWk5AQ"
                 alt="Third slide">
            <div class="carousel-caption">
                <h1>Get in touch with your environment</h1>
                <p></p>
            </div>
        </div>
    </div>
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div><!-- /.carousel -->


<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->
<hr class="featurette-divider">
<div class="container marketing">

    <!-- Three columns of text below the carousel -->
    <div class="row">
        <div class="col-lg-4">
            <img class="img-circle"
                 src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRA2nn6OJWz4NqJvJkynffGaRXgvRN40dMl9C6B3mbpKyJsKX73Bw"
                 alt="Generic placeholder image" width="140" height="140">
            <h2>Heading</h2>
            <p>Donec sed odio dui. Etiam porta sem malesuada magna mollis euismod. Nullam id dolor id nibh ultricies
                vehicula ut id elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Praesent commodo
                cursus magna.</p>
            <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
            <img class="img-circle"
                 src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTCPx6VIHeqQ-zwZg26RIpiBNVq6gp4d_D8TiJbzi3cJOGKQDdi"
                 alt="Generic placeholder image" width="140" height="140">
            <h2>Heading</h2>
            <p>Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras
                mattis consectetur purus sit amet fermentum. Fusce dapibus, tellus ac cursus commodo, tortor mauris
                condimentum nibh.</p>
            <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
            <img class="img-circle"
                 src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSBhz2AG3w1cMeuKSP7niscI-NhB1UX2RdteZPnpCAFeKSB5PPB"
                 alt="Generic placeholder image" width="140" height="140">
            <h2>Heading</h2>
            <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula
                porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut
                fermentum massa justo sit amet risus.</p>
            <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
    </div><!-- /.row -->


    <!-- START THE FEATURETTES -->

    <hr class="featurette-divider">

    <div class="row featurette">
        <div class="col-md-7">
            <h2 class="featurette-heading">First featurette heading. <span
                    class="text-muted">It'll blow your mind.</span></h2>
            <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod
                semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus
                commodo.</p>
        </div>
        <div class="col-md-5">
            <img class="img-circle"
                 src="data:image/jpeg;base64,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">
    </div>

    <hr class="featurette-divider">

    <div class="row featurette">
        <div class="col-md-7 col-md-push-5">
            <div class="lefty">
                <h2 class="featurette-heading">Oh yeah, it's that good. <span
                        class="text-muted">See for yourself.</span></h2>
                <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis
                    euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus,
                    tellus ac cursus commodo.</p>
            </div>
        </div>
        <div class="col-md-5 col-md-pull-7">
            <img class="img-circle"
                 src="data:image/jpeg;base64,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"
                 alt="Generic placeholder image">
        </div>
    </div>

    <hr class="featurette-divider">

    <div class="row featurette">
        <div class="col-md-7">
            <h2 class="featurette-heading">And lastly, this one. <span class="text-muted">Checkmate.</span></h2>
            <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod
                semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus
                commodo.</p>
        </div>
        <div class="col-md-5">
            <img class="img-circle"
                 src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSn8HAEh3fJUv1Ifs77ofqGrp99OGt1eAlL4otrEMGc0yHxqkDt5A"
                 alt="Generic placeholder image">
        </div>
    </div>

    <hr class="featurette-divider">

    <!-- /END THE FEATURETTES -->


    <!-- FOOTER -->
    <footer>
        <p class="pull-right"><a href="#">Back to top</a></p>
        <p>&copy; 2017 CrowdCounter, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
    </footer>

    </div><!-- /.container -->

