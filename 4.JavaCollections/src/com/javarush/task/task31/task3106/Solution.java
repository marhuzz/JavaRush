package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String nameFile = args[0];
        for (int i = 1; i < args.length; i++) {
            try(FileOutputStream outputStream = new FileOutputStream(nameFile)) {
                try (ZipInputStream inputStream = new ZipInputStream(new ByteArrayInputStream(args[i].getBytes()))){
                    while (inputStream.available() > 0){
                        outputStream.write(inputStream.read(args[i].getBytes()));
                    }
                }
            }
        }
    }
}
