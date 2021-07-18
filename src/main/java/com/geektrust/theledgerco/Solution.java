package com.geektrust.theledgerco;

import java.io.File;

public class Solution {

    /**
     * The entry point for our system
     *
     * @param args - arguments passed to command line
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        try {
            solution.fileToProcess(args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please enter file location!");
        }
    }

    /**
     * Read file to process.
     *
     * @param filePath - path of the input file to process
     */
    private void fileToProcess(String filePath) {
        File file = new File(filePath);
        FileProcessor fileProcessor = new FileProcessor();
        fileProcessor.processInputFile(file);
    }

}
