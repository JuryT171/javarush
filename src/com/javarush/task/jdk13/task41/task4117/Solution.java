package com.javarush.task.jdk13.task41.task4117;

/* 
Приветики в этом чате
*/

public class Solution {
    public static void main(String[] args) {
        Mediator mediator = new Chat(new UserDB());
        User user1 = new User(mediator,1, "Леша");
        User user2 = new User(mediator,2, "Боря");
        User user3 = new User(mediator,3, "Чингиз");
        User user4 = new User(mediator,4, "David");

        mediator.register(user1);
        mediator.register(user2);
        mediator.register(user3);
        mediator.register(user4);

        user1.send("Добрый день, Борис Алексеевич", 2);
        user2.send("Приветствую! Алексей Борисович", 1);
    }
}
