package com.javarush.task.sql.task15.task1504;

import jakarta.persistence.Entity;

@Entity
public class Client extends Person{
    private String bank;

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }
}
