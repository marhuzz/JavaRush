package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by Marhuz on 23.03.2017.
 */
public class HTMLFileFilter extends FileFilter {
    public HTMLFileFilter() {
        super();
    }

    @Override
    public boolean accept(File file) {
        if (file.isDirectory()){
            return true;
        }
        String name = file.getName().toLowerCase();
        if (name.endsWith(".html") || name.endsWith(".htm")){
            return true;
        }
        else {return false;}
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
