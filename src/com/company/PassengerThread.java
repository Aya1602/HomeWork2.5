package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
//Написать синхронизированное многопоточное приложение которое бы симулировало автовокзал.
//        Всего 100 пассажиров (PassengerThread - пассажиры должны быть отдельными потоками) отправляются в город Ош.
//        Перед тем как отправится им необходимо приобрести билеты на кассе но всего на автовокзале 4 рабочих кассы, и одновременно может обслуживаться только 1 пассажир.
//        Также автобус имеет 100 пассажирских мест и отправляется только тогда когда все они заполнятся.
//        При выполнении задания можно использовать либо Semaphore и CountDownLatch, либо методы wait(), notify(), notifyAll().
//
public class PassengerThread extends Thread {
    Semaphore sem;
    int id;

    CountDownLatch cdl;
    PassengerThread (Semaphore sem, int id, CountDownLatch cdl){
        this.sem=sem;
        this.id=id;
        this.cdl=cdl;
    }
    public void run (){
        try {
            sem.acquire();
            System.out.println("Пассажир " + id + " приобрел билет!");
            sem.release();
            System.out.println("Пассажир " + id + " садится в автобус!");
            cdl.countDown();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}