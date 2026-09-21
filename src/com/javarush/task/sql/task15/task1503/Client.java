package com.javarush.task.sql.task15.task1503;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
// колонка person_id в дочерней таблице — это одновременно PK и FK на person.id
@PrimaryKeyJoinColumn(name = "person_id")
public class Client extends Person {
    private String bank;

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }
}
