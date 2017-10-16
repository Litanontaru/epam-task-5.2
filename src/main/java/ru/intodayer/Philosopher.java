package ru.intodayer;

import java.util.concurrent.Semaphore;


public class Philosopher extends Thread {
    private final int mealsLimit = 100;
    private final Forks forks;
    private Semaphore mainSemaphore;
    private String name;
    private int numberOfMeals;
    private int id;

    public Philosopher(String name, int id, Forks forks) {
        this.mainSemaphore = new Semaphore(2, true);
        this.name = name;
        this.forks = forks;
        this.id = id;
    }

    private void takeLeftFork() throws InterruptedException {
        forks.acquire(id);
    }

    private void returnLeftFork() {
        forks.release(id);
    }

    private void takeRightFork() throws InterruptedException {
        int index = (id + 1) % 5;
        forks.acquire(index);
    }

    private void returnRightFork() {
        int index = (id + 1) % 5;
        forks.release(index);
    }

    private void philosopherAction() throws InterruptedException {
        takeLeftFork();
        takeRightFork();
        System.out.printf("%-10s id:%s %20s%n", name, id, "is eating");

        sleep(50);
        numberOfMeals++;
        System.out.printf("%-10s id:%s %20s%n", name, id, "is thinking");

        returnRightFork();
        returnLeftFork();
        sleep(50);
    }

    @Override
    public void run() {
        try {
            while (numberOfMeals < mealsLimit) {
                mainSemaphore.release();
                philosopherAction();
                mainSemaphore.acquire();
            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted.");
        }
    }
}
