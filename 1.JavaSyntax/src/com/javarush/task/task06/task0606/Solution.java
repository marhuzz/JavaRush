package com.javarush.task.task06.task0606;

import com.sun.javafx.binding.StringFormatter;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().split("");
        for (String s : strings) {
            if (Integer.parseInt(s) % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        System.out.println(String.format("Even: %s Odd: %s",even,odd));
        //напишите тут ваш код
    }
}
