package com.example.bidit.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
public class Bid {

    @Id
    private int id;
    private int userID;
    private int itemID;
    private double amount;
    private Date bidcastTime;

    public Bid() {
    }

    public Bid(int id, int userID, int itemID, double amount, Date bidcastTime) {
        this.id = id;
        this.userID = userID;
        this.itemID = itemID;
        this.amount = amount;
        this.bidcastTime = bidcastTime;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getBidcastTime() {
        return bidcastTime;
    }

    public void setBidcastTime(Date bidcastTime) {
        this.bidcastTime = bidcastTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
