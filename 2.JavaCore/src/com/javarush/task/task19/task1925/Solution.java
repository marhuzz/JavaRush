package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException,IOException {
        //Scanner scanner = new Scanner(System.in);
        File firstFile = new File(args[0]);
        File secondFile = new File(args[1]);

        //try {
            try (BufferedReader reader = new BufferedReader(new FileReader(firstFile))) {
                try(FileWriter writer = new FileWriter(secondFile)){
                    StringBuilder builder = new StringBuilder();
                    while (reader.ready()){
                        String string = reader.readLine();
                        String[] strings = string.split(" ");
                        for (String s : strings) {
                            if (s.length() > 6) {
                                builder.append(s +",");
                            }
                        }
                    }
                    builder.replace(builder.length() - 1,builder.length(),"");
                    writer.write(builder.toString());
                }
            }
        }
        /*catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }*/

    //}
}
