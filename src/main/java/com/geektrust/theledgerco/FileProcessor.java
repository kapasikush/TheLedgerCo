package com.geektrust.theledgerco;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static com.geektrust.theledgerco.Constants.Commands.BALANCE;
import static com.geektrust.theledgerco.Constants.Commands.LOAN;
import static com.geektrust.theledgerco.Constants.Commands.PAYMENT;

class FileProcessor {

    private LoanProcessor loanProcessor = new LoanProcessor();

    /**
     * The function processes input file and executes each command line by line
     *
     * @param file - the input file to process
     */
    void processInputFile(File file) {
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String command = sc.nextLine();
                processCommand(command);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found at location. Please enter correct location!");
        }
    }

    /**
     * This function process the command and performs actions accordingly
     *
     * @param command - the command to perform actions
     */
    private void processCommand(String command) {
        String[] commandParams = command.split(" ");
        int EMI;
        switch (commandParams[0]) {
            case LOAN:
                int principle = Integer.parseInt(commandParams[3]);
                int tenure = Integer.parseInt(commandParams[4]);
                int rateOfInterest = Integer.parseInt(commandParams[5]);
                loanProcessor.addLoan(commandParams[1], commandParams[2], principle, tenure, rateOfInterest);
                break;
            case PAYMENT:
                int lumpSum = Integer.parseInt(commandParams[3]);
                EMI = Integer.parseInt(commandParams[4]);
                loanProcessor.makePayment(commandParams[1], commandParams[2], lumpSum, EMI);
                break;
            case BALANCE:
                EMI = Integer.parseInt(commandParams[3]);
                loanProcessor.checkBalance(commandParams[1], commandParams[2], EMI);
                break;
        }
    }
}
