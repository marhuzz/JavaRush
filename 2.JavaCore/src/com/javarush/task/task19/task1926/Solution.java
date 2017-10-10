package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException,IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileIn = new BufferedReader(new FileReader(reader.readLine()));

        while (fileIn.ready()) {
            String line = fileIn.readLine();
            System.out.println(new StringBuffer(line).reverse().toString());
        }

        reader.close();
        fileIn.close();
    }
}
