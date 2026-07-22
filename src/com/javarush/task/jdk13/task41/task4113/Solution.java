package com.javarush.task.jdk13.task41.task4113;

import java.util.*;
import java.util.concurrent.*;

/* 
Тотальная итерация
*/

public class Solution {

    public static void main(String[] args) {
        getIterators().stream()
                .map(i -> i.getClass().getCanonicalName())
                .sorted()
                .forEach(System.out::println);
    }

    public static List<Iterator> getIterators() {
        //напишите тут ваш код
        List<Iterator> iterators = new ArrayList<>();

        iterators.add(new ArrayList<>().iterator());
        iterators.add(new HashSet<>().iterator());
        iterators.add(new TreeSet<>().iterator());
        iterators.add(new LinkedList<>().iterator());
        iterators.add(new PriorityQueue<>().iterator());
        iterators.add(new Vector<>().iterator());
        iterators.add(new Stack<>().iterator());
        iterators.add(new ArrayDeque<>().iterator());


        iterators.add(new HashMap<>().keySet().iterator());
        iterators.add(new TreeMap<>().keySet().iterator());
        iterators.add(new LinkedHashMap<>().keySet().iterator());
        iterators.add(new Hashtable<>().keySet().iterator());
        iterators.add(new Properties().keySet().iterator());
        iterators.add(new WeakHashMap<>().keySet().iterator());
        iterators.add(new IdentityHashMap<>().keySet().iterator());


        iterators.add(EnumSet.noneOf(Thread.State.class).iterator());
        iterators.add(new EnumMap<>(Thread.State.class).keySet().iterator());


        iterators.add(new LinkedBlockingQueue<>().iterator());
        iterators.add(new DelayQueue<>().iterator());
        iterators.add(new ConcurrentHashMap<>().keySet().iterator());
        iterators.add(new CopyOnWriteArrayList<>().iterator());
        iterators.add(new CopyOnWriteArraySet<>().iterator());
        iterators.add(new ConcurrentSkipListSet<>().iterator());
        iterators.add(new ConcurrentSkipListMap<>().keySet().iterator());
        iterators.add(new ArrayBlockingQueue<>(1).iterator());
        iterators.add(new PriorityBlockingQueue<>().iterator());

        return iterators;
    }
}
