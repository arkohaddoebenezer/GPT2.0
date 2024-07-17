@if (session()->has('success'))
    <div class="notification success closeable">
        <p>{{ session('success') }}</p>
        <a class="close"></a>
    </div>
@elseif (session()->has('failure'))
    <div class="notification danger closeable">
        <p>{{ session('failure') }}</p>
        <a class="close"></a>
    </div>
@endif

@if (session()->has('info'))
    <div class="notification info closeable">
        <p>{{ session('info') }}</p>
        <a class="close"></a>
    </div>
@endif
