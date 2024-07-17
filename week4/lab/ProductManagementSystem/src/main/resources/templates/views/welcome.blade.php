<!doctype html>
<html lang="en">

<head>

    <!-- Basic Page Needs
================================================== -->
    <title>Hireo</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <!-- CSS
================================================== -->
@include('includes.head')

</head>

<body>

    <!-- Wrapper -->
    <div id="wrapper">
        <!-- Intro Banner
================================================== -->
        <!-- add class "disable-gradient" to enable consistent background overlay -->
        <div class="intro-banner" data-background-image="images/home-background.jpg">
            <div class="container">

                <!-- Search Bar -->
                <div class="row">
                    <div class="col-md-12">
                        <div class="intro-banner-search-form margin-top-95">

                            <!-- Search Field -->
                            <div class="intro-search-field">
                                <label for ="intro-keywords" class="field-title ripple-effect">What product you
                                    want?</label>
                                <input id="intro-keywords" type="text" placeholder="Search products">
                            </div>

                            <!-- Button -->
                            <div class="intro-search-button">
                                <button class="button ripple-effect"
                                    onclick="window.location.href='jobs-list-layout-full-page-map.html'">Search</button>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Stats -->
                <div class="row">
                    <div class="col-md-12">
                        <ul class="intro-stats margin-top-45 hide-under-992px">
                            <li>
                                <strong class="counter">1,586</strong>
                                <span>Electronics</span>
                            </li>
                            <li>
                                <strong class="counter">3,543</strong>
                                <span>Furnitures</span>
                            </li>
                            <li>
                                <strong class="counter">1,232</strong>
                                <span>Food & Beverages</span>
                            </li>
                        </ul>
                    </div>
                </div>

            </div>
        </div>

        <center>
            <!-- Content
        ================================================== -->
            <!-- Category Boxes -->
            <div class="section margin-top-65">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-12">

                            <div class="section-headline centered margin-bottom-15">
                                <h3>Popular Job Categories</h3>
                            </div>

                            <!-- Category Boxes Container -->
                            <div class="categories-container">

                                <!-- Category Box -->
                                <a href="jobs-grid-layout-full-page.html" class="category-box">
                                    <div class="category-box-icon">
                                        <i class="icon-line-awesome-power-off"></i>
                                    </div>
                                    <div class="category-box-counter">612</div>
                                    <div class="category-box-content">
                                        <h3>Electronics</h3>
                                        <p>Home Appliances/Office Wares</p>
                                    </div>
                                </a>

                                <!-- Category Box -->
                                <a href="jobs-list-layout-full-page-map.html" class="category-box">
                                    <div class="category-box-icon">
                                        <i class="icon-line-awesome-home"></i>
                                    </div>
                                    <div class="category-box-counter">113</div>
                                    <div class="category-box-content">
                                        <h3>Furnitures</h3>
                                        <p>Chairs / Tables</p>
                                    </div>
                                </a>

                                <!-- Category Box -->
                                <a href="jobs-list-layout-full-page-map.html" class="category-box">
                                    <div class="category-box-icon">
                                        <i class="icon-material-outline-free-breakfast"></i>
                                    </div>
                                    <div class="category-box-counter">186</div>
                                    <div class="category-box-content">
                                        <h3>Food & Beverages</h3>
                                        <p>Vegetables / Fruits</p>
                                    </div>
                                </a>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
            <!-- Category Boxes / End -->

        </center>


        <!-- Features Jobs -->
        <div class="section gray margin-top-45 padding-top-65 padding-bottom-75">
            <div class="container">
                <div class="row">
                    <div class="col-xl-12">

                        <!-- Section Headline -->
                        <div class="section-headline margin-top-0 margin-bottom-35">
                            <h3>Recent Products</h3>
                            <a href="{{ route('all-products') }}" class="headline-link">Browse All Jobs</a>
                        </div>

                        <!-- Jobs Container -->
                        <div class="listings-container compact-list-layout margin-top-35">

                            <!-- Job Listing -->
                            <a href="single-job-page.html" class="job-listing with-apply-button">

                                <!-- Job Listing Details -->
                                <div class="job-listing-details">

                                    <!-- Logo -->
                                    <div class="job-listing-company-logo">
                                        <img src="images/company-logo-01.png" alt="">
                                    </div>

                                    <!-- Details -->
                                    <div class="job-listing-description">
                                        <h3 class="job-listing-title">Bilingual Event Support Specialist</h3>

                                        <!-- Job Listing Footer -->
                                        <div class="job-listing-footer">
                                            <ul>
                                                <li><i class="icon-material-outline-business"></i> Hexagon <div
                                                        class="verified-badge" title="Verified Employer"
                                                        data-tippy-placement="top"></div>
                                                </li>
                                                <li><i class="icon-material-outline-location-on"></i> San Francissco
                                                </li>
                                                <li><i class="icon-material-outline-business-center"></i> Full Time
                                                </li>
                                                <li><i class="icon-material-outline-access-time"></i> 2 days ago</li>
                                            </ul>
                                        </div>
                                    </div>

                                    <!-- Apply Button -->
                                    <span class="list-apply-button ripple-effect">Add to cart</span>
                                </div>
                            </a>
                        </div>
                        <!-- Jobs Container / End -->
                    </div>
                </div>
            </div>
        </div>
        <!-- Featured Jobs / End -->

    </div>
    <!-- Wrapper / End -->


    <!-- Scripts
================================================== -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/jquery-migrate-3.0.0.min.js"></script>
    <script src="js/mmenu.min.js"></script>
    <script src="js/tippy.all.min.js"></script>
    <script src="js/simplebar.min.js"></script>
    <script src="js/bootstrap-slider.min.js"></script>
    <script src="js/bootstrap-select.min.js"></script>
    <script src="js/snackbar.js"></script>
    <script src="js/clipboard.min.js"></script>
    <script src="js/counterup.min.js"></script>
    <script src="js/magnific-popup.min.js"></script>
    <script src="js/slick.min.js"></script>
    <script src="js/custom.js"></script>

    <!-- Snackbar // documentation: https://www.polonel.com/snackbar/ -->
    <script>
        // Snackbar for user status switcher
        $('#snackbar-user-status label').click(function() {
            Snackbar.show({
                text: 'Your status has been changed!',
                pos: 'bottom-center',
                showAction: false,
                actionText: "Dismiss",
                duration: 3000,
                textColor: '#fff',
                backgroundColor: '#383838'
            });
        });
    </script>


    <!-- Google Autocomplete -->
    <script>
        function initAutocomplete() {
            var options = {
                types: ['(cities)'],
                // componentRestrictions: {country: "us"}
            };

            var input = document.getElementById('autocomplete-input');
            var autocomplete = new google.maps.places.Autocomplete(input, options);
        }

        // Autocomplete adjustment for homepage
        if ($('.intro-banner-search-form')[0]) {
            setTimeout(function() {
                $(".pac-container").prependTo(".intro-search-field.with-autocomplete");
            }, 300);
        }
    </script>

    <!-- Google API -->
    <script
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAgeuuDfRlweIs7D6uo4wdIHVvJ0LonQ6g&libraries=places&callback=initAutocomplete">
    </script>

</body>

</html>
