package io.github.dannyflowerz;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple SimpleMortgageCalculator.
 */
class SimpleMortgageCalculatorAdvancedTest {
    private SimpleMortgageCalculator underTest = new SimpleMortgageCalculator();

    @Test
    @DisplayName("Should throw TooLowIncomeException when no yearly income is received")
    void noIncome_maybeYouWouldThinkAboutThis() {
        Income income = Income.builder().build();
        assertThrows(TooLowIncomeException.class, () -> underTest.calculateMortgage(income));
    }

    @Test
    @DisplayName("Should throw TooLowIncomeException when 0 yearly income is received")
    void zeroIncome_maybeYouWouldThinkAboutThis() {
        Income income = Income.builder().loanerIncome(0).partnerIncome(0).build();
        assertThrows(TooLowIncomeException.class, () -> underTest.calculateMortgage(income));
    }

    @Test
    @DisplayName("Should throw TooLowIncomeException when negative yearly income is received")
    void negativeIncome_probablyYouWouldNotThinkAboutThis() {
        Income income = Income.builder().loanerIncome(-10000).partnerIncome(-10000).build();
        assertThrows(TooLowIncomeException.class, () -> underTest.calculateMortgage(income));
    }

    @Test
    @DisplayName("Should throw TooLowIncomeException when negative yearly income is received")
    void negativeOverflowingIncome_probablyYouWouldNotThinkAboutThis() {
        Income income = Income.builder().loanerIncome(Integer.MIN_VALUE).partnerIncome(-1).build();
        assertThrows(TooLowIncomeException.class, () -> underTest.calculateMortgage(income));
    }

    @Test
    @DisplayName("Should calculate 5.0 times yearly income for a loaner and partner when combined income is a very large number")
    void positiveOverflowingIncome_probablyYouWouldNotThinkAboutThis() {
        Income income = Income.builder().loanerIncome(Integer.MAX_VALUE).partnerIncome(1).build();
        assertEquals(5.0 * (income.getLoanerIncome() + income.getPartnerIncome()), underTest.calculateMortgage(income));
    }
}
