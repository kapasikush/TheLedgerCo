package com.geektrust.theledgerco;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoanTest {

    private Loan loanUnderTest;

    @BeforeEach
    void setUp() {
        loanUnderTest = new Loan("BankName", "PersonName", 100, 10, 2);
    }

    @Test
    void testGetTenure() {

        // Run the test
        final int result = loanUnderTest.getTenure();

        // Verify the results
        assertEquals(10, result);
    }

    @Test
    void testGetPrinciple() {
        // Setup

        // Run the test
        final int result = loanUnderTest.getPrinciple();

        // Verify the results
        assertEquals(100, result);
    }

    @Test
    void testGetRateOfInterest() {
        // Setup

        // Run the test
        final int result = loanUnderTest.getRateOfInterest();

        // Verify the results
        assertEquals(2, result);
    }

    @Test
    void testGetBankName() {
        // Setup

        // Run the test
        final String result = loanUnderTest.getBankName();

        // Verify the results
        assertEquals("BankName", result);
    }

    @Test
    void testGetPersonName() {
        // Setup

        // Run the test
        final String result = loanUnderTest.getPersonName();

        // Verify the results
        assertEquals("PersonName", result);
    }

    @Test
    void testGetLumpSumMap() {
        // Setup
        final Map<Integer, Integer> expectedResult = new HashMap<>();

        // Run the test
        final Map<Integer, Integer> result = loanUnderTest.getLumpSumMap();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testPutLumpSumData() {

        // Run the test
        loanUnderTest.putLumpSumData(0, 0);

    }
}
