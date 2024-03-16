<%@ page import="com.example.bidit.Model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.bidit.Model.Item" %>
<%@ page import="com.example.bidit.Controller.itemController" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    User user = (User) session.getAttribute("user");
    ArrayList<Item> items = new ArrayList<>();
    itemController icon = new itemController();

    try {
        items = icon.selectAll();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="CSS/LandingCSS.css" type="text/css">
    <link rel="stylesheet" href="CSS/Navbar.css" type="text/css">

    <title>Bidit - Search</title>
</head>
<body>
<div>
    <jsp:include page="component/NavBar2.jsp"></jsp:include>
</div>
<div class="searchBar">
    <form name="searchBar" action="searchBar" method="get">
        <input type="text" name="search" placeholder="Enter desired text">
        <button type="submit">Search</button>
    </form>
</div>
<div class="itemCards">
    <% if (!items.isEmpty()){
    for (Item item:items){%>
    <div class="card">
        <img src="<%=item.getImage()%>" alt="No image uploaded for this item">
        Item Name: <%=item.getItemName()%>
        Description: <%=item.getDescription()%>
        Bid Ending: <%=item.getBidEnd()%>
    </div>
    <%}
        }%>
</div>
</body>
</html>
