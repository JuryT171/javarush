package com.javarush.task.jdk13.task28.task2808;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* 
Мне допеть не успеть
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        List<FutureTask<String>> taskList = new ArrayList<>();
        List<String> instruments = List.of("скрипка", "тромбон", "бубенцы", "контрабас");
        for (String instrument : instruments) {
            taskList.add(startPlaying(instrument));
        }

        System.out.println("Успели доиграть: " + completeConcert(taskList));
    }

    public static FutureTask<String> startPlaying(String name) {
        FutureTask<String> task = new FutureTask<>(new MusicalInstrument(name));
        new Thread(task).start();
        return task;
    }

    public static List<String> completeConcert(List<FutureTask<String>> taskList) {
        //напишите тут ваш код
        List<String> finishedInstruments = new ArrayList<>(); // создаем список
        for (FutureTask<String>task : taskList){ // проходимся циклом
            try {
                String result = task.get(800, TimeUnit.MILLISECONDS); // ждём результат 800 миллисекунд
                finishedInstruments.add(result); // если успешно получили результат - добавляем в список
            } catch (TimeoutException e) {
                task.cancel(true); // прерываем задачу,которая не успела
                System.out.println("Не успел доиграть инструмент: задача прервана");
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        return finishedInstruments;
    }
}