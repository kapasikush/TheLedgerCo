package com.geektrust.theledgerco;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoanProcessorTest {

    private LoanProcessor loanProcessorUnderTest;

    @BeforeEach
    void setUp() {
        loanProcessorUnderTest = new LoanProcessor();
    }

    @Test
    void testAddLoan() {

        // Run the test
        loanProcessorUnderTest.addLoan("BankName", "PersonName", 0, 0, 0);

    }

    @Test
    void testCheckBalance() {

        // Run the test
        loanProcessorUnderTest.checkBalance("BankName", "PersonName", 0);

    }

    @Test
    void testMakePayment() {

        // Run the test
        loanProcessorUnderTest.makePayment("BankName", "PersonName", 0, 0);

    }

    @Test
    void testGetIdentifier() {

        // Run the test
        final String result = loanProcessorUnderTest.getIdentifier("BankName", "PersonName");

        // Verify the results
        assertEquals("BankName:PersonName", result);
    }
}
