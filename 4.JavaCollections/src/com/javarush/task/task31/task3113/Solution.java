package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;


/* 
Что внутри папки?
*/
public class Solution {
    private static int countDirect = 0;
    private static int countFiles = 0;
    private static long countSize = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Path path = Paths.get(reader.readLine());
        if (!Files.isDirectory(path)){
            String res = String.format(("%s - не папка"),path.toAbsolutePath().toString());
            System.out.println(res);
        }
        Files.walkFileTree(path,new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                countFiles++;
                countSize += Files.size(file);
                return super.visitFile(file, attrs);
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                countDirect++;
                return super.preVisitDirectory(dir, attrs);
            }
        });

        System.out.println("Всего файлов - " + countFiles);
        System.out.println("Всего папок - " + (countDirect-1));
        System.out.println("Общий размер - " + countSize);
    }
}
