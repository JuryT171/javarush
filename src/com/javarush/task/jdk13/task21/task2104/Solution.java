package com.javarush.task.jdk13.task21.task2104;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* 
Глубокое клонирование карты
*/

public class Solution implements Cloneable {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        try {
            Solution clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    @Override
    protected Solution clone() throws CloneNotSupportedException {

        Solution clone = (Solution) super.clone(); // обычное клонирование
        clone.users = new LinkedHashMap<>();   // создаём новую мапу

        for (Map.Entry<String, User> entry : this.users.entrySet()) {   // клонируем каждого пользователя и добавляем в новую мапу
            User clonedUser = entry.getValue().clone(); // клонируем пользователя
            clone.users.put(entry.getKey(), clonedUser); // добавляем в новую мапу с тем же ключом
        }
        return clone;
    }
    @Override
    public int hashCode() {
        return users.hashCode();
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        protected User clone() throws CloneNotSupportedException {
            return (User) super.clone();  //  обычное клонирование
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof User)) return false;
            User user = (User) o;
            return age == user.age && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(age, name);
        }
    }
}
