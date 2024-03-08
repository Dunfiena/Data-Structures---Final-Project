package com.example.bidit.DAO;

import com.example.bidit.Model.Bid;

import java.sql.SQLException;

public interface bidDAO {
    public void insert (int UserID, int itemID, double amount) throws SQLException;
    public void update (Bid bid) throws SQLException;
    public void delete (int bidID) throws SQLException;
    public Bid select (int bidId) throws SQLException;
}
