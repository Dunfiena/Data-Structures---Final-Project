<%@ page import="jakarta.mail.FetchProfile" %>
<%@ page import="com.example.bidit.Model.Item" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
  Item item = (Item)request.getAttribute("item");
%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="../CSS/LandingCSS.css" type="text/css">
    <link rel="stylesheet" href="../CSS/Navbar.css" type="text/css">

    <title>Bidit - Your bids</title>
</head>
<body>
<div>
    <jsp:include page="../component/NavBar2.jsp"></jsp:include>
</div>
<div>

</div>
</body>
</html>
