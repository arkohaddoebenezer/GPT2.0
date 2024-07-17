<!-- Scripts
    ================================================== -->
            <script src="{{asset('js/jquery-3.3.1.min.js')}}"></script>
            <script src="{{asset('js/jquery-migrate-3.0.0.min.js')}}"></script>
            <script src="{{asset('js/mmenu.min.js')}}"></script>
            <script src="{{asset('js/tippy.all.min.js')}}"></script>
            <script src="{{asset('js/simplebar.min.js')}}"></script>
            <script src="{{asset('js/bootstrap-slider.min.js')}}"></script>
            <script src="{{asset('js/bootstrap-select.min.js')}}"></script>
            <script src="{{asset('js/snackbar.js')}}"></script>
            <script src="{{asset('js/clipboard.min.js')}}"></script>
            <script src="{{asset('js/counterup.min.js')}}"></script>
            <script src="{{asset('js/magnific-popup.min.js')}}"></script>
            <script src="{{asset('js/slick.min.js')}}"></script>
            <script src="{{asset('js/custom.js')}}"></script>


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
            </script>

            <!-- Google API & Maps -->
            <!-- Geting an API Key: https://developers.google.com/maps/documentation/javascript/get-api-key -->
            <script src="https://maps.googleapis.com/maps/api/js?key=&libraries=places"></script>
