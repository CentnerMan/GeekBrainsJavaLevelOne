package ru.lebedev.se;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Анатолий Лебедев
 * @version 1.0.1
 */

public class TikTakToe {
    public static int size;
    public static int block;
    public static final char DOT_EMPTY = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random randomStep = new Random();

    public static void main(String[] args) {
        game();
    }

    public static void game() {
        customizeGame();
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            //--------------------------------
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил компьютер");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    //-------------------------------------------------------------------------------------------------------
    public static void customizeGame() {
        do {
            System.out.println("\n Введите размер поля [3-10]: ");
            size = sc.nextInt();
        } while (size < 3 || size > 10);
        do {
            System.out.println("Максимальная длина ряда для победы? [3-" + size + "]");
            block = sc.nextInt();
        } while (block < 3 || block > size);
    }

    //-------------------------------------------------------------------------------------------------------
    public static void initMap() {
        map = new char[size][size];
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                map[row][col] = DOT_EMPTY;
            }
        }
    }

    //-------------------------------------------------------------------------------------------------------
    public static void printMap() {
        for (int i = 0; i <= size; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int row = 0; row < size; row++) {
            System.out.print((row + 1) + " ");
            for (int col = 0; col < size; col++) {
                System.out.print(map[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //-------------------------------------------------------------------------------------------------------
    public static boolean isMapFull() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (map[row][col] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    //-------------------------------------------------------------------------------------------------------
    public static boolean isCellValid(int col, int row) {
        if (col < 0 || col >= size || row < 0 || row >= size) return false;
        if (map[row][col] == DOT_EMPTY) return true;
        return false;
    }

    //-------------------------------------------------------------------------------------------------------
    public static void humanTurn() {
        int col, row;
        do {
            System.out.println("Введите координаты в формате X, Y:");
            col = sc.nextInt() - 1;
            row = sc.nextInt() - 1;
        } while (!isCellValid(col, row));
        map[row][col] = DOT_X;
    }

    //-------------------------------------------------------------------------------------------------------
    public static void aiTurnRandom() {
        int col, row;
        do {
            col = randomStep.nextInt(size);
            row = randomStep.nextInt(size);
        } while (!isCellValid(col, row));
        System.out.println("Компьютер походил в точку: " + (col + 1) + " " + (row + 1));
        map[row][col] = DOT_O;
    }

    //-------------------------------------------------------------------------------------------------------
    public static void aiTurn() {
        int x = -1; //координаты запоминаемой точки
        int y = -1;
        boolean aiWin = false; // выигрывает ИИ
        boolean userWin = false; // выигрывает человек
        // Ищем путь к победе
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                if (isCellValid(col, row)) {
                    map[row][col] = DOT_O;
                    if (checkWin(DOT_O)) {
                        x = col;
                        y = row;
                        aiWin = true;
                    }
                    map[row][col] = DOT_EMPTY;
                }
            }
        }
        // Мешаем человеку, если он побеждает на следующем ходу
        if (!aiWin) {
            for (int col = 0; col < size; col++) {
                for (int row = 0; row < size; row++) {
                    if (isCellValid(col, row)) {
                        map[row][col] = DOT_X;
                        if (checkWin(DOT_X)) {
                            x = col;
                            y = row;
                            userWin = true;
                        }
                        map[row][col] = DOT_EMPTY;
                    }
                }
            }
        }
        if (!aiWin && !userWin) {
            do {
                x = randomStep.nextInt(size);
                y = randomStep.nextInt(size);
            } while (!isCellValid(x, y));
        }
        System.out.println("Компьютер походил в точку: " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    //-------------------------------------------------------------------------------------------------------
    public static boolean checkWin(char symbol) {
        for (int col = 0; col < size; col++) { //вертикали
            int longestLine = 0; //максимальная длина цепочки
            for (int row = 0; row < size; row++) {
                if (map[row][col] == symbol) {
                    longestLine++;
                    if (longestLine >= block) return true;
                }
            }
        }
        for (int row = 0; row < size; row++) { //горизонтали
            int longestLine = 0; //максимальная длина цепочки
            for (int col = 0; col < size; col++) {
                if (map[row][col] == symbol) {
                    longestLine++;
                    if (longestLine >= block) return true;
                }
            }
        }
        for (int col = 0; col < size; col++) { // диагональ влево
            int longestLine = 0; //максимальная длина цепочки
            for (int row = 0; row < size; row++) {
                if (map[row][col] == symbol) longestLine++;
                col++;
                if (longestLine == block) return true;
            }
        }
        for (int col = size - 1; col > 0; col--) { // диагональ право вниз
            int longestLine = 0; //максимальная длина цепочки
            for (int row = 0; row < size; row++) {
                if (map[row][col] == symbol) longestLine++;
                col--;
                if (longestLine == block) return true;
            }
        }
        return false;
    }
}
