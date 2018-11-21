package ru.lebedev.se.catsandplates;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate plate) {
        if (plate.decreaseFood(appetite)) satiety = true;
    }

    public void info() {
        if (satiety) {
            System.out.println("Кот " + name + " сыт");
        } else System.out.println("Кот " + name + " голоден");
    }
}
