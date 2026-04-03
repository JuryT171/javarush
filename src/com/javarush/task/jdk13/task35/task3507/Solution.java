package com.javarush.task.jdk13.task35.task3507;

import java.util.*;

/* 
Collections & Generics
*/

public class Solution {

    public static void main(String[] args) {
    }

    public static <T>ArrayList <T>newArrayList(T... elements) {  //  параметризуем типом Т
        //напишите тут ваш код
        ArrayList<T> list = new ArrayList<>();  //новый лист
        Collections.addAll(list, elements);  // добавляем все элементы
        return list;
    }

    public static <T>HashSet <T> newHashSet(T... elements) {  //параметризуем хэшсет Т
        //напишите тут ваш код
        HashSet<T> set = new HashSet<>();  // создаем новый
        Collections.addAll(set, elements);  //заполняем
        return set;
    }

    public static <K,V>HashMap <K,V>newHashMap(List<? extends K> keys,List<? extends V> values) {
        //параметризуем ключи и значения, с наследниками
        if (keys.size() != values.size()) {  //проверяем на равное колличество ключей и значений
            throw new IllegalArgumentException();
        }

        HashMap<K, V> map = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            map.put(keys.get(i), values.get(i));  // заполняем мапу
        }
        return map;
    }
}
