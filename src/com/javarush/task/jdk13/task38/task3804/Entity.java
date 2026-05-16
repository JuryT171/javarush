package com.javarush.task.jdk13.task38.task3804;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // возможность помечать классы
@Retention(RetentionPolicy.RUNTIME) // доступна во время исполнения программы
public @interface Entity { // имя аннтоации
    String name ();  // поле имя
    int value () default 45;  // поле валью со знаечением
    boolean required () default true;  // значение тру по умолчанию
}
