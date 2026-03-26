package com.javarush.task.jdk13.task53.task5303;

import com.javarush.engine.cell.*;

public class SnakeGame extends Game {
    public static final int HEIGHT = 15;  //  константы размера поля
    public static final int WIDTH = 15;
    private static final int GOAL = 20;
    private Snake snake;
    private int turnDelay;
    private Apple apple ;
    private boolean isGameStopped;
    private int score;
//
    @Override
    public void initialize() {    // переопределили метод
        setScreenSize(WIDTH,HEIGHT);
        createGame();
    }

    @Override
    public void onKeyPress(Key key) {  //  переопределили метод двжения с клавиатуры
        if (key == Key.LEFT){
             snake.setDirection(Direction.LEFT);
        } else if (key == Key.RIGHT) {
            snake.setDirection(Direction.RIGHT);
        } else if (key == Key.UP) {
            snake.setDirection(Direction.UP);
        } else if (key == Key.DOWN) {
            snake.setDirection(Direction.DOWN);
        } else if (key == Key.SPACE && isGameStopped) {  //  рестарт
            createGame();
        }

    }

    private void createGame(){
        turnDelay = 300;
        setTurnTimer(turnDelay);
        snake = new Snake(WIDTH/2,HEIGHT/2);
        createNewApple();
        isGameStopped = false;
        drawScene();
        score = 0;
        setScore(score);
    }

    private void drawScene(){
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                setCellValueEx(x, y, Color.DARKGRAY,"");
            }
        }
        snake.draw(this);
        apple.draw(this);
    }

    @Override
    public void onTurn(int step) {  //  переопределяем метод ходьбы..
        snake.move(apple); //  запускаем
        if (!apple.isAlive) { // если яблоко неживое
            createNewApple();  // создаем новое
            score += 5; // увеличиваем счет на 5
            setScore(score); //  вызываем счетчик
            turnDelay -= 2; //  увеличиваем скорость
            setTurnTimer(turnDelay);
        }

        if (apple.isAlive==false){  //  если яблоко не живое - создаем новое
            createNewApple();
        }
        if(snake.isAlive==false){ //  если змея мертва - вызываем метод гейм овер
            gameOver();
        }

        if (snake.getLength() > GOAL) {  //  если длина змеи больше goal, выйграл
            win();
        }
        drawScene(); //  перерисовываем поле



    }
    private void createNewApple(){
        Apple newApple; //  создаем новый обьект тип Эппл
       do {
           int result1 = getRandomNumber(WIDTH); //  получаем рандомное значение
           int result2 = getRandomNumber(HEIGHT);
           newApple = new Apple(result1, result2); //  присваиваем параметры
           apple = newApple; //  присваиваем ссылку
       }

        while (snake.checkCollision(newApple));  //  устраняем вариант совпадения змеи и яблока
    }
    private void gameOver(){
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.BLACK,"Светочка, ничего страшного"+" " +"\uD83D\uDE1A" +" "+ "ты все равно молодец",Color.ANTIQUEWHITE,25 );
    }
    private void win(){
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.BLACK,"Моя то радость,Света - победитель!!"+ "\uD83D\uDC99"+"\uD83D\uDC99",Color.ANTIQUEWHITE,25 );
    }
}

