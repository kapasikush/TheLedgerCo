package com.geektrust.theledgerco;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

class FileProcessorTest {

    private FileProcessor fileProcessorUnderTest;

    @BeforeEach
    void setUp() {
        fileProcessorUnderTest = new FileProcessor();
    }

    @Test
    void testProcessInputFile() {
        // Setup
        final File file = new File("filename.txt");

        // Run the test
        fileProcessorUnderTest.processInputFile(file);

    }
}
