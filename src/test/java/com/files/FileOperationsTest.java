package com.files;

import org.junit.Test;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FileOperationsTest {
    @Test
    public void count_the_number_files_in_a_folder() throws Exception {
        assertThat(
                new FileOperations().countFilesFor(new File("src/test/")),
                is(6)
        );
    }
}