package io.github.dannyflowerz;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple SimpleMortgageCalculator.
 */
class SimpleMortgageCalculatorAdvancedTest {
    private final SimpleMortgageCalculator underTest = new SimpleMortgageCalculator();

    @Test
    @DisplayName("Should throw TooLowIncomeException when no yearly income is received")
    void noIncome_maybeYouWouldThinkAboutThis() {
        // given
        Income income = Income.builder().build();

        // when - then
        assertThrows(TooLowIncomeException.class, () -> underTest.calculateMortgage(income));
    }

    @Test
    @DisplayName("Should throw TooLowIncomeException when 0 yearly income is received")
    void zeroIncome_maybeYouWouldThinkAboutThis() {
        // given
        Income income = Income.builder()
                .loaneeIncome(0)
                .partnerIncome(0)
                .build();

        // when - then
        assertThrows(TooLowIncomeException.class, () -> underTest.calculateMortgage(income));
    }

    @Test
    @DisplayName("Should throw TooLowIncomeException when negative yearly income is received")
    void negativeIncome_probablyYouWouldNotThinkAboutThis() {
        // given
        Income income = Income.builder()
                .loaneeIncome(-10000)
                .partnerIncome(-10000)
                .build();

        // when - then
        assertThrows(TooLowIncomeException.class, () -> underTest.calculateMortgage(income));
    }

    @Test
    @DisplayName("Should throw TooLowIncomeException when negative yearly income is received")
    void negativeOverflowingIncome_probablyYouWouldNotThinkAboutThis() {
        // given
        Income income = Income.builder()
                .loaneeIncome(Integer.MIN_VALUE)
                .partnerIncome(-1)
                .build();

        // when - then
        assertThrows(TooLowIncomeException.class, () -> underTest.calculateMortgage(income));
    }

    @Test
    @DisplayName("Should calculate 5.0 times yearly income for a loaner and partner when combined income is a very large number")
    void positiveOverflowingIncome_probablyYouWouldNotThinkAboutThis() {
        // given
        Income income = Income.builder()
                .loaneeIncome(Integer.MAX_VALUE)
                .partnerIncome(1)
                .build();

        // when - then
        assertEquals(5.0 * (income.getLoaneeIncome() + income.getPartnerIncome()), underTest.calculateMortgage(income));
    }
}
