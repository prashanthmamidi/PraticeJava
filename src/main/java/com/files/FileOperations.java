package com.files;

import java.io.File;

import static java.util.stream.Stream.of;

public class FileOperations {

    int count = 0;

    public Integer countFilesFor(File folder) {
        File[] files = folder.listFiles();
        for(File file: files) {
            if (file.isFile()) {
                count++;
            } else {
                countFilesFor(file);
            }
        }

 /*       of(files)
                .map(file -> file.isFile() ? count++ : countFilesFor(file))
                .count();*/

        return count;
    }
}
