package com.example.bidit.DAO;

import com.example.bidit.Model.Item;

import java.sql.SQLException;

public interface itemDAO {
    public int insert (Item item) throws SQLException;
    public int update (int itemID) throws SQLException;
    public int delete (int itemID) throws SQLException;
    public Item select (String userName, String Password) throws SQLException;
    public Item insert (String userName, String email, String password) throws SQLException;
}
