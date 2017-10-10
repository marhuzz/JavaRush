package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    Thread thread = Thread.currentThread();
    @Override
    public void run() {
        System.out.println(thread.currentThread().getName());
        try {
            while (!thread.isInterrupted()) {
                Thread.sleep(100);
                System.out.println(thread.currentThread().getName());
            }
        }
        catch (InterruptedException e){}
    }

    @Override
    public void start(String threadName) {
        thread = new Thread(threadName);
        thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }
}
