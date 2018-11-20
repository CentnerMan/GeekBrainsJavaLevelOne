package ru.lebedev.se.animals;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
        maxJumpHigh = 1 + Math.random() * 1; // jump from 1 to 2 meters
        maxRunDistance = 100 + Math.random() * 200; // runs min 100 max 300 meters
        maxSwimDistance = 0; // cats no swim
    }

    @Override
    public void info() {
        System.out.println("Кот: " + name + ", бегает до: " + roundTwo(maxRunDistance) +
                " м., прыгает до: " + roundTwo(maxJumpHigh) + " м., в воду не полезет");
    }

    @Override
    public void swim(double distance) {
        System.out.println("К сожалению, котики плохо плавают, и дистанция в " + distance + " м. для " + name + " непосильна.");
    }
}
