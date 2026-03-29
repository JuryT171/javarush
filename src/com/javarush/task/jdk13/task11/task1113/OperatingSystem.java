package com.javarush.task.jdk13.task11.task1113;

public class OperatingSystem {
    private final String name;
    private String version;

    public OperatingSystem(String name, String version) {
        //напишите тут ваш код
        this.name = name;
        this.version = version;

    }

    public String getName() {  //  геттер
        return name;
    }

    public String getVersion() {  //  геттер
        return version;
    }

    public void setVersion(String version) {  //  сеттер
        this.version = version;
    }
}
