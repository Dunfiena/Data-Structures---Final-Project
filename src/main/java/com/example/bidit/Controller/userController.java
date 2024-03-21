package com.example.bidit.Controller;

import com.example.bidit.DAO.userDAO;
import com.example.bidit.Model.User;

import java.sql.*;
import java.util.ArrayList;

import static com.example.bidit.Controller.DataConnection.getConnection;

public class userController implements userDAO {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    User user = new User();
    ArrayList<User> userArrayList;

    @Override
    public void insert(String userName, String fname, String lname, String dob, String phone, String email, int bankId, int addressId, String password) throws SQLException {
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("INSERT INTO user(username, FirstName, LastName, dateOfBirth, phone, email, bankingID, addressID, password) VALUES (?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, userName);
            stmt.setString(2, fname);
            stmt.setString(3, lname);
            stmt.setString(4, dob);
            stmt.setString(5, phone);
            stmt.setString(6, email);
            stmt.setInt(7, bankId);
            stmt.setInt(8, addressId);
            stmt.setString(9, password);

            stmt.executeUpdate();

        } catch (Exception ex) {
            System.out.println("Error:" + ex.getMessage());
        }
    }

    @Override
    public User select(String userName, String Password) throws SQLException {
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT * FROM user WHERE username = ? AND password = ?");
            stmt.setString(1, userName);
            stmt.setString(2, Password);
            rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getString(10)

                );
                return user;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public User select(int userID) throws SQLException {
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT * FROM user WHERE userID=?");
            stmt.setInt(1, userID);
            rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getString(10)

                );
                return user;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public void update(User user) throws SQLException {
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("UPDATE user SET username=?, FirstName=?, LastName=?, dateOfBirth=?, Phone=?, Email=?, password=? WHERE userID=?;");
            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getFirstName());
            stmt.setString(3, user.getLastName());
            stmt.setDate(4, (Date) user.getDateOfBirth());
            stmt.setString(5, user.getPhone());
            stmt.setString(6, user.getEmail());
            stmt.setString(7, user.getPassword());

            stmt.setInt(8, Math.toIntExact(user.getId()));

            stmt.executeUpdate();
        }catch (Exception ex) {
            System.out.println("Error:" + ex.getMessage());
        }
    }

    @Override
    public void delete(int userID) throws SQLException {
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("DELETE FROM user WHERE userID=?;");
            stmt.setInt(1, userID);
            stmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
