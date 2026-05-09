package com.javarush.task.jdk13.task20.task2011;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Shop {  // создали класс с пустыми полями
    public Goods goods = new Goods();
    public int count;
    public double profit;
    public List<String> secretData;

    static class Goods{  // вложенный статический класс
        public List<String>names;
    }

    @Override
    public String toString() {  // переопределили вывод
        return "Shop{" +
                "goods=" + goods +
                ", count=" + count +
                ", profit=" + profit +
                ", secretData=" + (secretData == null ? null : Arrays.asList(secretData)) +
                '}';
    }
}
