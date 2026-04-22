package com.javarush.task.jdk13.task16.task1624;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int numSeconds = 3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        //add your code here - добавь код тут

        Thread.sleep(3500);
        clock.interrupt();

    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            //add your code here - добавь код тут
            try {
                while (numSeconds>0) { //  пока больше 0,цикл работает
                    System.out.print(numSeconds); // выводим цифры
                    if (numSeconds>1){ // добавляем пробел
                        System.out.print(" ");
                    }
                    Thread.sleep(1000); // ждем 1 сек
                    numSeconds--; // уменьшаем счетчик
                }
                System.out.println(" Марш!");
            } catch (InterruptedException e) {
                System.out.println(" Прервано!");
            }
        }
    }
}
