package com.javarush.task.jdk13.task28.task2806;

import java.util.*;
import java.util.concurrent.FutureTask;

/* 
Параллельный парсинг
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        List<String> lines = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            lines.add(scanner.nextLine());
        }

        List<FutureTask<Link>> tasks = new ArrayList<>(); // храним задачку для кааждого потока
        for (String line : lines) {
            ParseLinkTask parseLinkTask = new ParseLinkTask(line);  // создали задачку
            FutureTask<Link> futureTask = new FutureTask<>(parseLinkTask); // оборачиваем во future task
            new Thread(futureTask).start(); // стартуем
            tasks.add(futureTask); // добавляем.сохраняем
        }

        for (FutureTask<Link> task : tasks) {
            System.out.println(task.get());
        }
    }
}