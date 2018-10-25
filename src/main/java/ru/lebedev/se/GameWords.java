package ru.lebedev.se;

import java.util.Scanner;

/**
 * @author Анатолий Лебедев
 * @version 1.0.3
 */

public class gameWords {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        System.out.println("Начнем иру. Ваша задача угадать загаданное слово");
        String strQuestion = words[(int) (Math.random() * words.length)];

        while (true) {
            System.out.println("Введите свой вариант ответа: ");
            String strAnswer = scanner.nextLine();
            int smallerWord = 0;
            if (strQuestion.length() > strAnswer.length()) {
                smallerWord = strAnswer.length();
            } else smallerWord = strQuestion.length();
            String strTemp = "";
            if (strAnswer.equals(strQuestion)) {
                System.out.println("Вы угадали, это действительно слово: " + strAnswer);
                break;
            } else {
                System.out.println("Вы не угадали, попробуйте еще раз: ");
                for (int i = 0; i < smallerWord; i++) {
                    if (strAnswer.charAt(i) == strQuestion.charAt(i)) {
                        strTemp = strTemp + strAnswer.charAt(i);
                    } else {
                        strTemp = strTemp + "#";
                    }
                }
                for (int i = smallerWord; i < 15; i++) {
                    strTemp = strTemp + "#";
                }
                System.out.println("На своих местах стоят буквы: " + strTemp);
            }
        }
        System.out.println("До свидания, спасибо за игру");
        scanner.close();
    }
}
