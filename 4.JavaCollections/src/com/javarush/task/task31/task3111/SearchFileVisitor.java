package com.javarush.task.task31.task3111;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private int minSize = -1;
    private int maxSize = -1;
    private String partOfName;
    private String partOfContent;
    private List<Path> foundFiles = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        boolean isFiltered = true;

        if (!Files.isRegularFile(file)){
            return FileVisitResult.CONTINUE;
        }

        if (partOfName != null  && !partOfName.equals("") && !file.getFileName().toString().toUpperCase().contains(partOfName.toUpperCase())) {
            isFiltered = false;
        }
        if (maxSize != -1 && (Files.size(file) > maxSize)) {
            isFiltered = false;
        }
        if (minSize != -1 && (Files.size(file) < minSize)) {
            isFiltered = false;
        }
        if (partOfContent != null) {
            if (!new String(Files.readAllBytes(file)).contains(partOfContent)) {
                isFiltered = false;
            }
        }

        if (isFiltered){
            foundFiles.add(file);
        }

        return FileVisitResult.CONTINUE;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
}
