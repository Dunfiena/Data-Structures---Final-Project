package com.example.bidit.DAO;

import com.example.bidit.Model.Address;

import java.sql.SQLException;

public interface addressDAO {
    public int insert (Address address) throws SQLException;
    public int update (int addressID) throws SQLException;
    public int delete (int addressID) throws SQLException;
    public Address select (String userName, String Password) throws SQLException;
    public Address insert (String userName, String email, String password) throws SQLException;
}
