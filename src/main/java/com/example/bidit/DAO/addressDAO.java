package com.example.bidit.DAO;

import com.example.bidit.Model.Address;

import java.sql.SQLException;

public interface addressDAO {
    public Address insert (int StreetNo, String streetName, String city, String PostalCode, String province, String country) throws SQLException;
    public void update (Address address) throws SQLException;
    public void delete (int addressID) throws SQLException;
    public Address select (int addressId) throws SQLException;
}
