package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {

    public static void main(String[] args) {

        List<File> filteredFiles = getFilteredFileNames(args[0]);

        sortFileNamesAcsending(filteredFiles);

        File resultFile = new File(args[1]);
        String resultFileParentPath = resultFile.getAbsoluteFile().getParent();
        resultFile.delete();
        resultFile  = new File(resultFileParentPath + "/allFilesContent.txt");


        try (FileWriter output = new FileWriter(resultFile)) {
            for (File file : filteredFiles) {
                FileReader input = new FileReader(file);
                while (input.ready()) {
                    char[] buf = new char[1024];
                    int count = input.read(buf);
                    output.write(buf, 0, count);
                    output.write("\r\n");
                }
                input.close();
            }
        } catch (IOException e) {}
    }

    public static List<File> getFilteredFileNames(String path) {
        LinkedList<File> dirs = new LinkedList<File>();
        dirs.add(new File(path));
        String rootPath = dirs.getFirst().getPath();
        List<File> filteredFileNames = new ArrayList<>();
        while (dirs.peek() != null) {
            File dir = dirs.removeFirst();
            for (File f : dir.listFiles()) {
                if (f.isDirectory()) {
                    if (f.list().length == 0) f.delete();
                    else dirs.add(f);
                }
                else if (f.length() > 50) f.delete();
                else filteredFileNames.add(f);
            }
            if (dir.list().length == 0 && !dir.getPath().equals(rootPath)) dir.delete();
        }
        return filteredFileNames;
    }

    public static void sortFileNamesAcsending(List<File> filteredFileNames) {
        Collections.sort(filteredFileNames, new Comparator<File>() {
            @Override
            public int compare(File f1, File f2) {
                return f1.getName().compareTo(f2.getName());
            }
        });
    }

}