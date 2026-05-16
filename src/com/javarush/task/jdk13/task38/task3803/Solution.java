package com.javarush.task.jdk13.task38.task3803;

/* 
Обработка аннотаций
*/

import java.lang.annotation.Annotation;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static <T> boolean printFullyQualifiedNames(Class<T> c) {
        if(c.isAnnotationPresent(PrepareMyTest.class)){ // проверяем есть ли аннотация
            PrepareMyTest prepareMyTest = c.getAnnotation(PrepareMyTest.class); //  получаем обьект,хранящий информацию
            String []result = prepareMyTest.fullyQualifiedNames(); // массив строк из аннотации
            for (String string : result){ // цикл
                System.out.println(Arrays.toString(result)); // выводим имя класса
            } return true; // аннотация найдена - тру
        } return false;  // если не найдена фалс
    }

    public static <T> boolean printValues(Class<T> c) {
        if(c.isAnnotationPresent(PrepareMyTest.class)){ // проверяем есть ли аннотация
            PrepareMyTest prepareMyTest = c.getAnnotation(PrepareMyTest.class); // получаем обьект класса аннотации
            Class<?> [] result = prepareMyTest.value(); // извлекаем из аннотации массив классов
            for(Class<?> clazz : result){  // цикл
                System.out.println(clazz.getSimpleName());  // вывод имени класса
            }
            return true;
        } return false;
    }
}
