package com.example.bidit.Database;

import com.example.bidit.DAO.userDAO;
import com.example.bidit.Model.User;

import java.sql.SQLException;

public class userDatabase implements userDAO {
    @Override
    public int insert(User user) throws SQLException {
        return 0;
    }

    @Override
    public int update(int userID) throws SQLException {
        return 0;
    }

    @Override
    public int delete(int userID) throws SQLException {
        return 0;
    }

    @Override
    public User select(String userName, String Password) throws SQLException {
        return null;
    }

    @Override
    public User insert(String userName, String email, String password) throws SQLException {
        return null;
    }
}
