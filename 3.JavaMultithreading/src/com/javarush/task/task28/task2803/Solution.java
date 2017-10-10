package com.javarush.task.task28.task2803;

import java.util.concurrent.ThreadLocalRandom;

/* 
ThreadLocalRandom
*/
public class Solution {
    public static int getRandomIntegerBetweenNumbers(int from, int to) {
        Thread thread = new Thread();
        final int i = ThreadLocalRandom.current().nextInt(from, to);
        return i;
    }

    public static double getRandomDouble() {
        Thread thread = new Thread();
        final double i = ThreadLocalRandom.current().nextDouble();
        return i;
    }

    public static long getRandomLongBetween0AndN(long n) {
        Thread thread = new Thread();
        final long i = ThreadLocalRandom.current().nextLong(n);
        return i;
    }

    public static void main(String[] args) {
    }
}
