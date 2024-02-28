package com.example.bidit.DAO;

import com.example.bidit.Model.Banking;

import java.sql.SQLException;

public interface bankingDAO {
    public int insert (Banking bank) throws SQLException;
    public int update (int bankID) throws SQLException;
    public int delete (int bankID) throws SQLException;
    public Banking select (String userName, String Password) throws SQLException;
    public Banking insert (String userName, String email, String password) throws SQLException;
}
