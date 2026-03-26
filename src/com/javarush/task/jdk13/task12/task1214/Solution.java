package com.javarush.task.jdk13.task12.task1214;

/* 
Исправь код. Вторая задача
*/

public class Solution {
    public static void main(String[] args) {

    }

    public abstract static class Pet {
        public String getName() {
            return "Я - котенок";
        }

        public abstract Pet getChild();
    }

}
