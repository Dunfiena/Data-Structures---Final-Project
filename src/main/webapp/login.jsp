
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="CSS/loginPageCSS.css">
    <link rel="stylesheet" href="CSS/Navbar.css">

    <title>Bidit - Login</title>
</head>
<body>
<div>
    <jsp:include page="component/NavBar2.jsp"></jsp:include>
</div>
<div class="login-body">
    <div class="loginSide">
        <div class="form_header">Login</div>
        <br>
        <form name="loginform" method="get" action="login">
            <a href="register.jsp" style="font-size: 1.5vw">Need to register?</a><br>
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
    <div class="registerSidelog">
            <div class="callLogin">
                <svg viewBox="0 -10 500 160">
                    <path id="curve" d="M73.2,148.6c4-6.1,65.5-96.8,178.6-95.6c111.3,1.2,170.8,90.3,175.1,97" />
                    <text width="100">
                        <textPath alignment-baseline="top" xlink:href="#curve">
                            Welcome to the Internet's S**T show
                        </textPath>
                    </text>
                </svg>
            </div>
        </div>
</div>
</body>
</html>
