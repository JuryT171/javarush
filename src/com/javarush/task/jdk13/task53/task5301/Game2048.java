package com.javarush.task.jdk13.task53.task5301;

import com.javarush.engine.cell.*;

public class Game2048 extends Game {
    private static final int SIDE = 4;   // константа размера игрового поля
    private int gameField[][] = new int[SIDE][SIDE];   // создали массив с ячейками 4*4
    private boolean isGameStopped = false;
    private int score;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);   // переопределили метод,задали размер 4*4
        createGame();  //вызвали метод создание игры
        drawScene();  // вызвали метод для закрашивания поля
    }

    private void createGame() {
        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE; y++) {
                gameField [y][x] = 0;  // матрица создается заново с нулями
            }
        }
        createNewNumber();
        createNewNumber();
    }

    @Override
    public void onKeyPress(Key key) {//  переопределяем метод

        if (isGameStopped){
           if(key == key.SPACE){  //  если игра остановлена нажатием на пробел
               isGameStopped = false;
               score = 0;  //  обнуляем счетчик
               createGame();  //  делаем рестарт
               drawScene();
               setScore(score);
           }
            return;
        }

        if (!canUserMove()){  //  если ход невозможен - игразавершена
            gameOver();
            return;
        }
        if (key == key.LEFT) {  //  если нажали влево - вызываем метод влево
            moveLeft();
            drawScene();       // перерисовываем игровое поле
        } else if (key == key.RIGHT) {
            moveRight();
            drawScene();       // перерисовываем игровое поле
        } else if (key == key.UP) {
            moveUp();
            drawScene();       // перерисовываем игровое поле
        } else if (key == key.DOWN) {
            moveDown();
            drawScene();       // перерисовываем игровое поле
        }

    }

    private void moveLeft() {
        boolean isNewNumberNeeded = false;  //  переменная маркер
        for (int[] row : gameField) {  //  перебираем массив
            boolean wasCompressed = compressRow(row);  //  сдвигаем влево ненулевые элементы
            boolean wasMerged = mergeRow(row);   //  складываем соседние числа
            if (wasMerged) {
                compressRow(row);
            }
            if (wasCompressed || wasMerged) {
                isNewNumberNeeded = true;  // если было движение - ход состоялся
            }
        }
        if (isNewNumberNeeded) {
            createNewNumber();   // добавляем новую плитку (2 или 4)
        }
    }

    private void moveRight() {
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
    }

    private void moveUp() {
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }

    private void moveDown() {
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    private void rotateClockwise() {
        int[][] rotated = new int[SIDE][SIDE]; // временная матрица для результата

        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                rotated[x][SIDE - 1 - y] = gameField[y][x]; // переворот
            }
        }
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                gameField[y][x] = rotated[y][x];  // присваиваем значение новой матрицы
            }
        }
    }

    private void createNewNumber() {
        boolean isCreated = false;  //  переменная маркер
        do {
            int x = getRandomNumber(SIDE);  // переменная с рандомным числом
            int y = getRandomNumber(SIDE);
            if (gameField[y][x] == 0) {  //  если поле пустое
                int randomNumber = getRandomNumber(10);  //переменная с рандомным числом 0-9
                if (randomNumber < 9) {  // если число 0-9  90%  - значение 2
                    randomNumber = 2;
                } else if (randomNumber == 9) {   //если равно 9 то значение 4 (10%)
                    randomNumber = 4;
                }
                gameField[y][x] = randomNumber;  // заносим в поле полученное число
                isCreated = true;  //
            }
        } while (!isCreated); //  завершаем цикл когда все сделано

        if (getMaxTileValue() >= 2048) {  //  если значение 2048 вызываем метод победа
            win();
            return;
        }
    }

    private Color getColorByValue(int value) {   //  метод для присваения цвета в клетку по числу
        switch (value) {
            case 0:
                return Color.WHITE;
            case 2:
                return Color.PLUM;
            case 4:
                return Color.CYAN;
            case 8:
                return Color.GREEN;
            case 16:
                return Color.ORANGE;
            case 32:
                return Color.PINK;
            case 64:
                return Color.RED;
            case 128:
                return Color.MAGENTA;
            case 256:
                return Color.YELLOW;
            case 512:
                return Color.LIGHTGRAY;
            case 1024:
                return Color.GRAY;
            case 2048:
                return Color.DARKGRAY;
            default:
                return Color.NONE;
        }

    }

    private void setCellColoredNumber(int x, int y, int value) {  // метод для отображения цвета клетки и значения
        Color cellColor = getColorByValue(value);   // получаем цвет
        String str; // строковая переменная
        if (value > 0) {  //  если значение больше 0
            str = "" + value; //  преобразуем число в строку
        } else {
            str = "";  //  иначе пустая строка
        }
        setCellValueEx(x, y, cellColor, str);  //  Устанавливаем цвет и строковое значение для клетки
    }

    private void drawScene() {   //  метод для закрашивания поля в определенный цвет
        for (int y = 0; y < SIDE; y++) {  //  пробегаемся по массиву клеток
            for (int x = 0; x < SIDE; x++) {
                int cellValue = gameField[y][x];
                setCellColoredNumber(x, y, cellValue);  // Вызываем наш метод для отрисовки клетки
            }
        }
    }

    private boolean compressRow(int[] row) {
        int currentIndex = 0; // индекс, куда будет помещен ненулевой элемент
        boolean moved = false; // маркер показывающий, был ли сдвиг
        for (int i = 0; i < row.length; i++) {  //  проходимся по массиву
            if (row[i] != 0) {   // если ячейка не равна 0
                if (i != currentIndex) {  // проверяем не находится ли ненулевой элемент уже на своем месте
                    row[currentIndex] = row[i];  //  перемещаем ненулевое значение
                    row[i] = 0;  //  обнуляем значение, в котором находилось число
                    moved = true;  //  обозначаем что было движение
                }
                currentIndex++;
            }
        }
        return moved;
    }

    private boolean mergeRow(int[] row) {
        boolean merged = false;  // маркер показывающий было ли наложение плиток
        for (int i = 0; i < row.length - 1; i++) {   // идем до row.length - 1, так как сравниваем i с i+1
            if (row[i] != 0 && row[i] == row[i + 1]) {  //  если плитка не равно 0 и равна соседней
                score = score + row[i]*2; //  увеличиваем очки в графе score
                row[i] = row[i] * 2; //  удваиваем значение
                row[i + 1] = 0; // правую плитку обнуляем
                merged = true;  // маркер что плитки слились
                setScore(score);
            }
        }
        return merged;
    }

    private int getMaxTileValue() {  //  находим самое большое число 2048
        int getMaxValue = 0;   // временная переменная
        for (int x = 0; x < SIDE; x++) {   //  проходимся по массиву
            for (int y = 0; y < SIDE; y++) {
                if (gameField[x][y] > getMaxValue) {
                    getMaxValue = gameField[x][y];   //  если значение больше временной переменной - оно ей присваивается
                }
            }
        }
        return getMaxValue;
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.RED, "Ты выйграл!!!", Color.BLUE, 100);
    }

    private void gameOver () {
        isGameStopped = true;
        showMessageDialog(Color.RED, "Ты проиграл((", Color.BLUE, 100);
    }

    private boolean canUserMove() {
        for (int x = 0; x < SIDE; x++) {   //  проходимся по массиву(полю)
            for (int y = 0; y < SIDE; y++) {
                if (gameField[y][x] == 0) {  //  проверка наличия пустых клеток
                    return true;
                } else if (y < SIDE - 1 && gameField[y][x] == gameField[y + 1][x]) {  //проверяем на совпадение соседних клеток
                    return true;
                } else if (x < SIDE - 1 && gameField[y][x] == gameField[y][x+1]) { //проверяем на совпадение соседних клеток
                    return true;
                }
            }
        }
        return false;
    }
} //hh





