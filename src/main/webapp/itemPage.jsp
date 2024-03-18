<%@ page import="com.example.bidit.Model.Item" %>
<%@ page import="com.example.bidit.Model.User" %>
<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="CSS/viewItem.css" type="text/css">
    <link rel="stylesheet" href="CSS/Navbar.css" type="text/css">
<%
    Item item = (Item)session.getAttribute("item");
    User user = (User) session.getAttribute("user");
%>
    <title>Bidding is on:  <%=item.getItemName()%></title>
</head>
<body>
<div>
    <jsp:include page="component/NavBar2.jsp"></jsp:include>
</div>
<div class="itemPage">
    <div class="itemimage">
        <img src="CSS/img/<%=item.getImage()%>" alt="No image was provided" width="100%">
    </div>
    <div class="itemInformation">
        <div class="itemdetails">
            Title: <%=item.getItemName()%><br>
            Description: <%=item.getDescription()%><br>
            Bid Ends: <%=item.getBidEnd()%><br>
        </div>
        <div class="bidForm">
            Place your own bid:
            <form name="bid" method="get" action="placeBid">
                <input type="hidden" name="itemID" value="<%=item.getId()%>">
                <label>
                    Bid Amount:<br>
                    <input type="number" name="amount" required>
                </label>
                <br><br>
                <label>
                    Consent: I acknowledge by checking this box that I wish to place a bid
                    and that I am accountable for the amount entered.  In addition, I will
                    pay that amount on request.
                    <input type="checkbox" name="consent" required>
                </label><br>
                <button type="submit">Submit</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
