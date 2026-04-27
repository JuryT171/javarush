package com.javarush.task.jdk13.task27.task2706;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get() {
        while (!isValuePresent) {  // пока нет чисел
            try {
                wait();  // поток засыпает
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Got: " + value);  // получаем число
        isValuePresent=false;  // меняем флаг
        notifyAll();  // оповещаем другие потоки
        return value;
    }

    public synchronized void put(int value) {
        this.value = value;
        while (isValuePresent) { // ожидаем пока не вызовут гет
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        isValuePresent=true;
        notifyAll();
        System.out.println("Put: " + value);
    }
}
