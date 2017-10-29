package ru.intodayer;

import java.util.concurrent.Semaphore;

//Дизайн класса переусложнён.
//Такая оргаизация хороша только в том, случае, когда философы постоянно меняются своими вилками.
//В задаче же к каждому философу строко соответствует 2 вилки.
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
