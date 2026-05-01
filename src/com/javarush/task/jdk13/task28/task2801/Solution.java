package com.javarush.task.jdk13.task28.task2801;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/

public class Solution {

    public static void main(String[] args) {
        class EmulatorThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulatorThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulatorThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }

    public static class AmigoThreadFactory implements ThreadFactory{
        private static final AtomicInteger factoryCounter = new AtomicInteger(1); // номер фабрики
        private final AtomicInteger threadCounter = new AtomicInteger(1); // счетчик для потока в фабрики
        private final String groupName;// имя группы в которой создана фабрика
        private final int factoryNumber; // номер фабрики

        public AmigoThreadFactory() {
            ThreadGroup currentGroup = Thread.currentThread().getThreadGroup(); // текущая группа в которой соз-ся фабрика
            this.groupName = currentGroup.getName();
            // Получаем уникальный номер для этой фабрики
            this.factoryNumber = factoryCounter.getAndIncrement(); // получаем номер
        }

        @Override
        public Thread newThread(Runnable r) {
            String threadName = String.format("%s-pool-%d-thread-%d",
                    groupName, factoryNumber, threadCounter.getAndIncrement()); //  имя по шпблону

            Thread thread = new Thread(Thread.currentThread().getThreadGroup(), r, threadName);
            // создаем новый поток с именем, группой и Runnable

            if (thread.isDaemon()) {
                thread.setDaemon(false); // не демон по условию
            }
            if (thread.getPriority() != Thread.NORM_PRIORITY) { // норм приоритет по условию
                thread.setPriority(Thread.NORM_PRIORITY);
            }
            return thread;
        }
    }
}
