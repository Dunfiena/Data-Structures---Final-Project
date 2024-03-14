package com.example.bidit.Controller;

import com.example.bidit.DAO.addressDAO;
import com.example.bidit.Model.Address;
import com.example.bidit.Model.Banking;
import com.example.bidit.Model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.example.bidit.Controller.DataConnection.getConnection;

public class addressController implements addressDAO {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    Address address = new Address();
    ArrayList<Address> addressArrayList;

    @Override
    public Address insert(int StreetNo, String streetName, String city, String PostalCode, String province, String country) throws SQLException {
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("INSERT INTO address(StreetNo, streetName, city, PostalCode, province, country) VALUES (?,?,?,?,?,?)");
            stmt.setInt(1, StreetNo);
            stmt.setString(2, streetName);
            stmt.setString(3, city);
            stmt.setString(4, PostalCode);
            stmt.setString(5, province);
            stmt.setString(6, country);

            stmt.executeUpdate();

            stmt = conn.prepareStatement("SELECT * FROM address WHERE StreetNo = ? and streetName =?");
            stmt.setInt(1, StreetNo);
            stmt.setString(2, streetName);
            stmt.executeQuery();

            address = select(StreetNo, streetName, city, PostalCode, province, country);
            return address;

        } catch (Exception ex) {
            System.out.println("Error:" + ex.getMessage());
        }
        return address;
    }

    public Address select(int StreetNo, String streetName, String city, String PostalCode, String province, String country) throws SQLException {
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT * FROM address WHERE StreetNo=? and streetName=? and city=? and PostalCode=? and province=? and country=?");
            stmt.setInt(1, StreetNo);
            stmt.setString(1, streetName);
            stmt.setString(1, city);
            stmt.setString(1, PostalCode);
            stmt.setString(1, province);
            stmt.setString(1, country);

            rs = stmt.executeQuery();

            if (rs.next()) {
                address = new Address(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)
                );
                return address;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return address;
    }

    @Override
    public Address select(int addressId) throws SQLException {
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT * FROM address WHERE AddressID = ?");
            stmt.setInt(1, addressId);
            rs = stmt.executeQuery();

            if (rs.next()) {
                address = new Address(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)
                        );
                return address;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return address;
    }

    @Override
    public void update(Address address) throws SQLException {
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("UPDATE address SET StreetNo=?, streetName=?, city=?, PostalCode=?, province=?, country=? WHERE AddressID=?;");
            stmt.setInt(1, address.getStreetNo());
            stmt.setString(2, address.getStreetName());
            stmt.setString(3, address.getCity());
            stmt.setString(4, address.getPostal());
            stmt.setString(5, address.getProvince());
            stmt.setString(6, address.getCountry());
            stmt.setInt(7, Math.toIntExact(address.getId()));

            stmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int addressID) throws SQLException {
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("DELETE FROM address WHERE AddressID=?;");
            stmt.setInt(1, addressID);
            stmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
