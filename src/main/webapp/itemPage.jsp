<%@ page import="com.example.bidit.Model.Item" %>
<%@ page import="com.example.bidit.Model.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="CSS/LandingCSS.css" type="text/css">
    <link rel="stylesheet" href="CSS/Navbar.css" type="text/css">
<%
    Item item = (Item)request.getAttribute("items");
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
        <img src="<%=item.getImage()%>" alt="No image was provided">
    </div>
    <div class="itemInformation">
        <div class="itemdetails">
            Title: <%=item.getItemName()%>
            Description: <%=item.getDescription()%>
            Bid Ends: <%=item.getBidEnd()%>
        </div>
        <div class="bidForm">
            Place your own bid:
            <form name="bid" method="get" action="placeBid">
                <input type="hidden" name="itemID" value="<%=item.getId()%>">
                <label>
                    Bid Amount:
                    <input type="number" name="amount" required>
                </label>
                <br>
                <label>
                    Consent: I acknowledge by checking this box that I wish to place a bid
                    and that I am accountable for the amount entered.  In addition, I will
                    pay that amount on request.
                    <input type="checkbox" name="consent" required>
                </label>


            </form>
        </div>
    </div>
</div>

</body>
</html>
