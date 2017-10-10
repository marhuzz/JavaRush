package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        String ss = reader.readLine();
        String[] str = ss.split(" ");
        int b = 0;
        int sum = 0;
        if (str.length >= a) {
            for (int i = 0; i < a; i++) {
                b = Integer.parseInt(str[i]);
                sum += b;
            }
        }
        else if (str.length < a) {
            for (int i = 0 ; i < str.length ; i++){
                b = Integer.parseInt(str[i]);
                sum+=b;
            }
        }
        System.out.println(sum);
    }
}