package com.javarush.task.sql.task15.task1501;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
public class Client extends Person{
    private String bank;

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }
}
