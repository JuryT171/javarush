package com.javarush.task.jdk13.task21.task2101;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Equals and HashCode
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
        if (!(o instanceof Solution)) {  // является ли обьект класса солюшн
            return false;
        }

        Solution solution = (Solution) o;  //  приведение типа к классу солюшн

        if (!Objects.equals(first, solution.first)) {  //  если обьекты не равны - фалс
            return false;
        }
        return Objects.equals(last, solution.last);  //  теперь проверяем второй обьект

    }

    public int hashCode() {
       // return 31 * first.hashCode() + last.hashCode();
        int result = first != null ? first.hashCode() : 0;  // если первый null - 0, если нет то берем хэшков
        result = 31 * result + (last != null ? last.hashCode() : 0);  //  *31 для улучшения, если null - 0, если нет то хэшкод
        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
