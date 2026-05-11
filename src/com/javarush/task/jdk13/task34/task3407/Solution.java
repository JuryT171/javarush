package com.javarush.task.jdk13.task34.task3407;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;

/* 
Собиратель типов
*/

public class Solution {

    private Map<TimeUnit, BiFunction<Integer, Long, Map<Boolean, List<String>>>> field;

    public static void main(String[] args) throws Exception {
        getTypes(Solution.class.getDeclaredField("field").getGenericType()).forEach(System.out::println);
    }

    public static Set<Type> getTypes(Type type) {
        //напишите тут ваш код
        Set<Type> result = new HashSet<>(); // сет типов


        if (!(type instanceof ParameterizedType)) { // если тип не параметризированный
            result.add(type); // добавляем простой тип
        }else {
            ParameterizedType paramType = (ParameterizedType) type;
            result.add(paramType.getRawType()); // добавляем сырой тип типо interface java.util.Map

            for (Type argument : paramType.getActualTypeArguments()) { // проходимся циклом
                result.addAll(getTypes(argument)); // добавляем
            }
        }
        return result;
    }
}
