package com.example.bidit.DAO;

import com.example.bidit.Model.Item;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public interface itemDAO {
    public void insert (int ownerID, String itemName, int Price, String description, String image) throws SQLException;

    ArrayList<Item> selectAll() throws SQLException;

    public void update (Item item) throws SQLException;
    public void delete (int itemID) throws SQLException;
    public Item select (int itemId) throws SQLException;
}
