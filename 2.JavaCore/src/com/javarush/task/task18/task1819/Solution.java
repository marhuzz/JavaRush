package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException,IOException {
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        String secondName = scanner.nextLine();

        try(FileInputStream inputStream = new FileInputStream(firstName)){
            try(FileOutputStream outputStream = new FileOutputStream(firstName,true)){
                try(FileInputStream secondInputStream = new FileInputStream(secondName)){
                    byte[] bytes = new byte[inputStream.available()];
                    byte[] bytes1 = new byte[secondInputStream.available()];

                    while (inputStream.available() > 0){
                        inputStream.read(bytes);
                    }
                    while (secondInputStream.available() > 0){
                        secondInputStream.read(bytes1);
                    }

                    outputStream.write(bytes1);
                    outputStream.write(bytes);

                }
            }
        }
    }

}
