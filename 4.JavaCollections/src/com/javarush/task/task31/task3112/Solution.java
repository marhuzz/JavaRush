package com.javarush.task.task31.task3112;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.*;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://www.amigo.com/ship/secretPassword.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        URL address = new URL(urlString);
        String[] strings = urlString.split("/");
        String nameFile = strings[strings.length-1];
        Path pathResult = Paths.get(downloadDirectory + "//" + nameFile);
        Path tempFile = Files.createTempFile(null,null);
        Files.copy(address.openStream(),tempFile);
        Files.move(tempFile,pathResult);

        return pathResult;
        // implement this method
    }
}
