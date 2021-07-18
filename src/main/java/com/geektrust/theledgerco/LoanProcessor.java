package com.geektrust.theledgerco;

import java.util.HashMap;
import java.util.Map;

class LoanProcessor {

    LoanProcessor() {

    }

    private Map<String, Loan> LoanMap = new HashMap<>();

    /**
     * This method adds a new loan data
     *
     * @param BankName       - Name of the Bank
     * @param PersonName     - Name of the borrower
     * @param principle      - the principle amount
     * @param tenure         - the tenure of loan
     * @param rateOfInterest - the rate of interest for loan
     */
    void addLoan(String BankName, String PersonName, int principle, int tenure, int rateOfInterest) {
        Loan loan = new Loan(BankName, PersonName, principle, tenure, rateOfInterest);
        String identifier = getIdentifier(BankName, PersonName);
        LoanMap.put(identifier, loan);
    }

    /**
     * This method is used to check current loan balance
     *
     * @param BankName   - Name of the Bank
     * @param PersonName - Name of the borrower
     * @param EMI        - Monthly installation for loan
     */
    void checkBalance(String BankName, String PersonName, int EMI) {
        String identifier = getIdentifier(BankName, PersonName);
        Loan loan = getLoanInfo(identifier);
        if(loan!=null)
            processLoanBalance(loan, EMI);
    }

    /**
     * This method processes a lumpSum payment made towards loan
     *
     * @param BankName   - Name of the Bank
     * @param PersonName - Name of the borrower
     * @param lumpSum    - the lumpSum amount paid towards loan
     * @param EMI        - Monthly installation for loan
     */
    void makePayment(String BankName, String PersonName, int lumpSum, int EMI) {
        String identifier = getIdentifier(BankName, PersonName);
        Loan loan = getLoanInfo(identifier);
        if(loan!=null)
            loan.putLumpSumData(EMI, lumpSum);
    }

    /**
     * This method gets Loan info for a given unique loan identifier
     *
     * @param identifier - the unique identifier for a loan
     * @return - Loan object
     */
    private Loan getLoanInfo(String identifier) {
        Loan loan = null;
        if (LoanMap.containsKey(identifier))
            loan = LoanMap.get(identifier);
        else {
            System.out.println("please enter correct loan identifier. No such loan exist error!!");
        }
        return loan;
    }

    /**
     * This method generates a unique loan identifier for a loan
     *
     * @param BankName   - Name of the Bank
     * @param PersonName - Name of the borrower
     * @return - unique Loan identifier
     */
    String getIdentifier(String BankName, String PersonName) {
        return BankName + ":" + PersonName;
    }


    /**
     * This method processes the loan balance considering all payments and EMIs made
     *
     * @param loan - The Loan object containing loan information
     * @param EMI  - Monthly installation for loan
     */
    private void processLoanBalance(Loan loan, int EMI) {
        int totalMonths = loan.getTenure() * 12;
        float interest = (loan.getPrinciple() * loan.getRateOfInterest() * loan.getTenure()) / 100;
        float totalPayable = loan.getPrinciple() + interest;
        int monthlyEMI = (int) Math.ceil(totalPayable / totalMonths);
        int paid = EMI * monthlyEMI;
        Map<Integer, Integer> lumpSumMap = loan.getLumpSumMap();

        for (Map.Entry lumpSumEntry : lumpSumMap.entrySet()) {
            int key = (int) lumpSumEntry.getKey();
            int value = (int) lumpSumEntry.getValue();

            if (key <= EMI) {
                paid += value;
            } else {
                break;
            }
        }
        int amountRemaining = (int) Math.ceil(totalPayable - paid);
        int newTenureMonths = (int) Math.ceil((float) amountRemaining / monthlyEMI);
        int totalPayableInt = (int) Math.ceil(totalPayable);
        if (paid > totalPayableInt)
            paid = totalPayableInt;
        printOutput(loan.getBankName(), loan.getPersonName(), paid, newTenureMonths);
    }

    /**
     * This method prints the Loan balance information on screen
     *
     * @param BankName        - Name of the Bank
     * @param PersonName      - Name of the borrower
     * @param paid            - Amount already paid for the loan
     * @param newTenureMonths - new tenure of loan considering all payments done
     */
    private void printOutput(String BankName, String PersonName, int paid, int newTenureMonths) {
        System.out.println(BankName + " " + PersonName + " " + paid + " " + newTenureMonths);
    }

}
