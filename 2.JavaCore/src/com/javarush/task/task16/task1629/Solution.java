package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.Scanner;

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        //add your code here - добавьте код тут

        t1.printResult();
        t2.printResult();
    }

    public static class Read3Strings extends Thread {
        String one ;
        String two;
        String three;
        @Override
        public synchronized void run() {
            Scanner scanner = new Scanner(System.in);
            one = scanner.nextLine();
            two = scanner.nextLine();
            three = scanner.nextLine();
        }

        public void printResult(){
        System.out.println(one + " " + two + " " + three);
        }
    } //add your code here - добавьте код тут
}
