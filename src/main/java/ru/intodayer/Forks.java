package ru.intodayer;

import java.util.concurrent.Semaphore;


public class Forks {
    private Semaphore forks[];

    public Forks() {
        this.forks = new Semaphore[]{
            new Semaphore(1, true),
            new Semaphore(1, true),
            new Semaphore(1, true),
            new Semaphore(1, true),
            new Semaphore(1, true)
        };
    }

    public void acquire(int index) throws InterruptedException {
        forks[index].acquire();
    }

    public void release(int index) {
        forks[index].release();
    }
}
