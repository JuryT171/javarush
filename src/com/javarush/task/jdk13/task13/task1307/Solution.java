package com.javarush.task.jdk13.task13.task1307;

/* 
Dog, Cat и Mouse
*/

public class Solution {
    public static void main(String[] args) {

    }

    //может двигаться
    public interface Movable {
        void move();
    }

    //может быть съеден
    public interface Edible {
        void beEaten();
    }

    //может кого-нибудь съесть
    public interface Eat {
        void eat();
    }
    public class Cat implements Movable,Eat,Edible{

        @Override
        public void eat() {

        }

        @Override
        public void beEaten() {

        }

        @Override
        public void move() {

        }
    }
    public class Mouse implements Movable,Edible{

        @Override
        public void beEaten() {

        }

        @Override
        public void move() {

        }
    }
    public class Dog implements Movable,Eat {



        @Override
        public void move() {

        }

        @Override
        public void eat() {

        }
    }
}