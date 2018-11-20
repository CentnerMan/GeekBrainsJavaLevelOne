package ru.lebedev.se.animals;

public class Animal {
    protected String name;
    protected double maxRunDistance;
    protected double maxJumpHigh;
    protected double maxSwimDistance;

    public Animal(String name) {
        this.name = name;
    }

    public void info() {
        System.out.println("Кличка: " + name + ", бегает до: " + roundTwo(maxRunDistance) +
                " м., прыгает до: " + roundTwo(maxJumpHigh) + " м., плавает до: " + roundTwo(maxSwimDistance) + " м.");
    }

    public boolean isRun(double distance) {
        if (distance > 0 && distance < maxRunDistance) return true;
        return false;
    }

    public void run(double distance) {
        if (isRun(distance)) System.out.println(name + " легко пробежит " + distance + " м.");
        else System.out.println("Дистанция в " + distance + " м. для " + name + " непосильна.");
    }

    public boolean isJump(double distance) {
        if (distance > 0 && distance < maxJumpHigh) return true;
        return false;
    }

    public void jump(double distance) {
        if (isJump(distance)) System.out.println(name + " без проблем возьмет высоту в " + distance + " м.");
        else System.out.println("Высота в " + distance + " м. для " + name + " непосильна.");
    }

    public boolean isSwim(double distance) {
        if (distance > 0 && distance < maxSwimDistance) return true;
        return false;
    }

    public void swim(double distance) {
        if (isSwim(distance)) System.out.println(name + " уверенно проплывет " + distance + " м.");
        else System.out.println("Дистанция в " + distance + " м. для " + name + " непосильна.");
    }

    // Округляем до 2 знаков после запятой
    public double roundTwo(double num) {
        return Math.round(num * 100.0) / 100.0;
    }
}
