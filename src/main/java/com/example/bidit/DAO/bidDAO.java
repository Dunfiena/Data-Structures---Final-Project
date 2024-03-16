package com.example.bidit.DAO;

import com.example.bidit.Model.Bid;

import java.sql.SQLException;
import java.util.ArrayList;

public interface bidDAO {
    public void insert (int UserID, int itemID, double amount) throws SQLException;

    ArrayList<Bid> selectAll(int userID) throws SQLException;

    public void update (Bid bid) throws SQLException;
    public void delete (int bidID) throws SQLException;

    Bid select(int bidID) throws SQLException;
}
