<%@ page import="jakarta.mail.FetchProfile" %>
<%@ page import="com.example.bidit.Model.Item" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.bidit.Model.Bid" %>
<%@ page import="com.example.bidit.Controller.bidController" %>
<%@ page import="com.example.bidit.Model.User" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.example.bidit.Controller.itemController" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    User user = (User) session.getAttribute("user");
    ArrayList<Bid> bids = new ArrayList<Bid>();
    bidController bcon = new bidController();

    try {
        bids = bcon.selectAll(user.getId());
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="CSS/LandingCSS.css" type="text/css">
    <link rel="stylesheet" href="CSS/Navbar.css" type="text/css">

    <title>Bidit - Your bids</title>
</head>
<body>
<div>
    <jsp:include page="component/NavBar2.jsp"></jsp:include>
</div>
<div class="my Bids:">
    <div class="bidBody">
        <% if (!bids.isEmpty()){
            for (Bid b: bids) {
                Item item = new Item();
                itemController icon = new itemController();
                try {
                    item = icon.select(b.getItemID());
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        %>
        <div class="card">
            <img src="<%=item.getImage()%>" alt="No image uploaded for this item">
            Item Name: <%=item.getItemName()%>
            Description: <%=item.getDescription()%>
            Bid Ending: <%=item.getBidEnd()%>

            Your current bid: <%=b.getAmount()%>
            Bid cast: <%=b.getBidcastTime()%>
        </div>
        <%}
        }%>
    </div>
</div>
</body>
</html>
