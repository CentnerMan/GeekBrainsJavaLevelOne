package ru.lebedev.se.catsandplates;

public class MainClass {
    public static void main(String[] args) {
        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Барсик", 6);
        cats[1] = new Cat("Мурзик", 7);
        cats[2] = new Cat("Васька", 8);
        cats[3] = new Cat("Моряк", 9);
        cats[4] = new Cat("Рыжик", 5);
        Plate plate = new Plate(11);
        plate.increaseFood(20);
        plate.info();
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
            cats[i].info();
        }
        plate.info();
    }
}
