package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String recursion(int a, int b) {
        StringBuilder stringBuilder = new StringBuilder();
        if (a > b) {
            while (a >= b){
                stringBuilder.append(a-- + " ");
            }
        } else {
            if (a == b) {
                return Integer.toString(a);
            }
            while (b >= a) {
                stringBuilder.append(a++ + " ");
            }
        }
        return stringBuilder.deleteCharAt(stringBuilder.length()-1).toString();
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt() % 1_000;
        numberB = random.nextInt() % 10_000;
        System.out.println(recursion(numberA, numberB));
        System.out.println(recursion(numberB, numberA));
    }
}