package com.example.bidit.DAO;

import com.example.bidit.Model.Bid;

import java.sql.SQLException;

public interface bidDAO {
    public int insert (Bid bid) throws SQLException;
    public int update (int bidID) throws SQLException;
    public int delete (int bidID) throws SQLException;
    public Bid select (String userName, String Password) throws SQLException;
    public Bid insert (String userName, String email, String password) throws SQLException;
}
