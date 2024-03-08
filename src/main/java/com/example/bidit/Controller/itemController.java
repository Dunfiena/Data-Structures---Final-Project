package com.example.bidit.Controller;

import com.example.bidit.DAO.itemDAO;
import com.example.bidit.Model.Address;
import com.example.bidit.Model.Item;

import java.sql.*;
import java.util.ArrayList;

import static com.example.bidit.Controller.DataConnection.getConnection;

public class itemController implements itemDAO {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    Item item;
    ArrayList<Item> itemArrayList;

    @Override
    public void insert(int ownerID, String itemName, double Price, String description, int addressID, Date bidEnd, String image) throws SQLException {
        try{
            conn = getConnection();
            stmt = conn.prepareStatement("INSERT INTO item(ownerID, itemName, Price, description, addressID, bidEnd, image) VALUES (?,?,?,?,?,?,?)");
            stmt.setInt(1, ownerID);
            stmt.setString(2, itemName);
            stmt.setDouble(3, Price);
            stmt.setString(4, description);
            stmt.setInt(5, addressID);
            stmt.setDate(6, bidEnd);
            stmt.setString(7,image);

            stmt.executeUpdate();

        }catch (Exception ex){
            System.out.println("Error:" + ex.getMessage());
        }
    }

    @Override
    public Item select(int itemId) throws SQLException {
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT * FROM item WHERE itemID = ?");
            stmt.setInt(1, itemId);
            rs = stmt.executeQuery();

            if (rs.next()) {
                item = new Item(
                        (long) rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getDate(7),
                        rs.getDate(8),
                        rs.getString(9)
                );
                return item;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return item;
    }

    @Override
    public void update(Item item) throws SQLException {
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("UPDATE item SET itemName=?, Price=?, description=?, addressID=?, bidEnd=?, image=? WHERE itemID=?;");
            stmt.setString(1, item.getItemName());
            stmt.setDouble(2, item.getPrice());
            stmt.setString(3, item.getDescription());
            stmt.setInt(4, item.getAddressID());
            stmt.setDate(5, item.getBidEnd());
            stmt.setString(6, item.getImage());
            stmt.setInt(7, Math.toIntExact(item.getId()));

            stmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int itemID) throws SQLException {
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("DELETE FROM item WHERE itemID=?;");
            stmt.setInt(1, itemID);
            stmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}