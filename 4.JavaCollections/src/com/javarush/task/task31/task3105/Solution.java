package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        String zipFileName = args[1];

        try{
            try(FileInputStream inputStream = new FileInputStream(fileName)){
                try(ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFileName))){
                    try(ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFileName))) {
                        byte[] bytesFile = new byte[inputStream.available()];
                        byte[] bytesZip = new byte[zipInputStream.available()];
                        ZipEntry zipEntry = new ZipEntry(zipInputStream.getNextEntry());

                        while (inputStream.available() > 0) {
                            inputStream.read(bytesFile);
                        }
                        while (zipInputStream.available() > 0){
                            inputStream.read(bytesZip);
                        }

                        try {
                            zipOutputStream.putNextEntry(new ZipEntry("new.zip"));
                            zipOutputStream.write(bytesFile);
                            zipOutputStream.write(bytesZip);
                            zipOutputStream.closeEntry();
                        }
                        finally {
                            zipOutputStream.close();
                        }

                    }
                }
            }
        }
        catch (Exception e){}
    }
}
