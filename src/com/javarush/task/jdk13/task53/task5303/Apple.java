package com.javarush.task.jdk13.task53.task5303;
import com.javarush.engine.cell.*;

public class Apple extends GameObject{  //  класс наследник GameObject
    private static final String APPLE_SIGN = "\uD83C\uDF4C";  //  константа значка яблоко
    public boolean isAlive = true;

    public Apple(int x, int y) {
        super(x, y);
    }

    public void draw(Game game) {  //  метод для закрашивания ячейки с яблоком
        game.setCellValueEx(x,y,Color.NONE,APPLE_SIGN,Color.GREEN,75);
    }
}//
