package com.javarush.task.task25.task2506;

/**
 * Created by Marhuz on 26.02.2017.
 */
public class LoggingStateThread extends Thread {
    private Thread thread;

    public LoggingStateThread(Thread thread) {

        this.thread = thread;
        setDaemon(true);
        //System.out.println(thread.getState());
    }

    @Override
    public void run() {
        State state = thread.getState();
        System.out.println(state);
        while (state != state.TERMINATED) {
            if(state != thread.getState()){
                state = thread.getState();
                System.out.println(state);

        }
    }
}}
