package com.geektrust.theledgerco;

import java.util.Map;
import java.util.TreeMap;

class Loan {
    private String BankName;
    private String PersonName;
    private int principle;
    private int tenure;
    private int rateOfInterest;
    private Map<Integer, Integer> lumpSumMap;

    /**
     * Constructor for Loan Object
     *
     * @param BankName       - Name of the Bank
     * @param PersonName     - Name of the borrower
     * @param principle      - the principle amount
     * @param tenure         - the tenure of loan
     * @param rateOfInterest - the rate of interest for loan
     */
    Loan(String BankName, String PersonName, int principle, int tenure, int rateOfInterest) {
        this.BankName = BankName;
        this.PersonName = PersonName;
        this.principle = principle;
        this.tenure = tenure;
        this.rateOfInterest = rateOfInterest;
        this.lumpSumMap = new TreeMap<>();
    }


    /**
     * getter method for tenure
     *
     * @return - tenure
     */
    int getTenure() {
        return this.tenure;
    }


    /**
     * getter method for principle amount
     *
     * @return - principle amount
     */
    int getPrinciple() {
        return this.principle;
    }

    int getRateOfInterest() {
        return this.rateOfInterest;
    }

    /**
     * getter method for bank name
     *
     * @return - name of the bank
     */
    String getBankName() {
        return this.BankName;
    }

    /**
     * getter method for borrower name
     *
     * @return - borrower name
     */
    String getPersonName() {
        return this.PersonName;
    }

    /**
     * getter method for lumpSum amount Map
     *
     * @return - Map containing lumpSum amount data
     */
    Map<Integer, Integer> getLumpSumMap() {
        return this.lumpSumMap;
    }

    /**
     * method for adding lumpSum amount data into Map
     *
     * @param EMI     - the EMI for loan
     * @param lumpSum - the lumpSum amount data
     */
    void putLumpSumData(int EMI, int lumpSum) {
        if (this.lumpSumMap.containsKey(EMI)) {
            this.lumpSumMap.put(EMI, this.lumpSumMap.get(EMI) + lumpSum);
        } else {
            this.lumpSumMap.put(EMI, lumpSum);
        }
    }
}
