package com.example.bidit.Database;

import com.example.bidit.DAO.bidDAO;
import com.example.bidit.Model.Bid;

import java.sql.SQLException;

public class bidDatabase implements bidDAO {
    @Override
    public int insert(Bid bid) throws SQLException {
        return 0;
    }

    @Override
    public int update(int bidID) throws SQLException {
        return 0;
    }

    @Override
    public int delete(int bidID) throws SQLException {
        return 0;
    }

    @Override
    public Bid select(String userName, String Password) throws SQLException {
        return null;
    }

    @Override
    public Bid insert(String userName, String email, String password) throws SQLException {
        return null;
    }
}
