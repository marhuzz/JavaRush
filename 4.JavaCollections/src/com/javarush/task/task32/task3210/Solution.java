package com.javarush.task.task32.task3210;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Paths;
import java.util.Arrays;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        String name = args[0];
        File fileName = new File(name);
        int number = Integer.parseInt(args[1]);
        String text = args[2];

        try {
            try (RandomAccessFile randomAccessFile = new RandomAccessFile(name, "rw")) {
                randomAccessFile.seek(number);
                byte [] bytes = new byte[text.length()];
                randomAccessFile.read(bytes,0,text.length());

                if (convertByteToString(bytes).equals(text)){
                    randomAccessFile.seek(randomAccessFile.length());
                    randomAccessFile.write("true".getBytes());
                }
                else {
                    randomAccessFile.seek(randomAccessFile.length());
                    randomAccessFile.write("false".getBytes());
                }
            }
        }
        catch (IOException e){}
    }

    private static String convertByteToString(byte[] bytes) {
        return new String(bytes);
    }


}

