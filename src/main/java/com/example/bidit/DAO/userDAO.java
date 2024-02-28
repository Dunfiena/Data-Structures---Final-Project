package com.example.bidit.DAO;

import com.example.bidit.Model.User;

import java.sql.SQLException;

public interface userDAO {
    public int insert (User user) throws SQLException;
    public int update (int userID) throws SQLException;
    public int delete (int userID) throws SQLException;
    public User select (String userName, String Password) throws SQLException;
    public User insert (String userName, String email, String password) throws SQLException;
}
