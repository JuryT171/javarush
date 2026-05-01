package com.javarush.task.jdk13.task28.task2804;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread{
    // счетчики
    private static final AtomicInteger priorityCounter = new AtomicInteger(Thread.MIN_PRIORITY);
    private static final Object lock = new Object();

    public MyThread() {
        setPriority(getNextPriority());
    }

    public MyThread(Runnable task) {  // конструктор runnable
        super(task);
        setPriority(getNextPriority());
    }

    public MyThread(ThreadGroup group, Runnable task) { // конструктор с ThreadGroup и Runnable
        super(group, task);
        setPriority(getNextPriority());
        limitPriorityByGroup();
    }

    public MyThread(String name) { // конструктор с именем
        super(name);
        setPriority(getNextPriority());
    }

    public MyThread(ThreadGroup group, String name) { // конструктор с трэдгрупп и именем
        super(group, name);
        setPriority(getNextPriority());
        limitPriorityByGroup();
    }

    public MyThread(Runnable task, String name) {  // конструктор runnable с именем
        super(task, name);
        setPriority(getNextPriority());
    }

    public MyThread(ThreadGroup group, Runnable task, String name) { //  трэдгру, раннабл и имя
        super(group, task, name);
        setPriority(getNextPriority());
        limitPriorityByGroup();
    }

    public MyThread(ThreadGroup group, Runnable task, String name, long stackSize) {
        super(group, task, name, stackSize);
        setPriority(getNextPriority());
        limitPriorityByGroup();
    }

    public MyThread(ThreadGroup group, Runnable task, String name, long stackSize, boolean inheritInheritableThreadLocals) {
        super(group, task, name, stackSize, inheritInheritableThreadLocals);
        setPriority(getNextPriority());
        limitPriorityByGroup();
    }

    // получение следующего приоритета по циклу
    private static int getNextPriority() {
        synchronized (lock) {
            int current = priorityCounter.get(); // берем текущее значение
            int next = current + 1; // вычисляем последующее
            if (next > Thread.MAX_PRIORITY) { // если дошли до максимума,сбрасываем на минимум
                next = Thread.MIN_PRIORITY;
            }
            priorityCounter.set(next);  // сохраняем значение  в счетчик
            return current; // возвращаем
        }
    }

    // ограничение приоритета максимальным приоритетом группы
    private void limitPriorityByGroup() {
        ThreadGroup group = getThreadGroup();  // получаем группу
        if (group != null) {  // если группа не пустая
            int currentPriority = getPriority();  //текущий приоритет потока
            int maxGroupPriority = group.getMaxPriority(); // получаем макс приоритет группы
            if (currentPriority > maxGroupPriority) { //если текущий больше максимального
                setPriority(maxGroupPriority); // понижаем до максимального группы
            }
        }
    }
}
