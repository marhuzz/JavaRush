package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] mas = new int[15];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0 ; i < mas.length; i ++) {
            mas[i] = scanner.nextInt();
        }
        int chet=0;
        int nechet=0;
        for (int i=0; i<mas.length; i++)
        {
            if (i%2 == 0) chet += mas[i];
            else nechet += mas[i];
        }
        if (chet>nechet) System.out.println("В домах с четными номерами проживает больше жителей.");
        else if (nechet>chet) System.out.println("В домах с нечетными номерами проживает больше жителей.");//напишите тут ваш код
    }
}
