<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="../CSS/LandingCSS.css">
    <link rel="stylesheet" href="../CSS/Navbar.css">

    <title>Bidit - Post Item</title>
</head>
<body>
<div>
    <jsp:include page="../component/NavBar2.jsp"></jsp:include>
</div>
<div class="postItem">
    <div class="form_header">Login</div>
    <br><br>
    <form name="post_item" action="postItem" method="post">
        <label>
            Title:
            <input type="text" name="itemName" placeholder="enter title for post" required>
        </label>

        <label>
            Price:
            <input type="number" min="0" max="1000000" name="price" placeholder="enter price" required>
        </label>

        <label>
            Price:
            <input type="text" name="description" placeholder="enter description for post" required>
        </label>

        <label>
            Image:
            <input type="file" name="images" onchange="loadFile(event)" required>
        </label>
        <img id="output" width="20%"/>

        <script>
            var loadFile = function(event) {
                var image = document.getElementById('output');
                image.src = URL.createObjectURL(event.target.files[0]);
            }
        </script>
        <br><br>
        <button type="submit" class="submit_button"><b>Register</b></button>
        <br>
        <button type="reset" class="reset_button"><b>Reset</b></button>

    </form>
</div>
<div>

</div>
</body>
</html>
