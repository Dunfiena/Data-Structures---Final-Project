package com.example.bidit.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
public class Item {

    @Id
    private int id;
    private int ownerID;
    private String itemName;
    private int price;
    private String description;
    private Date bidStart ;
    private Date bidEnd;
    private String image;

    public Item() {
    }

    public Item(int id, int ownerID, String itemName, int price, String description,
                Date bidStart, Date bidEnd, String image) {
        this.id = id;
        this.ownerID = ownerID;
        this.itemName = itemName;
        this.price = price;
        this.description = description;
        this.bidStart = bidStart;
        this.bidEnd = bidEnd;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getBidStart() {
        return bidStart;
    }

    public void setBidStart(Date bidStart) {
        this.bidStart = bidStart;
    }

    public Date getBidEnd() {
        return bidEnd;
    }

    public void setBidEnd(Date bidEnd) {
        this.bidEnd = bidEnd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
