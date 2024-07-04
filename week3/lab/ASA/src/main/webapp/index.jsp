<!DOCTYPE html>
<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
        }

        * {
            box-sizing: border-box;
        }

        input[type=text],
        select,
        textarea {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            margin-top: 6px;
            margin-bottom: 16px;
            resize: vertical;
        }

        input[type=submit] {
            background-color: #04AA6D;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }

        .container {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
        }
    </style>
</head>

<body>
    <h3>Advanced Sorting Algorithm</h3>

    <div class="container">
        <form action="/advanced_sorting_algorithm/sort" method="post">
            <label for="fname">Input your array values here</label>
        <textarea name="" id=""></textarea>
            <label for="sort_type">Select Sorting Algorithm</label>
            <select id="sort_type" name="sort_type">
                <option value="Heap">Heap</option>
                <option value="Quick">Quick</option>
                <option value="Merge">Merge</option>
                <option value="Radix">Radix</option>
                <option value="Bucket">Bucket</option>
            </select>
            <input type="submit" value="Sort">
        </form>
    </div>
    <div class="container">
        <input type="text" id="sort_array" value="${sort_type}" placeholder="sorted array">
    </div>
</body>

</html>