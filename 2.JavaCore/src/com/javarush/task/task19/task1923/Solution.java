package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        File fileOne = new File(args[0]);
        File fileTwo = new File(args[1]);

        try{
            try(BufferedReader reader = new BufferedReader(new FileReader(fileOne))){
                try(FileWriter writer = new FileWriter(fileTwo)){
                    String line;
                    String[] words;
                    while ((line = reader.readLine()) != null){
                        words = line.split(" ");
                        for (String word : words){
                            boolean isDigit = false;
                            char[] simvols = word.toCharArray();
                            for (int i = 0; i < simvols.length; i++){
                                if (Character.isDigit(simvols[i])){
                                    isDigit = true;
                                }
                            }
                            if (isDigit){
                                writer.write(word + " ");
                            }
                        }
                    }
                }
            }
        }
        catch (FileNotFoundException e){e.printStackTrace();}
        catch (IOException e){e.printStackTrace();}
    }
}
