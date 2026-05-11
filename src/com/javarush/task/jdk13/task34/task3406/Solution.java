package com.javarush.task.jdk13.task34.task3406;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

/* 
Классные методы
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        print(getMethods(Set.of(Object.class, Math.class, Arrays.class)));
    }

    public static Map<Class<?>, Set<String>> getMethods(Set<Class<?>> classes) {
        //напишите тут ваш код
        Map<Class<?>, Set<String>> result = new HashMap<>(); // создаем мапу для результата

        for(Class<?> clazz: classes){
            Set<String> methodNames = new HashSet<>(); //  создаем сет для хранения имен
            Method[] methods = clazz.getDeclaredMethods(); //  получаем все методы
            for (Method method : methods){ // проходимся циклом по методам
                if (Modifier.isStatic(method.getModifiers())) { // если метод статический
                    methodNames.add(method.getName());  // добавляем имя метода в множество
                }
            }
            result.put(clazz, methodNames); // добавляем пару класс\имена
        }
        return result;
    }

    public static void print(Map<?, ?> map) {
        map.forEach((key, value) -> System.out.println(key + " : " + value));
    }
}
