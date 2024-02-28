package com.example.bidit.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int ownerID;
    private String itemName;
    private double price;
    private String description;
    private int addressID;
    private Date bidStart ;
    private Date bidEnd;
    private String image;

    public Item() {
    }

    public Item(Long id, int ownerID, String itemName, double price, String description,
                int addressID, Date bidStart, Date bidEnd, String image) {
        this.id = id;
        this.ownerID = ownerID;
        this.itemName = itemName;
        this.price = price;
        this.description = description;
        this.addressID = addressID;
        this.bidStart = bidStart;
        this.bidEnd = bidEnd;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
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
