package com.javarush.task.jdk13.task16.task1623;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем секунды
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        //create and run thread
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        //read a string
        reader.readLine();
        stopwatch.interrupt();
        //close streams
        reader.close();
        in.close();
    }

    public static class Stopwatch extends Thread {
        private int seconds;

        public void run() {
            try { // Thread.currentThread() — возвращает объект того потока,
                // в котором этот метод выполняется.stopwatch.
                Thread currentThread = Thread.currentThread();  // текущий поток
                while (!currentThread.isInterrupted()){  // пока условие неистино
                Thread.sleep(1000);
                seconds++; } // прибавляем секунды
                //напишите тут ваш код
            } catch (InterruptedException e) {
                System.out.println(seconds);
            }
        }
    }
}
