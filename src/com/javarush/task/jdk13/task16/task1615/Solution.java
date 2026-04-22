package com.javarush.task.jdk13.task16.task1615;

import java.util.Date;

/* 
Поговорим о музыке?
*/

public class Solution {
    public static int delay = 1000;

    public static void main(String[] args) {
        Thread violin = new Thread(new Violin("Player"));
        violin.start();
    }

    public static void sleepNSeconds(int n) {
        try {
            Thread.sleep(n * delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public interface MusicalInstrument extends Runnable {
        Date startPlaying();

        Date stopPlaying();
    }

    public static class Violin implements MusicalInstrument {
        private String owner;
        private Date startTime; // Для хранения времени начала игры
        private Date endTime;   // Для хранения времени окончания игры


        public Violin(String owner) {
            this.owner = owner;
        }

        public Date startPlaying() {
            System.out.println(this.owner + " is starting to play");
            return new Date();
        }

        public Date stopPlaying() {
            System.out.println(this.owner + " is stopping playing");
            return new Date();
        }

        @Override
        public void run() {
            this.startTime = startPlaying(); // переменная для хранения времени начала игры
            sleepNSeconds(1); // время ожидания 1 сек
            this.endTime = stopPlaying(); // переменная для хранения окончания игры
            long timePlay = endTime.getTime()- startTime.getTime(); // вычисляем время
            System.out.println("Playing "+timePlay+" ms"); // выводим на экран

        }
    }
}
