package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int passengerCount = 100;
    CountDownLatch cdl = new CountDownLatch(passengerCount);
        Semaphore sem = new Semaphore(4);
        for (int i = 0; i <= 100; i++) {
            PassengerThread pt = new PassengerThread(sem, i, cdl);
            pt.start();
        }
        cdl.await();
        System.out.println("Места наконец-то заполнены!");

    }
}