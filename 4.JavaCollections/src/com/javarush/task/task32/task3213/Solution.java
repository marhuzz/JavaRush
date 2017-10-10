package com.javarush.task.task32.task3213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor Dpljr");
        System.out.println(decode(reader, -3));  //Hello Amigo

    }

    public static String decode(StringReader reader, int key) throws IOException {
        try{
            StringWriter writer = new StringWriter();
            BufferedReader bufferedReader = new BufferedReader(reader);
            String string = bufferedReader.readLine();
            char[] chars = string.toCharArray();

            for (char c : chars){

                writer.write(c + key);
            }
            return writer.toString();

        }
        catch (Exception e){
            return new String();
        }


    }

}
