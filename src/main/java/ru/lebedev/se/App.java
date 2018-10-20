package ru.lebedev.se;

import java.util.Arrays;

/**
 * @author Анатолий Лебедев
 * @version 1.0.1
 */

public class App {
    public static void main(String[] args) {

        // 1. Проверяем инвертирование массива
        int[] arr = {1, 0, 1, 1, 1, 0, 0, 1, 1, 1};
        System.out.println(Arrays.toString(arr));
        invertArray(arr);
        System.out.println(Arrays.toString(arr));

        // 2. Проверяем работу по созданию и заполнению массива размером 8 с помощью цикла
        fillArray8();

        // 3.
        changeArray();

        // 4.
        fillDiagonal();

        // 5.
        minmax();

        // 6.
        int[] arr61 = {1, 1, 1, 2, 1};
        System.out.println(checkBalance(arr61));
        int[] arr62 = {2, 1, 1, 2, 1};
        System.out.println(checkBalance(arr62));
        int[] arr63 = {10, 10};
        System.out.println(checkBalance(arr63));

        // 7.
        int[] arr7 = {6, 7, 8, 9, 10, 11, 12, 13, 14};
        iLikeToMoveIt(arr7, 5);
        System.out.println(Arrays.toString(arr7));
        iLikeToMoveIt(arr7, -5);
        System.out.println(Arrays.toString(arr7));
    }
    // ---------------------------------------------------------------------------------------------------------

    // 1. Инвертируем массив
    public static void invertArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.abs(arr[i] - 1);
        }
    }
    // ---------------------------------------------------------------------------------------------------------

    // 2. Создаем и заполняем массив размером 8 с помощью цикла
    public static void fillArray8() {
        int[] arr = new int[8];
        int b = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = b;
            b = b + 3;
        }
        System.out.println(Arrays.toString(arr)); // Проверяем работу
    }
    // ---------------------------------------------------------------------------------------------------------

    // 3. Цифры в массиве, меньшие 6 умножить на 2
    public static void changeArray() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= 6) {
                arr[i] = arr[i] * 2;
            }
        }
        System.out.println(Arrays.toString(arr)); // Проверяем работу
    }
    // ---------------------------------------------------------------------------------------------------------

    // 4. Двумерный массив
    public static void fillDiagonal() {
        int[][] arr = new int[4][4]; // Создаем двумерный массив 5 на 5

        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
        }
        // Проверяем работу (на всякий случай обобщим, вдруг количество строк не равно количеству столбцов)
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
    // ---------------------------------------------------------------------------------------------------------

    // 5. Минимальный и максимальный элементы одномерного массива
    public static void minmax() {
        int[] arr = {8, 5, 3, 2, 11, 4, 5, 2, 14, 8, 9, 1};
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println("Минимальный элемент: " + min + ", Максимальный элемент: " + max + ".");
    }
    // ---------------------------------------------------------------------------------------------------------

    // 6. Сравниваем левую и правую части массива по границе n, если равны, возвращаем true
    public static boolean checkBalance(int[] arr) {
        for (int n = 0; n < arr.length; n++) {
            int leftSum = 0;
            int rightSum = 0;
            for (int i = 0; i < n; i++) {
                leftSum = leftSum + arr[i];
            }
            for (int i = n; i < arr.length; i++) {
                rightSum = rightSum + arr[i];
            }
            if (leftSum == rightSum) {
                return true;
            }
        }
        return false;
    }

    // 7. Сдвиг элементов массива на n позиций
    public static int[] iLikeToMoveIt(int[] arr, int n) {
        if (n > 0) {
            // Сдвигаем вправо
            for (int i = 0; i < n; i++) {
                int temp = arr[(arr.length - 1)];
                for (int j = arr.length; j > 1; j--) {
                    arr[j - 1] = arr[j - 2];
                }
                arr[0] = temp;

            }
        } else {
            // сдвигаем влево
            n = Math.abs(n);
            for (int i = 0; i < n; i++) {
                int temp = arr[0];
                for (int j = 0; j < (arr.length - 1); j++) {
                    arr[j] = arr[j + 1];
                }
                arr[(arr.length - 1)] = temp;
            }
        }
        return arr;
    }
}

