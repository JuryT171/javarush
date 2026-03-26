package com.javarush.task.jdk13.task12.task1216;

/* 
Классы Cat и Dog от Pet
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static abstract class Pet {
        public abstract String getName();

        public abstract Pet getChild();
    }

    public static class Cat extends Pet {
        @Override
        public String getName() {
            return "";
        }

        @Override
        public Pet getChild() {
            return null;
        }
    }

    public static class Dog extends Pet {
        @Override
        public String getName() {
            return "";
        }

        @Override
        public Pet getChild() {
            return null;
        }
    }

}
