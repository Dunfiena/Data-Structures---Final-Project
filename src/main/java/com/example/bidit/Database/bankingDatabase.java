package com.example.bidit.Database;

import com.example.bidit.DAO.bankingDAO;
import com.example.bidit.Model.Banking;

import java.sql.SQLException;

public class bankingDatabase implements bankingDAO {
    @Override
    public int insert(Banking bank) throws SQLException {
        return 0;
    }

    @Override
    public int update(int bankID) throws SQLException {
        return 0;
    }

    @Override
    public int delete(int bankID) throws SQLException {
        return 0;
    }

    @Override
    public Banking select(String userName, String Password) throws SQLException {
        return null;
    }

    @Override
    public Banking insert(String userName, String email, String password) throws SQLException {
        return null;
    }
}
