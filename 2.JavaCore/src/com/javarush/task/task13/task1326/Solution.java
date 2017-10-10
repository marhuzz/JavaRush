package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        //File file = new File(reader.readLine());
        List<Integer> integerList = new ArrayList<>();

        try(Scanner scanner = new Scanner(new File(reader.readLine()))){

            while (scanner.hasNextInt()){
                if (scanner.nextInt() % 2 == 0){
                    integerList.add(scanner.nextInt());
                }
            }
        }
        System.out.println(integerList);
        // напишите тут ваш код
    }
}
