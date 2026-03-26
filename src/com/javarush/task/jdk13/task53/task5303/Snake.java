package com.javarush.task.jdk13.task53.task5303;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private static final String HEAD_SIGN = "\uD83D\uDC06"; //  константа для хранения смайлика головы змеи
    private static final String BODY_SIGN = "\u26AB"; //  константа для смайлика самой змеи
    public boolean isAlive = true;
    private List<GameObject> snakeParts = new ArrayList<>(); //  создали аррайлист для хранения змейки
    private Direction direction = Direction.LEFT; //  поле с началом движения влево
//

    public Snake(int x, int y) {
        GameObject gameObjectFirst = new GameObject(x, y);  //  сконструировали с помощью параметров три обьекта
        GameObject gameObjectSecond = new GameObject(x + 1, y);
        GameObject gameObjectThird = new GameObject(x + 2, y);
        snakeParts.add(gameObjectFirst);  //  ддобавилии в аррайлист
        snakeParts.add(gameObjectSecond);
        snakeParts.add(gameObjectThird);
    }

    public void draw(Game game) {
        Color color = isAlive ? Color.BLACK : Color.RED; //  если змея живая - блэк, если нет - красная
        for (int i = 0; i < snakeParts.size(); i++) { //  проходимся циклом по аррайлисту
            GameObject part = snakeParts.get(i);  //  сохраняем каждый обьект
            String smile = (i != 0) ? BODY_SIGN : HEAD_SIGN; // тернарный оператор - если индекс не первый, то смайлик тела,если первый головы
            game.setCellValueEx(part.x, part.y, Color.NONE, smile, color, 75); //  закрашиваем змею

            /* String snake;  // переменная для смайлика
             if (i != 0) {  //  если индекс не ноль
                snake = BODY_SIGN;  //  голова
            } else {
                snake = HEAD_SIGN;  //  иначе тело
            }
            if(isAlive = true) {
                game.setCellValueEx(part.x, part.y, Color.NONE, snake, color, 75);  //  вызываем метод отображения
            } else {
                game.setCellValueEx(part.x, part.y, Color.NONE, snake, color, 75);
            } */
        }
    }

    public void setDirection(Direction direction) {  //  сеттер для движения змеи
        if ((this.direction == Direction.LEFT || this.direction == Direction.RIGHT) && snakeParts.get(0).x == snakeParts.get(1).x) {
            return;
        }
        if ((this.direction == Direction.UP || this.direction == Direction.DOWN) && snakeParts.get(0).y == snakeParts.get(1).y) {
            return;
        }


        if (direction == Direction.UP && this.direction==Direction.DOWN) {
            return;
        } else if (direction == Direction.DOWN && this.direction == Direction.UP) {
            return;
        } else if (direction == Direction.LEFT && this.direction == Direction.RIGHT) {
            return;
        } else if (direction == Direction.RIGHT && this.direction == Direction.LEFT) {
            return;
        }
        this.direction = direction;

    }
    public void move(Apple apple){
        GameObject newHead = createNewHead(); // создаем новую голову
        if(newHead.x >= SnakeGame.WIDTH ||   //  проверяем не вышла ли новая голова за пределы поля
        newHead.x<0 || newHead.y >= SnakeGame.HEIGHT || newHead.y <0){
            isAlive=false; //  если вышла, состояние не жива
            return;
        }
        if(checkCollision(newHead)){  // если происходит столкновение
            isAlive=false;  //  змейка умирает
            return;
        }

        snakeParts.add(0,newHead);  //  добавляем голову, затем удаляем хвост

        if (newHead.x == apple.x && newHead.y == apple.y) {
            apple.isAlive = false;
        } else {
            removeTail();
        }
    }
    public GameObject createNewHead(){  //  движение змейки
        GameObject oldHead = snakeParts.get(0); // вычисляем голову
        if (direction == Direction.LEFT){  //  задаем движение
            return new GameObject(oldHead.x-1, oldHead.y );
        } else if (direction == Direction.DOWN) {
            return new GameObject(oldHead.x, oldHead.y+1);
        } else if (direction == Direction.RIGHT) {
            return new GameObject(oldHead.x+1, oldHead.y);
        }else {
            return new GameObject(oldHead.x, oldHead.y-1 );
        }
    }
    public void removeTail(){

        snakeParts.remove(snakeParts.size()-1); //  удаляем последний элемент змейки
    }
    public boolean checkCollision(GameObject gameObject){
        for (GameObject part : snakeParts) {  //  если части головы змеи совпали с телом
            if (part.x == gameObject.x && part.y == gameObject.y){
                return true;  //  возвращаем правду
            }
        }
        return false;  //  иначе ложь
    }

    public int getLength(){
        return snakeParts.size();
    }
}

