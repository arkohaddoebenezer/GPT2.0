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

<body class="gray">

    <!-- Wrapper -->
    <div id="wrapper">

        <!-- Page Content
================================================== -->
        <div class="full-page-container">

            <div class="full-page-sidebar">
                <div class="full-page-sidebar-inner" data-simplebar>
                    <div class="sidebar-container">
                        <!-- Keywords -->
                        <div class="sidebar-widget">
                            <h3>Keywords</h3>
                            <div class="keywords-container">
                                <div class="keyword-input-container">
                                    <input type="text" class="keyword-input" placeholder="e.g. search product" />
                                    <button class="keyword-input-button ripple-effect"><i
                                            class="icon-material-outline-search"></i></button>
                                </div>
                                <div class="keywords-list"><!-- keywords go here --></div>
                                <div class="clearfix"></div>
                            </div>
                        </div>

                        <!-- Category -->
                        <div class="sidebar-widget">
                            <h3>Category</h3>
                            <select class="selectpicker default" multiple data-selected-text-format="count"
                                data-size="7" title="All Categories">
                                <option>Electronics</option>
                                <option>Furnitures</option>
                                <option>Food & Beverages</option>
                            </select>
                            <div class="sidebar-search-button-container">
                                <button onclick="window.location.href='{{ route('manage-products') }}'" class="button ripple-effect">Manage Products</button>
                            </div>
                        </div>

                    </div>
                    <!-- Sidebar Container / End -->
                </div>
            </div>
            <!-- Full Page Sidebar / End -->

            <!-- Full Page Content -->
            <div class="full-page-content-container" data-simplebar>
                <div class="full-page-content-inner">
                    <div class="listings-container grid-layout margin-top-35">
                        @foreach ($products as $product)
                            <!-- Job Listing -->
                            <a href="#" class="job-listing">
                                <div class="job-listing-details">
                                    <div class="job-listing-company-logo">
                                        <img src="images/company-logo-0{{ rand(1,5) }}.png" alt="">
                                    </div>
                                    <!-- Details -->
                                    <div class="job-listing-description">
                                        <h3 class="job-listing-title">{{ $product->name }}</h3>
                                    </div>
                                </div>
                                <!-- Job Listing Footer -->
                                <div class="job-listing-footer">
                                    <span class="bookmark-icon"></span>
                                    <ul>
                                        <li><i class="icon-material-outline-account-balance-wallet"></i>
                                           ${{$product->price}} </li>
                                        <li><i class="icon-material-outline-access-time"></i>{{ rand(1, 30) }} days
                                            ago</li>
                                    </ul>
                                </div>
                            </a>
                        @endforeach
                    </div>
                    <!-- Pagination -->
                    <div class="clearfix"></div>
                    <div class="pagination-container margin-top-20 margin-bottom-20">
                        <nav class="pagination">
                            <ul>
                                <li class="pagination-arrow"><a href="#" class="ripple-effect"><i
                                            class="icon-material-outline-keyboard-arrow-left"></i></a></li>
                                <li><a href="#" class="ripple-effect">1</a></li>
                                <li><a href="#" class="ripple-effect current-page">2</a></li>
                                <li><a href="#" class="ripple-effect">3</a></li>
                                <li class="pagination-arrow"><a href="#" class="ripple-effect"><i
                                            class="icon-material-outline-keyboard-arrow-right"></i></a></li>
                            </ul>
                        </nav>
                    </div>
                    <div class="clearfix"></div>
                    <!-- Pagination / End -->
                </div>
            </div>
            <!-- Full Page Content / End -->
        </div>
        <!-- Wrapper / End -->

        @include('includes.scripts')
</body>

</html>
