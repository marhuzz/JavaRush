package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        nod(a,b);
    }
    public static void nod(int a, int b)
    {
        try {
            if (a > b) a = a - b;
            else b = b - a;
            if (b == 0) {
                System.out.println(a);
                return;
            }
            nod(a, b);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
