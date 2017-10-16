package ru.intodayer;


public class DemonstrateWork {
    public static void demonstrate() {
        Forks forks = new Forks();
        new Philosopher("Nietzsche", 0, forks).start();
        new Philosopher("Parmenides", 1, forks).start();
        new Philosopher("Aristotle", 2, forks).start();
        new Philosopher("Sun Tzu", 3, forks).start();
        new Philosopher("Sun Tzu", 4, forks).start();
    }
}
