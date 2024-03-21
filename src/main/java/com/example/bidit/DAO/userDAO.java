package com.example.bidit.DAO;

import com.example.bidit.Model.User;

import java.sql.SQLException;

public interface userDAO {
    public void insert (String userName, String fname, String lname, String dob, String phone, String email, int bankId, int addressId, String password) throws SQLException;

    User select(int userID) throws SQLException;

    public void update (User user) throws SQLException;
    public void delete (int userID) throws SQLException;
    public User select (String userName, String Password) throws SQLException;
}
