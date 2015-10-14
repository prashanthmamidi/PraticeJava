package com.files;

import org.junit.Test;

import java.io.File;

import static com.files.FileOperations.compareFiles;
import static com.files.FileOperations.copyFileContentsFromSourceToDestination;
import static com.files.FileOperations.countFilesFor;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FileOperationsTest {
    @Test
    public void return_the_number_of_files_if_the_path_is_folder() throws Exception {
        assertThat(
               countFilesFor(new File("src/test/")),
                is(6)
        );
    }

    @Test
    public void return_1_if_the_path_is_a_file() throws Exception {
        assertThat(
            countFilesFor(new File("src/test/java/SampleTest.java")),
            is(1)
        );
    }

    @Test
    public void return_0_if_the_path_is_not_a_file_or_folder() throws Exception {
        assertThat(
            countFilesFor(new File("")),
            is(0)
        );
    }

    @Test
    public void compare_two_files_are_equal() {
        File file1 = new File("src/test/java/SampleTest.java");
        File file2 = new File("src/test/java/SampleTest.java");

        assertThat(
            compareFiles(file1, file2),
            is(true)
        );
    }

    @Test
    public void compare_two_files_are_not_equal() {
        File file1 = new File("src/test/java/SampleTest.java");
        File file2 = new File("src/test/java/PalindromeTest.java");

        assertThat(
            compareFiles(file1, file2),
            is(false)
        );
    }

    @Test
    public void copyfiles() throws Exception {
        File source = new File("src/test/java/SampleTest.java");
        File destination = new File("src/test/java/SampleTest1.java");
        copyFileContentsFromSourceToDestination(source, destination);

    }
}