<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="./CSS/Navbar.css">
    <title>Bidit - Landing Page</title>
</head>
<style>
    .call {
        font-size: 2.2vw;
        color: firebrick;
    }
</style>
<body>
<div>
    <jsp:include page="component/NavBar.jsp"></jsp:include>
</div>

<div class="call">
    <svg viewBox="0 -10 500 160">
        <path id="curve" d="M73.2,148.6c4-6.1,65.5-96.8,178.6-95.6c111.3,1.2,170.8,90.3,175.1,97" />
        <text width="1000">
            <textPath alignment-baseline="top" xlink:href="#curve">
                Welcome to the Internet's S**T show
            </textPath>
        </text>
    </svg>
</div>
</body>
</html>