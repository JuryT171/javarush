package com.javarush.task.jdk13.task11.task1115;

import java.util.ArrayList;
import java.util.List;

/* 
Агрегация 2
*/

public class Market {
    private final String name;
    private List<Product> products;  //  переменная лист продукты


    public Market(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {  //  вохвращаем продукты
        return products;
    }

    public void setProducts(List<Product> products) {  //сеттер
    this.products=products;
    }
}
