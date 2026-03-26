package com.javarush.task.jdk13.task53.task5302;
//
import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;  //  переменная константа задающаая размер поля
    private GameObject gameField[][] = new GameObject[SIDE][SIDE];  //  масиив ячеек
    private int countMinesOnField; //  счетчик мин
    private int countFlags; //  счетчик флагов
    private static final String MINE = "\uD83D\uDCA3"; //  символ мины
    private static final String FLAG = "\uD83D\uDEA9"; //  символ флага
    private boolean isGameStopped;
    private int countClosedTiles = SIDE*SIDE;
    private int score;

    private void openTile(int x, int y) {  //  метод открытия ячейки
        GameObject gameObject = gameField[y][x]; //  получаем объект из ячейки массива
        if (gameObject.isOpen || gameObject.isFlag || isGameStopped == true){
            return;
        }
        gameObject.isOpen = true; //  помечаем как открытую
        setCellColor(x, y, Color.GREEN); //  закрашиваем зеленым
        if (gameObject.isMine) {
            setCellValueEx(gameObject.x, gameObject.y,Color.RED, MINE);  // если ячейка заминирована, рисуем мину
            gameOver();
        } else if (gameObject.countMineNeighbors == 0) {  //если нет мин соседей
            setCellValue(gameObject.x, gameObject.y, ""); // ничего не выводим если нет мин соседей
            List<GameObject> neighbors = getNeighbors(gameObject); //  получаем список соседей
            for (GameObject neighbor : neighbors) {  // перебираем соседей
                if (!neighbor.isOpen) {  // если сосед не открыт
                    openTile(neighbor.x, neighbor.y);  //  открываем неоткрытые ячейки
                }
            }
        } else {
            setCellNumber(x, y, gameObject.countMineNeighbors);  // если есть мины соседи, отображаем их число
        }
        if (gameObject.isOpen && !gameObject.isMine){
            score = score + 5;  //  если ячейка открыта и в ней нет мины даем 5 очков
        }
        setScore(score);  //  вызываем метод отображения очков
        if(gameObject.isOpen){
            countClosedTiles--;
        }
        if(countClosedTiles == countMinesOnField && !gameObject.isMine){
            win();
        }
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
    }

    @Override
    public void onMouseLeftClick(int x, int y) {  //  переопределяем метод
        if(isGameStopped){
            restart();
            return;
        }
        openTile(x, y);
    }

    private void markTile(int x, int y) {
        GameObject gameObject = gameField[y][x];  //  извдекаем объект из массива
        if (gameObject.isOpen || isGameStopped == true || (countFlags == 0 && gameObject.isFlag == false)) {  // если элемент открыт или нет флагов, или элемент не флаг
            return; //  ничего не возвращаем
        }
        if (gameObject.isFlag) {  //  если ячейка помечена флагом
            countFlags++;  // увеличиваем счетчик
            gameObject.isFlag = false;  //  снимаем флаг с ячейки
            setCellValue(x, y, "");  //  очищаем ячейку
            setCellColor(x, y, Color.ORANGE);  //  возвращаем исходный цвет
        } else {  //  если ячейка не помечена флагом
            countFlags--;  //  уменьшаем счетчик
            gameObject.isFlag = true;  // ставим флаг
            setCellValue(x, y, FLAG);  // рисуем флаг
            setCellColor(x, y, Color.YELLOW);  //  открашиваем в желтый
        }
    }


    private void createGame() {  //  создали метод

        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE; y++) { //  прошлись циклом по массиву
                int randomNumber = getRandomNumber(10); //  генерируем рандом
                boolean isMine = randomNumber < 1;  //  вероятность 10%
                if (isMine) {
                    countMinesOnField++;  //  счетчик мин
                }
                gameField[y][x] = new GameObject(x, y, isMine);  //  присвоили значения ячейкам
                setCellColor(x, y, Color.ORANGE);  //  закрасили ячейки
                setCellValue(x,y,"");
            }
        }
        countFlags = countMinesOnField;  // счетчик флагов равен счетчику мин
        countMineNeighbors(); //  вызываем метод получения заминированных соседей
    }


    public void initialize() {
        setScreenSize(SIDE, SIDE);  // задаем размер игрового поля
        createGame();
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {  //  метод для получения списка соседей
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);
            }
        }
        return result;
    }


    private void countMineNeighbors() {  //  метод для получения заминированных соседей
        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE; y++) {  //  проходимся циклом
                GameObject gameObject = gameField[y][x];  //  извлекаем обьект из ячейки
                if (!gameObject.isMine) {  //  если объект не заминирован
                    for (GameObject neighbor : getNeighbors(gameObject)) {  //  перебираем всех соседей текущей ячейки
                        if (neighbor.isMine) {  //  если сосед заминирован
                            gameObject.countMineNeighbors++;  //  увеличиваем счетчик
                        }
                    }
                }
            }

        }
    }
    private void restart(){
        isGameStopped = false;
        countClosedTiles = SIDE*SIDE;
        score = 0;
        setScore(score);
        countMinesOnField=0;
        createGame();
    }

    private void gameOver(){
        isGameStopped = true;
        showMessageDialog(Color.WHITESMOKE, "Ты проиграл!", Color.BLUE, 50);
    }
    private void win(){
        isGameStopped = true;
        showMessageDialog(Color.AQUAMARINE,"Ты Выйграл!!", Color.AZURE,50);
    }
}