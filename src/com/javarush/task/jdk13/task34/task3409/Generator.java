package com.javarush.task.jdk13.task34.task3409;

import java.lang.reflect.Constructor;

public class Generator<T> {

    private Class<T> aClass;

    public Generator(Class<T> aClass) {
        this.aClass = aClass;
    }

    T newInstance() throws Exception {
        Constructor<T> constructor = (Constructor<T>) aClass.getDeclaredConstructors()[0]; // получаем конструктор
        return constructor.newInstance(new Object[constructor.getParameterCount()]);
        // создаем массив, получаем кол-во параметров у конструктора
    }
}
