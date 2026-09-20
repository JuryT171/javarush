package com.javarush.task.sql.task15.task1502;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("2")
public class Employee extends Person {
    private String company;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
