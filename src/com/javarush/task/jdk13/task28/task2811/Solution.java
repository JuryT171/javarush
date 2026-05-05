package com.javarush.task.jdk13.task28.task2811;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* 
Знакомство с Executors
*/

public class Solution implements  Runnable {
    private final int localID ; // счтчик

    public Solution(int localID) { // конструктор
        this.localID = localID;
    }
    @Override
    public void run() {
        // в методе run вызываем doExpensiveOperation
        doExpensiveOperation(localID); // переопределяем метод ран
    }

    public static void main(String[] args) throws InterruptedException {
        //напишите тут ваш код
        ExecutorService executorService = Executors.newFixedThreadPool(5); // создаем трэдпул на 5 потоков
        for (int i = 1; i <= 20; i++) { // цикл из 20 задач
            executorService.execute(new Solution(i)); // вызываем для каждой задачи поток
        }
        executorService.shutdown(); // завершаем прием задач
        executorService.awaitTermination(5,TimeUnit.SECONDS); // останавливаем майн на 5 сек
    }

    private static void doExpensiveOperation(int localID) {
        System.out.println(Thread.currentThread().getName() + ", localID=" + localID);
    }
}
