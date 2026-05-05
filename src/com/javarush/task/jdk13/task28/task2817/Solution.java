package com.javarush.task.jdk13.task28.task2817;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* 
Полусекундомер
*/

public class Solution implements Runnable{

    public static ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(3);

    @Override
    public void run() {
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime); // вывод на экран времени
    }

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        scheduledPool.scheduleAtFixedRate(new Solution(),0,500,TimeUnit.MILLISECONDS); // периодичность

        Thread.sleep(3000); // мэйн засыпает на 3 сек
        scheduledPool.shutdown(); // завершаем
    }
}
