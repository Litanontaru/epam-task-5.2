package ru.intodayer;

import java.util.concurrent.Semaphore;


public class Philosopher extends Thread {
    private final int mealsLimit = 10;
    private Semaphore semaphore;
    private String name;
    private int numberOfMeals;

    public Philosopher(Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (numberOfMeals < mealsLimit) {
                semaphore.acquire();
                System.out.println(name + " is eating");
                sleep(200);
                numberOfMeals++;

                System.out.println(name + " is thinking");
                semaphore.release();
                sleep(200);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted.");
        }
    }
}
