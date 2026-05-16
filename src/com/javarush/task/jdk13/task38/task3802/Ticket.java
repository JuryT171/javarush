package com.javarush.task.jdk13.task38.task3802;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // возможность помечать классы
@Retention(RetentionPolicy.RUNTIME) // доступна во время исполнения программы
public @interface Ticket {
    Priority priority () default Priority.MEDIUM; // приоритет по умолчанию
    String [] tags() default {}; //массив пустой
    String createdBy() default "Amigo"; // свйоство по умолчанию
    enum Priority{  // енум приоритетов
        LOW,MEDIUM,HIGH;
    }
}
