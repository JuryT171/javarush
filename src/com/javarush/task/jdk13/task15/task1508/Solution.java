package com.javarush.task.jdk13.task15.task1508;

import java.util.HashMap;
import java.util.Map;

/* 
Статики
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<>();
    static {
        labels.put(1.0, "one");
        labels.put(2.0, "two");
        labels.put(3.0, "three");
        labels.put(4.0, "four");
        labels.put(5.0, "five");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
