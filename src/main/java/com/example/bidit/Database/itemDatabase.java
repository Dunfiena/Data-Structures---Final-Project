package com.example.bidit.Database;

import com.example.bidit.DAO.itemDAO;
import com.example.bidit.Model.Item;

import java.sql.SQLException;

public class itemDatabase implements itemDAO {
    @Override
    public int insert(Item item) throws SQLException {
        return 0;
    }

    @Override
    public int update(int itemID) throws SQLException {
        return 0;
    }

    @Override
    public int delete(int itemID) throws SQLException {
        return 0;
    }

    @Override
    public Item select(String userName, String Password) throws SQLException {
        return null;
    }

    @Override
    public Item insert(String userName, String email, String password) throws SQLException {
        return null;
    }
}
