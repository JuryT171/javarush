package com.javarush.task.jdk13.task16.task1626;

/* 
А без interrupt слабо?
*/

public class Solution {
    public static boolean isCancel = true;  // вводим флаг

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new TestThread());
        t.start();
        Thread.sleep(3000);
        ourInterruptMethod();
    }

    public static void ourInterruptMethod() {
        isCancel = false; // при вызове метода завершаем поток
    }

    public static class TestThread implements Runnable {
        public void run() {
            while (isCancel) {  // пока условие выполняется
                System.out.println("he-he");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}

