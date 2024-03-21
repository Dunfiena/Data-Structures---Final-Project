<%@ page import="com.example.bidit.Model.Item" %>
<%@ page import="com.example.bidit.DataHandler.DataStructure" %>
<%@ page import="com.example.bidit.Controller.userController" %>
<%@ page import="com.example.bidit.Model.User" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    //This page is for testing purposed to show the effective use of the algorithm
    DataStructure dt = (DataStructure)session.getAttribute("winner");
    Item item = (Item)session.getAttribute("item");
    User user = null;

%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="get" action="bidEnds">
    <input type="number" name="itemID">
    <button type="submit">submit</button>
</form>

<% if(dt !=null){
    userController uCon = new userController();
    try {
        user = uCon.select(dt.getUserId());
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
        %>
<br><br>
USER ID ====  <%=dt.getUserId()%><br>
BID AMOUNT ==== <%=dt.getBidAmount()%><br>
BID TIME ==== <%=dt.getTime()%><br><br><br>
The winner was user# <%=user.getId()%><br>
first name = <%=user.getFirstName()%><br>
last name = <%=user.getLastName()%><br>
<%}%>

</body>
</html>
