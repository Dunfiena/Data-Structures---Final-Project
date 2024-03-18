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
    <link rel="stylesheet" href="CSS/searchPage.css" type="text/css">
    <link rel="stylesheet" href="CSS/Navbar.css" type="text/css">

    <title>Bidit - Search</title>
</head>
<body>

<div>
    <jsp:include page="component/NavBar2.jsp"></jsp:include>
</div>

<div class="searchbody">
    <div class="itemCards">
        <% if (!items.isEmpty()){
        for (Item item:items){%>

        <form action="itemDisplay" id="choice" method="get">
            <input type="hidden" value="<%=item.getId()%>" name="id">
            <a  href="javascript:{}" onclick="document.getElementById('choice').submit();">
                <div class="card">
                    <div class="cardImg">
                        <img src="CSS/img/<%=item.getImage()%>" alt="No image uploaded for this item">
                    </div>
                    <div class="cardDescription">
                        <table>
                            <tr>
                                <th>Item Name</th>
                                <th>Description</th>
                                <th>Bid Ending</th>
                            </tr>
                            <tr>
                                <th><%=item.getItemName()%></th>
                                <th><%=item.getDescription()%></th>
                                <th><%=item.getBidEnd()%></th>
                            </tr>
                        </table>
                    </div>
                </div>
                </a>
        </form>
        <%}
            }%>
    </div>
</div>
</body>
</html>
