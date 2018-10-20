package ru.lebedev.se;

/**
 * @author Анатолий Лебедев
 * @version 1.0.0
 */

public class App 
{
    public static void main(String[] args) {
        // 2. Объявляем и инициализируем переменные известных типов
        byte b = 125;
        short s = 32000;
        int i = 2514215;
        long l = 635466546L;
        float f = 120.0F;
        double d = 21545.234D;
        boolean logic = true;
        char ch = 'a';

        // Проверяем calculate
        System.out.println(calculate(1, 2, 3, 4));

        // Проверяем checkDiapazon
        System.out.println(checkDiapazon(5, 3));
        System.out.println(checkDiapazon(5, 12));
        System.out.println(checkDiapazon(5, 22));

        // Проверяем plus_minus
        plus_minus(23);
        plus_minus(-40);

        // Проверяем Negative
        System.out.println(isNegative(-15));
        System.out.println(isNegative(20));

        // Проверяем sayHello
        sayHello("Васисуалий");

        // Проверяем checkLeapYear
        checkLeapYear(1980);
        checkLeapYear(1900);
        checkLeapYear(2000);
        checkLeapYear(1975);
    }


    // 3. Вычисляем значение a * (b + (c / d))
    public static double calculate(double a, double b, double c, double d) {
        return (a * (b + (c / d)));
    }

    // 4. От 10 до 20
    public static boolean checkDiapazon(double a, double b) {
        if ((a + b) >= 10 && (a + b) <= 20) {
            return true;
        } else return false;
    }

    // 5. Положительное или отрицательное
    public static void plus_minus(int a) {
        if (a >= 0) {
            System.out.println(a + " - число положительное");
        } else System.out.println(a + " - число отрицательное");
    }

    // 6. Если отрицательное, то true
    public static boolean isNegative(int a) {
        if (a < 0) {
            return true;
        } else return false;
    }

    // 7. Возвращаем имя с приветом :)
    public static void sayHello(String str) {
        System.out.println("Привет, " + str + "!");
    }

    // 8. Определяем високосный год
    public static void checkLeapYear(int data) {
        if ((data % 4 == 0) && (data % 100 != 0) || (data % 400 == 0)) {
            System.out.println(data + " - год високосный");
        } else {
            System.out.println(data + " - год не високосный");
        }
    }

}
