package ru.lebedev.se.animals;

public class MainClass {
    public static void main(String[] args) {
        Animal[] animals = new Animal[4];
        animals[0] = new Cat("Васька");
        animals[1] = new Cat("Машка");
        animals[2] = new Dog("Тузик");
        animals[3] = new Dog("Шарик");

        for (Animal animal : animals) {
            animal.info();
            animal.run(100);
            animal.run(450);
            animal.jump(0.3);
            animal.jump(1);
            animal.swim(5);
            animal.swim(15);
            System.out.println("----------------------");
        }
    }
}
