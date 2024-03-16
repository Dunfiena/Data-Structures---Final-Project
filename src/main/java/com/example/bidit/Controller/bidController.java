package com.example.bidit.Controller;

import com.example.bidit.DAO.bidDAO;
import com.example.bidit.Model.Bid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.example.bidit.Controller.DataConnection.getConnection;

public class bidController implements bidDAO {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    Bid bid = new Bid();
    ArrayList<Bid> bidArrayList;

    @Override
    public void insert(int UserID, int itemID, double amount) throws SQLException {
        try{
            conn = getConnection();
            stmt = conn.prepareStatement("INSERT INTO bid(UserID, itemID, amount) VALUES (?,?,?)");
            stmt.setInt(1, UserID);
            stmt.setInt(2, itemID);
            stmt.setDouble(3, amount);

            stmt.executeUpdate();

        }catch (Exception ex){
            System.out.println("Error:" + ex.getMessage());
        }    }

    @Override
    public Bid select(int bidId) throws SQLException {
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT * FROM bid WHERE bidID = ?");
            stmt.setInt(1, bidId);
            rs = stmt.executeQuery();

            if (rs.next()) {
                bid = new Bid(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getDate(5)
                );
                return bid;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return bid;
    }

    @Override
    public ArrayList<Bid> selectAll(int userID) throws SQLException {
        bidArrayList = new ArrayList<>();
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT * FROM bid WHERE UserID=?");
            stmt.setInt(1, userID);
            rs = stmt.executeQuery();

            while (rs.next()) {
                bid = new Bid(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getDate(5)
                );
                bidArrayList.add(bid);
           }
            return bidArrayList;

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Bid bid) throws SQLException {
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("UPDATE bid SET amount=? WHERE bidID=?;");
            stmt.setDouble(1, bid.getAmount());
            stmt.setInt(2, Math.toIntExact(bid.getId()));

            stmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int bidID) throws SQLException {
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("DELETE FROM bid WHERE bidID=?;");
            stmt.setInt(1, bidID);
            stmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
