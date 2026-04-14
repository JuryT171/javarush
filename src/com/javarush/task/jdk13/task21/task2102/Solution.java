package com.javarush.task.jdk13.task21.task2102;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/

public class Solution {
    private final String first;
    private final String last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (this == o) {  //  если один и тот же обьект то они равны
            return true;
        }
        if (!(o instanceof Solution)) {  //  проверка на соответвие класса
            return false;
        }
        Solution n = (Solution) o;  //  приведение типа
        return Objects.equals(first, n.first) && Objects.equals(last, n.last);  // сравниваем объекты
    }

    @Override
    public int hashCode() {
        return Objects.hash(first,last);  //  используем метод hash для сравнивания хэшкода
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
