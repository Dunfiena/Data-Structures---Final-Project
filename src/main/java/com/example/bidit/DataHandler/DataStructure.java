package com.example.bidit.DataHandler;

import java.sql.Date;

public class DataStructure {
    private int userId;
    private int bidAmount;
    private Date time;

    public DataStructure() {}

    public DataStructure(int userId, int bidAmount,Date time) {
        this.userId = userId;
        this.bidAmount = bidAmount;
        this.time = time;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(int bidAmount) {
        this.bidAmount = bidAmount;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}

