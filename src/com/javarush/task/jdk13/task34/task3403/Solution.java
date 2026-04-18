package com.javarush.task.jdk13.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recurse(132);
    }

    public void recurse(int n) {
        if (n <= 1) { // условие выхода из рекурсии
            return;
        }
        for (int i = 2; i <= n; i++) { // перебираем все делители
            if (n % i == 0) {  // если делится без остатка,значит это простой множитель
                System.out.print(i + " "); // выводим на экран
                recurse(n / i); //вызываем метод снова
                break;
            }
        }
    }
}
