package com.javarush.task.jdk13.task17.task1706;

public class OurPresident {
    private static OurPresident president;
    static {
        synchronized (OurPresident.class){ // синхронизием так как поле президент еще не объявлено
            president = new OurPresident();
        }
    }
    private OurPresident() {
    }

    public static OurPresident getOurPresident() {
        return president;
    }
}
