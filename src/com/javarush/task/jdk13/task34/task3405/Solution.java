package com.javarush.task.jdk13.task34.task3405;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Нарушение приватности
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        User user = new User("Amigo", 21);
        print(getFields(user));

        Task task = new Task("task3405", true);
        print(getFields(task));
    }

    public static Map<String, Object> getFields(Object object) throws Exception {
        //напишите тут ваш код
        HashMap<String,Object> fieldMap = new HashMap<>(); // создаем мапу для результата

        Class<?> clazz = object.getClass(); // Получаем класс объекта
        Field[] fields = clazz.getDeclaredFields(); // получаем поля
        for (Field field : fields){ // проходимся по всем полям
            if(Modifier.isPrivate(field.getModifiers())){ //если поле приватное
                field.setAccessible(true); // делаем поле доступным
                String fieldName = field.getName(); // получаем имя
                Object fieldValue = field.get(object); // получаем значение обьекта

                fieldMap.put(fieldName,fieldValue); // добавляем в мапу
            }
        }
        return fieldMap; // возвращаем
    }

    public static void print(Map<?, ?> fields) {
        System.out.println("-------------------");
        fields.forEach((fieldName, fieldValue) -> System.out.println(fieldName + " = " + fieldValue));
    }
}
