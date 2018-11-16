package ru.lebedev.se;


public class Employee {
    private String fio;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;
    private final static String EMAIL = "ouroffice@ourwork.com"; // Если нет своей электронной почты, ставим рабочую
    private final static String PHONE = "+78122233322"; // Если нет телефона - ставим рабочий

    //------------------------------------------------------------------------------------------------------------
    // Формируем простые сеттеры и геттеры

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getFio() {
        return fio.toUpperCase(); // Выводим в верхнем регистре
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return toTitleCase(position); // Выводим строчными буквами с первой заглавной
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setAge(int age) {
        if (age > 0)
            this.age = age;
        else
            this.age = age * (-1); // Переводим отрицательный возраст в положительный, считаем опечаткой
    }

    public int getAge() {
        return age;
    }

    //------------------------------------------------------------------------------------------------------------
    // формируем конструкторы

    public Employee(String fio, String position, String email, String phoneNumber, int salary, int age) {
        setFio(fio);
        setPosition(position);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setSalary(salary);
        setAge(age);
    }

    public Employee(String fio, String position, String phoneNumber, int salary, int age) {
        this(fio, position, EMAIL, phoneNumber, salary, age);
    }

    public Employee(String fio, String position, int salary, int age) {
        this(fio, position, EMAIL, PHONE, salary, age);
    }

    //------------------------------------------------------------------------------------------------------------
    // Преобразуем первый символ строки в верхний регистр, остальные в нижний

    public static String toTitleCase(String s) {
        if (s.isEmpty()) {
            return s;
        }
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

    //------------------------------------------------------------------------------------------------------------
    // Выводим данные работника с помощью геттеров для форматирования

    public void printInfo() {
        System.out.println("Ф.И.О.: " + getFio() + ", Должность: " + getPosition() + ", Электронная почта: "
                + getEmail() + ", Телефон: " + getPhoneNumber() + ", Зарплата: " + getSalary()
                + ", Возраст: " + getAge());
    }

    // Выводим данные работника как введено
    public void printInfoOriginal() {
        System.out.println("Ф.И.О.: " + fio + ", Должность: " + position + ", Электронная почта: "
                + email + ", Телефон: " + phoneNumber + ", Зарплата: " + salary + ", Возраст: " + age);
    }
}


