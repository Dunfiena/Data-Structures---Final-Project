package com.example.bidit.DAO;

import com.example.bidit.Model.Banking;

import java.sql.SQLException;

public interface bankingDAO {
    public Banking insert (int account_num, int branch_num, int transit_num) throws SQLException;
    public void update (Banking bank) throws SQLException;
    public void delete (int bankID) throws SQLException;

    Banking select(int account, int transit, int branch) throws SQLException;

    public Banking select (int bankId) throws SQLException;
}
