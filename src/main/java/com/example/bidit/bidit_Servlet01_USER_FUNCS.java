package com.example.bidit;

import com.example.bidit.Controller.*;
import com.example.bidit.Model.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class bidit_Servlet01_USER_FUNCS extends HttpServlet {
    userController uControl;
    bankingController bankControl;
    addressController addressControl;
    itemController itemControl;
    bidController bidControl;

    User user;
    Banking bank;
    Address address;
    Item item;
    Bid bid;

    ArrayList<Item> items;
    ArrayList<Bid> bids;

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response){
        String url = request.getServletPath();
        switch (url) {
            case "/login":
                try {
                    login(request, response);
                } catch (ServletException | SQLException | IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/register":
                try {
                    register(request, response);
                } catch (SQLException | ServletException | IOException e) {
                    throw new RuntimeException(e);
                }
        }
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String username = request.getParameter("userName");
        String password = request.getParameter("password");

        user = uControl.select(username, password);

        setRequestReturn(request, response);
    }



    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int accountNum = Integer.parseInt(request.getParameter("accountNum"));
        int branchNum = Integer.parseInt(request.getParameter("branchNum"));
        int transitNum = Integer.parseInt(request.getParameter("transitNum"));

        bank = bankControl.insert(accountNum,branchNum,transitNum);

        int houseNum = Integer.parseInt(request.getParameter("houseNum"));
        String streetName = request.getParameter("streetName");
        String city = request.getParameter("city");
        String postalCode = request.getParameter("postalcode");
        String province = request.getParameter("province");
        String country = request.getParameter("country");

        address = addressControl.insert(houseNum, streetName, city, postalCode, province, country);

        String username = request.getParameter("userName");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String dateofBirth = request.getParameter("dob");
        String Phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String password = request.getParameter("password");


        uControl.insert(username,fname,lname,dateofBirth, Phone, email,
                Math.toIntExact(bank.getId()), Math.toIntExact(address.getId()),password);
        user = uControl.select(username, password);

        setRequestReturn(request, response);
    }

    private void setRequestReturn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("user", user);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/displayPage.jsp");
        rd.include(request,response);
        rd.forward(request,response);
        response.sendRedirect("pages/displayPage.jsp");
    }

    public void destroy() {
    }
}
