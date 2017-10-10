package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner firstNameFile = new Scanner(System.in);
        Scanner secondNameFile = new Scanner(System.in);
        File firstFile = new File(firstNameFile.nextLine());
        File secondFile = new File(secondNameFile.nextLine());

        try {
           try (FileReader inputStream = new FileReader(firstFile)){
               try (FileWriter outputStream = new FileWriter(secondFile)){
                   Scanner scanner = new Scanner(inputStream);
                   StringBuilder stringBuilder = new StringBuilder();

                   while (scanner.hasNextDouble()){
                       stringBuilder.append(Math.round(scanner.nextDouble())).append(" ");
                   }
                   outputStream.write(stringBuilder.toString());
               }
           }
        }
        catch (FileNotFoundException e){}
        catch (IOException e){}


    }

}
