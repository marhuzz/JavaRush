package com.javarush.task.task31.task3102;



import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> fileTree = new ArrayList<>();
        List<Path> list = Files.walk(Paths.get(root)).filter(Files :: isRegularFile).collect(Collectors.toList());
        for (Path path : list){
            fileTree.add(path.toString());
        }
        return fileTree;

    }

    public static void main(String[] args) {
        
    }
}
