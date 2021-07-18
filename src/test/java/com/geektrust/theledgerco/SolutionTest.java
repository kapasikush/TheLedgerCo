package com.geektrust.theledgerco;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private Solution solutionUnderTest;

    @BeforeEach
    void setUp() {
        solutionUnderTest = new Solution();
    }

    @Test
    void testMain() {

        // Run the test
        Solution.main(new String[]{"value"});

    }
}
