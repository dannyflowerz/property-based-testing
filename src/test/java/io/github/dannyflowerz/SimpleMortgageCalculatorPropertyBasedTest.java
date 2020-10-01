package io.github.dannyflowerz;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class SimpleMortgageCalculatorPropertyBasedTest {
    private final SimpleMortgageCalculator underTest = new SimpleMortgageCalculator();

    @Test
    @DisplayName("Should throw TooLowIncomeException when no yearly income is received")
    void noIncome_maybeYouWouldThinkAboutThis() {
        // given
        Income income = Income.builder().build();
        // when - then
        assertThrows(TooLowIncomeException.class, () -> underTest.calculateMortgage(income));
    }

    @ParameterizedTest
    @MethodSource("io.github.dannyflowerz.IncomeProviderUtil#lessThan20IncomeProvider")
    @DisplayName("Should throw TooLowIncomeException when combined yearly income < 20.000")
    void lessThan20k(Income income) {
        // when - then
        assertThrows(TooLowIncomeException.class, () -> underTest.calculateMortgage(income));
    }

    @ParameterizedTest
    @MethodSource("io.github.dannyflowerz.IncomeProviderUtil#between20And30IncomeProvider")
    @DisplayName("Should calculate 3.5 times yearly income for a loaner and partner when 20.000 <= combined income < 30.000")
    void between20And30k(Income income) {
        // when - then
        assertEquals(3.5 * (income.getLoanerIncome() + income.getPartnerIncome()), underTest.calculateMortgage(income));
    }

    @ParameterizedTest
    @MethodSource("io.github.dannyflowerz.IncomeProviderUtil#between30And60IncomeProvider")
    @DisplayName("Should calculate 4.4 times yearly income for a loaner and partner when 30.000 <= combined income < 60.000")
    void between30And60k(Income income) {
        // when - then
        assertEquals(4.4 * (income.getLoanerIncome() + income.getPartnerIncome()), underTest.calculateMortgage(income));
    }

    @ParameterizedTest
    @MethodSource("io.github.dannyflowerz.IncomeProviderUtil#between60And90IncomeProvider")
    @DisplayName("Should calculate 4.6 times yearly income for a loaner and partner when 60.000 <= combined income < 90.000")
    void between60And90k(Income income) {
        // when - then
        assertEquals(4.6 * (income.getLoanerIncome() + income.getPartnerIncome()), underTest.calculateMortgage(income));
    }

    @ParameterizedTest
    @MethodSource("io.github.dannyflowerz.IncomeProviderUtil#between90And120IncomeProvider")
    @DisplayName("Should calculate 4.8 times yearly income for a loaner and partner when 90.000 <= combined income < 120.000")
    void between90And120k(Income income) {
        // when - then
        assertEquals(4.8 * (income.getLoanerIncome() + income.getPartnerIncome()), underTest.calculateMortgage(income));
    }

    @ParameterizedTest
    @MethodSource("io.github.dannyflowerz.IncomeProviderUtil#moreThan120IncomeProvider")
    @DisplayName("Should calculate 5.0 times yearly income for a loaner and partner when combined income > 120.000")
    void moreThan120k(Income income) {
        // when - then
        assertEquals(5.0 * (income.getLoanerIncome() + income.getPartnerIncome()), underTest.calculateMortgage(income));
    }

    /***** Extreme tests *****/
    @Tag("extreme")
    @ParameterizedTest
    @MethodSource("io.github.dannyflowerz.IncomeProviderUtil#extremeLessThan20IncomeProvider")
    @DisplayName("[EXTREME] Should throw TooLowIncomeException when combined yearly income < 20.000")
    void lessThan20kExtreme(Income income) {
        // when - then
        assertThrows(TooLowIncomeException.class, () -> underTest.calculateMortgage(income));
    }

    @Tag("extreme")
    @ParameterizedTest
    @MethodSource("io.github.dannyflowerz.IncomeProviderUtil#extremeMoreThan120IncomeProvider")
    @DisplayName("[EXTREME] Should calculate 5.0 times yearly income for a loaner and partner when combined income > 120.000")
    void moreThan120kExtreme(Income income) {
        // when - then
        assertEquals(5.0 * (income.getLoanerIncome() + income.getPartnerIncome()), underTest.calculateMortgage(income));
    }
    /***** Extreme tests *****/
}
