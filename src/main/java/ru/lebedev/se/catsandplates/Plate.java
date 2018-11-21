package ru.lebedev.se.catsandplates;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        if (n <= food) {
            food -= n;
            return true;
        }
        return false;
    }

    public void increaseFood(int n) {
        if (n > 0) {
            food += n;
        }
    }

    public void info() {
        System.out.println("Еды в тарелке: " + food);
    }
}
