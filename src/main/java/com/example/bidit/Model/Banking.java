package com.example.bidit.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Banking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private int account;
    private int branch;
    private int transit;

    public Banking() {
    }

    public Banking(Long id, int account, int branch, int transit) {
        this.id = id;
        this.account = account;
        this.branch = branch;
        this.transit = transit;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public int getBranch() {
        return branch;
    }

    public void setBranch(int branch) {
        this.branch = branch;
    }

    public int getTransit() {
        return transit;
    }

    public void setTransit(int transit) {
        this.transit = transit;
    }
}
