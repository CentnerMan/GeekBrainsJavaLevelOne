package ru.lebedev.se.animals;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
        maxJumpHigh = 0.5 + Math.random() * 0.5; // jump from 0.5 to 1 meters
        maxRunDistance = 400 + Math.random() * 200; // runs min 400 max 600 meters
        maxSwimDistance = 5 + Math.random() * 10; // swim from 5 to 15 meters
    }

    @Override
    public void info() {
        System.out.println("Собака: " + name + ", бегает до: " + roundTwo(maxRunDistance) +
                " м., прыгает до: " + roundTwo(maxJumpHigh) + " м., плавает до: " + roundTwo(maxSwimDistance) + " м.");
    }

}
