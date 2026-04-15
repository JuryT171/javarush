package com.javarush.task.jdk13.task21.task2103;

import java.util.Date;
import java.util.Objects;

/* 
Ошибка в equals/hashCode
*/

public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {  //  проверка на тот же объект
            return true;
        }
        if (!(o instanceof Solution)) {  //  проверка на принадлежность класса
            return false;
        }

        Solution solution1 = (Solution) o;  // приведение объекта

        if (Double.compare(solution1.aDouble, aDouble) != 0) {  //  проверка дабл с помощью метода compare
            return false;
        }
        if (anInt != solution1.anInt) {  //  проверка
            return false;
        }  // сравниваем все объекты
        if (!Objects.equals(string, solution1.string)) return false;
        if (!Objects.equals(date, solution1.date)) return false;
        if (!Objects.equals(solution, solution1.solution)) return false;
        return true;
    }

    @Override
    public int hashCode() {

        return Objects.hash(anInt, string, aDouble, date, solution);
    }

    public static void main(String[] args) {

    }
}
