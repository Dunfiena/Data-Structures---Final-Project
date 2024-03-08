package com.example.bidit.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnection {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/bidit";
        String uname = "root";
        String pass = "";
        return DriverManager.getConnection(url, uname, pass);
    }

}
