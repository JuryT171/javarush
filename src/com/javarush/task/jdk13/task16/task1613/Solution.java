package com.javarush.task.jdk13.task16.task1613;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        //напишите тут ваш код
        for (int i = 0; i < 5; i++) { // цикл
            Thread thread = new Thread(new SpecialThread()); // создаем поток 5шт
            list.add(thread); // добавляем в лист
        }
        // ТОПОРНЫЙ ВАРИАНТ
        //list.add(new Thread(new SpecialThread()));
        //list.add(new Thread(new SpecialThread()));
        //list.add(new Thread(new SpecialThread()));
        //list.add(new Thread(new SpecialThread()));
        //list.add(new Thread(new SpecialThread()));

    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
