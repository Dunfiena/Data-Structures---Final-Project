package com.example.bidit;

import com.example.bidit.Controller.*;
import com.example.bidit.DataHandler.Algorithm;
import com.example.bidit.DataHandler.DataStructure;
import com.example.bidit.Model.*;
import jakarta.json.bind.config.BinaryDataStrategy;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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

    User user = new User();
    Banking bank = new Banking();
    Address address = new Address();
    Item item = new Item();
    Bid bid = new Bid();

    ArrayList<Item> items;
    ArrayList<Bid> bids;

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
            case "/addItem":
                try {
                    addItem(request, response);
                } catch (ServletException | SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/placeBid":
                try {
                    placeBid(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

            case "/itemDisplay":
                try {
                    itemDisplay(request,response);
                } catch (SQLException | ServletException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/bidEnds":
                try {
                    generateWinner(request,response);
                } catch (SQLException | ServletException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    private void generateWinner(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        HttpSession sess = request.getSession();

        itemControl = new itemController();
        bidControl = new bidController();

        DataStructure dt = new DataStructure();
        ArrayList<DataStructure> dataStructures = new ArrayList<>();
        Algorithm algo = new Algorithm();

        int itemID = Integer.parseInt(request.getParameter("itemID"));
        Item item = itemControl.select(itemID);

        ArrayList<Bid> bidArrayList = new ArrayList<>();
        bidArrayList = bidControl.selectAll(item);

        for (Bid bid: bidArrayList) {
            dt = new DataStructure(bid.getUserID(), bid.getAmount(), bid.getBidcastTime());
            dataStructures.add(dt);
        }
        dt = algo.returnWinner(dataStructures);

        sess.setAttribute("winner", dt);
        sess.setAttribute("item", item);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/winner.jsp");
        rd.include(request, response);
        rd.forward(request, response);
        response.sendRedirect("winner.jsp");
    }

    private void itemDisplay(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        HttpSession sess = request.getSession();

        int id = Integer.parseInt(request.getParameter("id"));

        itemControl = new itemController();

        item = itemControl.select(id);
        sess.removeAttribute("item");
        sess.setAttribute("item", item);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/itemPage.jsp");
        rd.include(request, response);
        rd.forward(request, response);
        response.sendRedirect("itemPage.jsp");

    }

    private void placeBid(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        HttpSession sess = request.getSession();
        user =(User)sess.getAttribute("user");
        int itemID = Integer.parseInt(request.getParameter("itemID"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        bidControl = new bidController();
        bidControl.insert(user.getId(), itemID, amount);
        response.sendRedirect("bidPage.jsp");

    }

    private void addItem(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        HttpSession sess = request.getSession();
        user = (User) sess.getAttribute("user");
        String itemName = request.getParameter("itemName");
        int price = Integer.parseInt(request.getParameter("price"));
        String description = request.getParameter("description");
        String image = request.getParameter("image");

        itemControl = new itemController();
        itemControl.insert(user.getId(), itemName, price, description, image);

        sess.setAttribute("user", user);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/bidPage.jsp");
        rd.include(request,response);
        rd.forward(request,response);
        response.sendRedirect("bidPage.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response){

    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        HttpSession sess = request.getSession();

        String username = request.getParameter("userName");
        String password = request.getParameter("password");

        uControl = new userController();
        user = uControl.select(username, password);

        sess.setAttribute("user", user);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/bidPage.jsp");
        rd.include(request,response);
        rd.forward(request,response);
        response.sendRedirect("bidPage.jsp");

    }



    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        HttpSession sess = request.getSession();

        bankControl = new bankingController();
        addressControl = new addressController();
        uControl = new userController();
        bank = new Banking();
        address = new Address();
        user = new User();

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

        sess.setAttribute("user", user);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/bidPage.jsp");
        rd.include(request,response);
        rd.forward(request,response);
        response.sendRedirect("bidPage.jsp");
    }



    public void destroy() {
    }
}
