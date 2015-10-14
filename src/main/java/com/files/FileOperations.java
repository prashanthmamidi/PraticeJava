package com.files;

import java.io.File;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Stream.of;

public class FileOperations {

    public int countFilesFor(File path) {

        if(!path.exists()) return 0;

        if (path.isFile()) return 1;

        return
            of(path.listFiles())
                .mapToInt(file -> file.isFile() ? 1 : countFilesFor(file))
                .sum();
    }

}
