package com.javarush.task.jdk13.task28.task2813;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* 
Кеширование нитей
*/

public class Solution {

    public static BlockingQueue<String> queue = new ArrayBlockingQueue<>(32);
    public static ExecutorService executorService;

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        executorService = Executors.newCachedThreadPool();

        submitProducers();
        submitConsumers();

        executorService.shutdownNow();
    }

    public static void submitProducers() {
        //напишите тут ваш код
        for (int i = 0; i < 100; i++) { // проходимся циклом 100 задач
            executorService.submit(new Producer("message "+i)); // даем сто задач
        }
    }

    public static void submitConsumers() {
        //напишите тут ваш код
        Consumer consumer = new Consumer();
        for (int i = 0; i < 100; i++) { // 100 задач
            executorService.submit(consumer);  // берем их
        }
    }
}
