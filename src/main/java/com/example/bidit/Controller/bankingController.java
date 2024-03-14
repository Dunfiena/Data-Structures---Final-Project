package com.example.bidit.Controller;

import com.example.bidit.DAO.bankingDAO;
import com.example.bidit.Model.Banking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.example.bidit.Controller.DataConnection.getConnection;

public class bankingController implements bankingDAO {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    Banking banking = new Banking();

    @Override
    public Banking insert(int account_num, int branch_num, int transit_num) throws SQLException {
        try{
            conn = getConnection();
            stmt = conn.prepareStatement("INSERT INTO banking(account_num, branch_num, transit_num) VALUES (?,?,?)");
            stmt.setInt(1, account_num);
            stmt.setInt(2, branch_num);
            stmt.setInt(3, transit_num);

            stmt.executeUpdate();
            stmt = conn.prepareStatement("SELECT * FROM banking where account_num=?");
            stmt.setInt(1,account_num);
            stmt.executeQuery();

            banking = select(account_num, branch_num, transit_num);
                return banking;

        }catch (Exception ex){
            System.out.println("Error:" + ex.getMessage());
        }
        return banking;
    }

    @Override
    public Banking select(int account, int transit, int branch) throws SQLException {
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT * FROM banking WHERE account_num=? and transit_num=? and branch_num=?");
            stmt.setInt(1, account);
            stmt.setInt(1, transit);
            stmt.setInt(1, branch);

            rs = stmt.executeQuery();

            if (rs.next()) {
                banking = new Banking(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4)
                );
                return banking;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return banking;
    }

    @Override
    public Banking select(int bankId) throws SQLException {
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT * FROM banking WHERE bankID = ?");
            stmt.setInt(1, bankId);
            rs = stmt.executeQuery();

            if (rs.next()) {
                banking = new Banking(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4)
                );
                return banking;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return banking;
    }

    @Override
    public void update(Banking bank) throws SQLException {
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("UPDATE banking SET account_num=?, branch_num=?, transit_num=? WHERE bankID=?;");
            stmt.setInt(1, bank.getAccount());
            stmt.setInt(2, bank.getBranch());
            stmt.setInt(3, bank.getTransit());
            stmt.setInt(4, Math.toIntExact(bank.getId()));

            stmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

        @Override
    public void delete(int bankID) throws SQLException {
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("DELETE FROM banking WHERE bankID=?;");
            stmt.setInt(1, bankID);
            stmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
