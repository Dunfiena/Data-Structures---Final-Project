<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="CSS/itemForm.css">
    <link rel="stylesheet" href="CSS/Navbar.css">
    <script src="bidit_scripts.js"></script>

    <title>Bidit - Post Item</title>
</head>
<body>
<div>
    <jsp:include page="component/NavBar2.jsp"></jsp:include>
</div>
<div class="postItem">
    <div class="form_header">Post an item for Sale</div>
    <br><br>
    <form name="post_item" action="addItem" method="get">
        <div class="form_body">
            <div class="left_form">
                <label>
                    Title:
                    <input type="text" name="itemName" placeholder="enter title for post" required>
                </label>
                <br><br>
                <label>
                    Price:
                    <input type="number" min="0" max="1000000" name="price" placeholder="enter price" required>
                </label>
                <br><br>
                <label>
                    Description:
                    <input type="text" name="description" placeholder="enter description for post" required>
                </label>
                <br><br>
                <label>
                    Image:
                    <input type="file" name="image" onchange="loadFile(event)" required>
                </label>
            </div>
            <div class="image">
                <img id="output" width="90%"/>
            </div>
            <br>
            <script>
                var loadFile = function(event) {
                    var image = document.getElementById('output');
                    image.src = URL.createObjectURL(event.target.files[0]);
                    image.style.display = "block"
                }
            </script>
            <br><br>
        </div>
        <br>
        <button type="submit" class="submit_button"><b>Register</b></button>
        <br>
        <button type="reset" onclick="loadFileClear()" class="reset_button"><b>Reset</b></button>
    </form>
</div>
<div>

</div>
</body>
</html>
