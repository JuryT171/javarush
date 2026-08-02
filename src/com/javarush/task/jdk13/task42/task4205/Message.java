package com.javarush.task.jdk13.task42.task4205;

import java.util.concurrent.*;

public class Message implements Delayed {
    private Integer messageId;
    private String messageText;
    private long lifetime;
    private long endTime;

    public Message(Integer messageId, String messageText, long lifetime) {
        this.messageId = messageId;
        this.messageText = messageText;
        this.lifetime = lifetime;
        this.endTime = TimeUnit.NANOSECONDS.convert(lifetime, TimeUnit.MILLISECONDS) + System.nanoTime();
    }

    public Integer getMessageId() {
        return messageId;
    }

    public long getLifetime() {
        return lifetime;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(endTime - System.nanoTime(),TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        long d = getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS);
        return (d == 0) ? 0 : ((d > 0) ? 1 : -1);
    }
}
