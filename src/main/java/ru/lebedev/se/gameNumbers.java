package ru.lebedev.se;

import java.util.Scanner;

/**
 * @author Анатолий Лебедев
 * @version 1.0.2
 */

public class gameNumbers {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean willgame = true;
        do {
            System.out.println("Здравствуйте. Ваша задача угадать число от 0 до 9 с трех попыток");
            int range = 9; // диапазон чисел
            int number = (int) (Math.random() * range); // случайно сгенерируемое число в диапазоне
            int yesOrNo = 5; // Повторяем ли игру? 1 - да, 0 - нет. Для хотя бы одного запуска цикла делаем любым целым больше 1
            boolean win = false; // Победили или нет
            for (int i = 1; i <= 3; i++) {
                System.out.println("Введите число: ");
                int input_number = scanner.nextInt();
                if (input_number == number) {
                    System.out.println("Да, это " + number + ", вы выиграли");
                    win = true;
                    break;
                } else if (input_number > number) {
                    System.out.println("Загаданное число меньше чем Ваше");
                } else {
                    System.out.println("Загаданное число больше Вашего");
                }
            }
            if (!win) {
                System.out.println("К сожалению, вы не угадали число за 3 попытки и проиграли :(");
            }
//            Данный код работает, но пробую сделать попроще
//            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
//            boolean doItAgain = false;
//            do {
//                int yesOrNo = scanner.nextInt();
//                switch (yesOrNo) {
//                    case 1:
//                        willgame = true;
//                        doItAgain = false;
//                        break;
//                    case 0:
//                        willgame = false;
//                        doItAgain = false;
//                        break;
//                    default:
//                        System.out.println("Для новой игры нужно ввести 1, для выхода - 0, попробуйте еще раз");
//                        doItAgain = true;
//                }
//            }
//            while (doItAgain);

            while (!(yesOrNo >= 0 && yesOrNo <= 1)) {
                System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
                yesOrNo = scanner.nextInt();
            }
            switch (yesOrNo) {
                case 1:
                    willgame = true;
                    break;
                case 0:
                    willgame = false;
                    break;
                default:
                    System.out.println("Странно, вы не должны были это увидеть");
            }
        }
        while (willgame);
        System.out.println("До свидания, спасибо за игру");
        scanner.close();
    }
}
