package com.example.bidit.Database;

import com.example.bidit.DAO.addressDAO;
import com.example.bidit.Model.Address;

import java.sql.SQLException;

public class addressDatabase implements addressDAO {
    @Override
    public int insert(Address address) throws SQLException {
        return 0;
    }

    @Override
    public int update(int addressID) throws SQLException {
        return 0;
    }

    @Override
    public int delete(int addressID) throws SQLException {
        return 0;
    }

    @Override
    public Address select(String userName, String Password) throws SQLException {
        return null;
    }

    @Override
    public Address insert(String userName, String email, String password) throws SQLException {
        return null;
    }
}
