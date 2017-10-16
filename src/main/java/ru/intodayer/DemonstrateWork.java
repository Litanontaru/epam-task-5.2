package ru.intodayer;

import java.util.concurrent.Semaphore;


public class DemonstrateWork {
    public static void demonstrate() {
        Semaphore semaphore = new Semaphore(3, true);
        new Philosopher(semaphore, "Nietzsche").start();
        new Philosopher(semaphore, "Parmenides").start();
        new Philosopher(semaphore, "Aristotle").start();
        new Philosopher(semaphore, "Sun Tzu").start();
    }
}
