package ru.lebedev.se;

import java.util.Scanner;

public class Employees {

    public static void main(String[] args) {
        int edgeOfAge;
        Employee[] EmployeeArray = new Employee[5];
        EmployeeArray[0] = new Employee("Иванов Иван", "Инженер", "ivanov@work.ru", "+78121111111", 30000, 45);
        EmployeeArray[1] = new Employee("Петров Петр", "МеНеДжЕР", "+78122222222", 40000, 38);
        EmployeeArray[2] = new Employee("Сидоров Сидор", "Бухгалтер", 45000, 42);
        EmployeeArray[3] = new Employee("Неизвестный Эрнст", "ДиРЕктОр", "+74952222222", 100000, 60);
        EmployeeArray[4] = new Employee("Львов Лев", "Программист", "lviv@work.ru", "+78125555555", 14000, 24);

        // Запросим пользователя о возрасте сотрудников, старше которого выводить на экран
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите возраст, сотрудников старше которого выводить на экран: ");
        edgeOfAge = sc.nextInt();
        System.out.println();
        sc.close();

        // Выводим сотрудников
        for (Employee employee : EmployeeArray) {
            if (employee.getAge() > edgeOfAge) employee.printInfo();
        }
    }
}
