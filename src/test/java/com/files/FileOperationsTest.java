package com.files;

import org.junit.Test;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FileOperationsTest {
    @Test
    public void return_the_number_of_files_if_the_path_is_folder() throws Exception {
        assertThat(
                new FileOperations().countFilesFor(new File("src/test/")),
                is(6)
        );
    }

    @Test
    public void return_1_if_the_path_is_a_file() throws Exception {
        assertThat(
            new FileOperations().countFilesFor(new File("src/test/java/SampleTest.java")),
            is(1)
        );
    }

    @Test
    public void return_0_if_the_path_is_not_a_file_or_folder() throws Exception {
        assertThat(
            new FileOperations().countFilesFor(new File("")),
            is(0)
        );
    }
}