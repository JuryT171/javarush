package com.javarush.task.pro.task18.task1819;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/* 
Как быть, если в списке есть элемент null
*/

public class Solution {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, "first", "second", null, "fourth", "fifth");

        printList(strings);
    }

    public static void printList(List<String> list) {
        String text = "Этот элемент равен null";
        //напишите тут ваш код
        list.stream()  // создаем поток строк
                .map(x -> Optional.ofNullable(x).orElse(text))  // преобразуем строку в объект, проверяем на нулл, иначе подставляем текст
                .forEach(System.out::println);  //  выводим каждый элемент
    }
}
