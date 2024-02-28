
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="../CSS/loginPageCSS.css">
    <link rel="stylesheet" href="../CSS/Navbar.css">

    <title>Bidit - Login</title>
</head>
<body>
<div>
    <jsp:include page="../component/NavBar2.jsp"></jsp:include>
</div>
<div class="login-body">
    <div class="Middle_break"></div>
    <div class="loginSide">
        <div class="form_header">Login</div>
        <br><br>
        <form name="loginform" method="post" action="login">
            <label>
                User Name:
                <input type="text" name="userName" placeholder="enter user name" required>
            </label>
            <br> <br>
            <label>
                Password:
                <input type="password" name="password" placeholder="enter password" required>
            </label>
            <br><br>
            <button type="submit" class="submit_button"><b>Login</b></button>
            <br>
            <button class="reset_button" type="reset"><b>Reset</b></button>

        </form>

    </div>

    <div class="Middle_break"></div>

    <div class="registerSide">
        <div class="form_header">Register</div>
        <br>
        <form name="registerform" method="post" action="register">

            <label>
                User Name:
                <input type="text" name="userName" placeholder="enter user name" required>
            </label>
            <br>
            <label>
                First Name:
                <input type="text" name="fname" placeholder="enter first name" required>
            </label>
            <br>
            <label>
                Last Name:
                <input type="text" name="lname" placeholder="enter last name" required>
            </label>
            <br>
            <label>
                Date of Birth:
                <input type="date" name="dob">
            </label>
            <br>
            <label>
                Phone number:
                <input type="text" name="phone" placeholder="enter phone number" required>
            </label>
            <br>
            <label>
                Email:
                <input type="text" name="email" placeholder="enter a valid email" required>
            </label>
            <br>
            <label>
                Password:
                <input type="password" name="password" placeholder="enter password" required>
            </label>
            <br><br>
            <button type="submit" class="submit_button"><b>Register</b></button>
            <br>
            <button type="reset" class="reset_button"><b>Reset</b></button>
        </form>

    </div>
</div>
</body>
</html>
