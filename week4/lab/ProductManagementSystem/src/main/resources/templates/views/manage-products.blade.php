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



        <!-- Dashboard Container -->
        <div class="dashboard-container">


            <!-- Dashboard Sidebar
 ================================================== -->
            <div class="dashboard-sidebar">
                <div class="dashboard-sidebar-inner" data-simplebar>
                    <div class="dashboard-nav-container">

                        <!-- Responsive Navigation Trigger -->
                        <a href="#" class="dashboard-responsive-nav-trigger">
                            <span class="hamburger hamburger--collapse">
                                <span class="hamburger-box">
                                    <span class="hamburger-inner"></span>
                                </span>
                            </span>
                            <span class="trigger-title">Dashboard Navigation</span>
                        </a>

                        <!-- Navigation -->
                        <div class="dashboard-nav">
                            <div class="dashboard-nav-inner">

                                <ul data-submenu-title="Start">
                                    <li class="active"><a href="dashboard.html"><i
                                                class="icon-material-outline-dashboard"></i> Dashboard</a></li>
                                </ul>

                                <ul data-submenu-title="Organize and Manage">
                                    <li><a href="#"><i class="icon-material-outline-business-center"></i> Jobs</a>
                                        <ul>
                                            <li><a href="dashboard-manage-jobs.html">Manage products <span
                                                        class="nav-tag">3</span></a></li>
                                            <li><a href="dashboard-manage-candidates.html">Manage categories</a></li>
                                            <li><a href="dashboard-post-a-job.html">Add Product</a></li>
                                        </ul>
                                    </li>
                                </ul>

                                <ul data-submenu-title="Account">
                                    <li><a href="dashboard-settings.html"><i class="icon-material-outline-settings"></i>
                                            Settings</a></li>
                                    <li><a href="index-logged-out.html"><i
                                                class="icon-material-outline-power-settings-new"></i> Logout</a></li>
                                </ul>

                            </div>
                        </div>
                        <!-- Navigation / End -->

                    </div>
                </div>
            </div>
            <!-- Dashboard Sidebar / End -->


            <!-- Dashboard Content
 ================================================== -->
            <div class="dashboard-content-container" data-simplebar>
                @include('includes.notification')
                <div class="dashboard-content-inner">
                    <!-- Fun Facts Container -->
                    <div class="fun-facts-container">
                        <div class="fun-fact" data-fun-fact-color="#36bd78">
                            <div class="fun-fact-text">
                                <span>Electronics</span>
                                <h4>22</h4>
                            </div>
                            <div class="fun-fact-icon"><i class="icon-material-outline-power-settings-new"></i></div>
                        </div>
                        <div class="fun-fact" data-fun-fact-color="#b81b7f">
                            <div class="fun-fact-text">
                                <span>Furnitures</span>
                                <h4>4</h4>
                            </div>
                            <div class="fun-fact-icon"><i class="icon-line-awesome-home"></i></div>
                        </div>
                        <div class="fun-fact" data-fun-fact-color="#efa80f">
                            <div class="fun-fact-text">
                                <span>Food & Beverages</span>
                                <h4>28</h4>
                            </div>
                            <div class="fun-fact-icon"><i class="icon-line-awesome-coffee"></i></div>
                        </div>

                        <div class="fun-fact" data-fun-fact-color="#2a41e6">
                            <div class="fun-fact-text">
                                <span>All products</span>
                                <h4>987</h4>
                            </div>
                            <div class="fun-fact-icon"><i class="icon-material-outline-add-shopping-cart"></i></div>
                        </div>
                    </div>

                    <!-- Row -->
                    <div class="row">

                        <div class="col-xl-8">
                            <!-- Dashboard Box -->
                            <div class="dashboard-box main-box-in-row">
                                <div class="headline">
                                    <h3><i class="icon-feather-bar-chart-2"></i> Filter by category</h3>
                                    <div class="sort-by">
                                        <select class="selectpicker hide-tick">
                                            <option>Electronics</option>
                                            <option>Furnitures</option>
                                            <option>Food & Baverages</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <!-- Dashboard Box / End -->
                        </div>
                        <div class="col-xl-4">

                            <!-- Dashboard Box -->
                            <!-- If you want adjust height of two boxes
      add to the lower box 'main-box-in-row'
      and 'child-box-in-row' to the higher box -->
                            <div class="dashboard-box child-box-in-row">
                                <div class="headline">
                                    <h3><i class="icon-material-outline-note-add"></i> Notes</h3>
                                </div>
                                <div class="add-note-button">
                                    <a href="#small-dialog"
                                        class="popup-with-zoom-anim button full-width button-sliding-icon">Add Product
                                        <i class="icon-material-outline-arrow-right-alt"></i></a>
                                </div>
                            </div>
                            <!-- Dashboard Box / End -->
                        </div>
                    </div>
                    <!-- Row / End -->

                    <!-- Row -->
                    <div class="dashboard-box">
                        <div class="headline">
                            <h3><i class="icon-material-outline-assignment"></i> Products</h3>
                        </div>
                        <div class="content">
                            <ul class="dashboard-box-list">
                                @foreach ($products as $product)
                                    <li>
                                        <div class="invoice-list-item">
                                            <strong>Professional Plan</strong>
                                            <ul>
                                                <li>
                                                    <a href="#edit"><span class="paid">Edit</span></a>
                                                </li>
                                                <li>Price: ${{ $product->price }}</li>
                                            </ul>
                                        </div>
                                        <!-- Buttons -->
                                        <div class="buttons-to-right">
                                            <a onclick="event.preventDefault(); document.getElementById('{{ $product->productId }}-form').submit()"
                                                class="button gray">Delete</a>
                                        </div>
                                        <form id="{{ $product->productId }}-form"
                                            action="{{ route('products.destroy', $product->productId) }}" method="POST"
                                            style="display: none;">
                                            @method('DELETE')
                                            @csrf
                                        </form>
                                    </li>
                                @endforeach
                            </ul>
                        </div>

                    </div>
                    <!-- Row / End -->

                </div>
            </div>
            <!-- Dashboard Content / End -->

        </div>
        <!-- Dashboard Container / End -->

    </div>
    <!-- Wrapper / End -->


    <!-- Apply for a job popup
