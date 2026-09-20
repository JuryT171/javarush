package com.javarush.task.sql.task15.task1502;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("1") // при сохранении в колонку person_type попадёт 1
public class Client extends Person {
    private String bank;

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }
}