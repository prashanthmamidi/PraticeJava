package com.files;

import java.io.*;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Stream.of;

public class FileOperations {

    public static Integer countFilesFor(File path) {

        if(!path.exists()) return 0;

        if (path.isFile()) return 1;

        return
            of(path.listFiles())
                .mapToInt(FileOperations::countFilesFor)
                .sum();
    }

    public static Boolean compareFiles(File file1, File file2) {

        if(file1.compareTo(file2) != 0)
            return false;
        return true;
    }

    public static File copyFileContentsFromSourceToDestination(File sourceFile, File destFile) {

        try (
            InputStream inputStream = new FileInputStream(sourceFile);
            OutputStream outputStream = new FileOutputStream(destFile)
        ) {

            byte[] buf = new byte[1024];
            int length;
            while((length = inputStream.read(buf)) > 0) {
                outputStream.write(buf,0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destFile;
    }

}