================================================== -->
    <div id="small-dialog" class="zoom-anim-dialog mfp-hide dialog-with-tabs">

        <!--Tabs -->
        <div class="sign-in-form">

            <ul class="popup-tabs-nav">
                <li><a href="#tab">Add Product</a></li>
            </ul>

            <div class="popup-tabs-container">

                <!-- Tab -->
                <div class="popup-tab-content" id="tab">

                    <!-- Welcome Text -->
                    <div class="welcome-text">
                        <h3>New product huh? 😎</h3>
                    </div>

                    <!-- Form -->
                    <form method="post" id="add-note">

                        <select class="selectpicker with-border default margin-bottom-20" data-size="7"
                            title="Category">
                            <option>Furnitures</option>
                            <option>Electronics</option>
                            <option>Food & Beverages</option>
                        </select>

                        <textarea name="textarea" cols="10" placeholder="Note" class="with-border"></textarea>

                    </form>

                    <!-- Button -->
                    <button class="button full-width button-sliding-icon ripple-effect" type="submit"
                        form="add-note">Add Product <i class="icon-material-outline-arrow-right-alt"></i></button>

                </div>
            </div>
        </div>
    </div>
    <!-- Apply for a job popup / End -->
    <!-- Apply for a job popup
        ================================================== -->
    <div id="small-dialog" class="zoom-anim-dialog mfp-hide dialog-with-tabs">

        <!--Tabs -->
        <div class="sign-in-form">

            <ul class="popup-tabs-nav">
                <li><a href="#edit">Add Product</a></li>
            </ul>

            <div class="popup-tabs-container">

                <!-- Tab -->
                <div class="popup-tab-content" id="edit">

                    <!-- Welcome Text -->
                    <div class="welcome-text">
                        <h3>New Product 😎</h3>
                    </div>

                    <!-- Form -->
                    <form method="post" id="add-note">
                        @csrf

                        <select class="selectpicker with-border default margin-bottom-20" data-size="7"  title="Priority">
                            <option>Low Priority</option>
                            <option>Medium Priority</option>
                            <option>High Priority</option>
                        </select>
                        <textarea name="textarea" cols="10" placeholder="Note" class="with-border"></textarea>
                    </form>

                    <!-- Button -->
                    <button class="button full-width button-sliding-icon ripple-effect" type="submit"
                        form="add-note">Add Product <i class="icon-material-outline-arrow-right-alt"></i></button>

                </div>
            </div>
        </div>
    </div>
    <!-- Apply for a job popup / End -->


    @include('includes.scripts')
</body>

</html>
