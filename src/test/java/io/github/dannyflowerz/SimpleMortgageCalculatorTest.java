package io.github.dannyflowerz;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple SimpleMortgageCalculator.
 */
class SimpleMortgageCalculatorTest {
    private final SimpleMortgageCalculator underTest = new SimpleMortgageCalculator();

    /***** x < 20.000 *****/
    @Test
    @DisplayName("Should throw TooLowIncomeException when yearly income of a single loaner is less than 20.000")
    void lessThan20kSingle() {
        // given
        Income income = Income.builder().loanerIncome(19999).build();
        // when - then
        assertThrows(TooLowIncomeException.class, () -> underTest.calculateMortgage(income));
    }

    @Test
    @DisplayName("Should throw TooLowIncomeException when yearly income of loaner and partner is less than 20.000")
    void lessThan20kPartner() {
        // given
        Income income = Income.builder().loanerIncome(14999).partnerIncome(5000).build();
        // when - then
        assertThrows(TooLowIncomeException.class, () -> underTest.calculateMortgage(income));
    }
    /***** x < 20.000 *****/

    /***** 20.000 <= x < 30.000 *****/
    @Test
    @DisplayName("Should calculate 3.5 times yearly income for a single loaner when income is 20.000")
    void exactly20kSingle() {
        // given
        Income income = Income.builder().loanerIncome(20000).build();
        // when - then
        assertEquals(3.5 * (income.getLoanerIncome() + income.getPartnerIncome()), underTest.calculateMortgage(income));
    }

    @Test
    @DisplayName("Should calculate 3.5 times yearly income for a loaner and partner when combined income is 20.000")
    void exactly20kPartner() {
        // given
        Income income = Income.builder().loanerIncome(15000).partnerIncome(5000).build();
        // when - then
        assertEquals(3.5 * (income.getLoanerIncome() + income.getPartnerIncome()), underTest.calculateMortgage(income));
    }

    @Test
    @DisplayName("Should calculate 3.5 times yearly income for a single loaner when income is 29.999")
    void lessThan30kSingle() {
        // given
        Income income = Income.builder().loanerIncome(29999).build();
        // when - then
        assertEquals(3.5 * (income.getLoanerIncome() + income.getPartnerIncome()), underTest.calculateMortgage(income));
    }

    @Test
    @DisplayName("Should calculate 3.5 times yearly income for a loaner and partner when combined income is 29.999")
    void lessThan30kPartner() {
        // given
        Income income = Income.builder().loanerIncome(24999).partnerIncome(5000).build();
        // when - then
        assertEquals(3.5 * (income.getLoanerIncome() + income.getPartnerIncome()), underTest.calculateMortgage(income));
    }
    /***** 20.000 <= x < 30.000 *****/

    /***** 30.000 <= x < 60.000 *****/
    @Test
    @DisplayName("Should calculate 4.4 times yearly income for a single loaner when income is 30.000")
    void exactly30kSingle() {
        // given
        Income income = Income.builder().loanerIncome(30000).build();
        // when - then
        assertEquals(4.4 * (income.getLoanerIncome() + income.getPartnerIncome()), underTest.calculateMortgage(income));
    }

    @Test
    @DisplayName("Should calculate 4.4 times yearly income for a loaner and partner when combined income is 30.000")
    void exactly30kPartner() {
        // given
        Income income = Income.builder().loanerIncome(25000).partnerIncome(5000).build();
        // when - then
        assertEquals(4.4 * (income.getLoanerIncome() + income.getPartnerIncome()), underTest.calculateMortgage(income));
    }

    @Test
    @DisplayName("Should calculate 4.4 times yearly income for a single loaner when income is 59.999")
    void lessThan60kSingle() {
        // given
        Income income = Income.builder().loanerIncome(59999).build();
        // when - then
        assertEquals(4.4 * (income.getLoanerIncome() + income.getPartnerIncome()), underTest.calculateMortgage(income));
    }

    @Test
    @DisplayName("Should calculate 4.4 times yearly income for a loaner and partner when combined income is 59.999")
    void lessThan60kPartner() {
        // given
        Income income = Income.builder().loanerIncome(54999).partnerIncome(5000).build();
        // when - then
        assertEquals(4.4 * (income.getLoanerIncome() + income.getPartnerIncome()), underTest.calculateMortgage(income));
    }
    /***** 30.000 <= x < 60.000 *****/

    /***** 60.000 <= x < 90.000 *****/
    @Test
    @DisplayName("Should calculate 4.6 times yearly income for a single loaner when income is 60.000")
    void exactly60kSingle() {
        // given
        Income income = Income.builder().loanerIncome(60000).build();
        // when - then
        assertEquals(4.6 * (income.getLoanerIncome() + income.getPartnerIncome()), underTest.calculateMortgage(income));
    }

    @Test
    @DisplayName("Should calculate 4.6 times yearly income for a loaner and partner when combined income is 60.000")
    void exactly60kPartner() {
        // given
        Income income = Income.builder().loanerIncome(55000).partnerIncome(5000).build();
        // when - then
        assertEquals(4.6 * (income.getLoanerIncome() + income.getPartnerIncome()), underTest.calculateMortgage(income));
    }

    @Test
    @DisplayName("Should calculate 4.6 times yearly income for a single loaner when income is 89.999")
    void lessThan90kSingle() {
        // given
        Income income = Income.builder().loanerIncome(89999).build();
        // when - then
        assertEquals(4.6 * (income.getLoanerIncome() + income.getPartnerIncome()), underTest.calculateMortgage(income));
    }

    @Test
    @DisplayName("Should calculate 4.6 times yearly income for a loaner and partner when combined income is 89.999")
    void lessThan90kPartner() {
        // given
        Income income = Income.builder().loanerIncome(84999).partnerIncome(5000).build();
        // when - then
        assertEquals(4.6 * (income.getLoanerIncome() + income.getPartnerIncome()), underTest.calculateMortgage(income));
    }
    /***** 60.000 <= x < 90.000 *****/

    /***** 90.000 <= x < 120.000 *****/
    @Test
    @DisplayName("Should calculate 4.8 times yearly income for a single loaner when income is 90.000")
    void exactly90kSingle() {
        // given
        Income income = Income.builder().loanerIncome(90000).build();
        // when - then
        assertEquals(4.8 * (income.getLoanerIncome() + income.getPartnerIncome()), underTest.calculateMortgage(income));
    }

    @Test
    @DisplayName("Should calculate 4.8 times yearly income for a loaner and partner when combined income is 90.000")
    void exactly90kPartner() {
        // given
        Income income = Income.builder().loanerIncome(85000).partnerIncome(5000).build();
        // when - then
        assertEquals(4.8 * (income.getLoanerIncome() + income.getPartnerIncome()), underTest.calculateMortgage(income));
    }

    @Test
    @DisplayName("Should calculate 4.8 times yearly income for a single loaner when income is 119.999")
    void lessThan120kSingle() {
        // given
        Income income = Income.builder().loanerIncome(119999).build();
        // when - then
        assertEquals(4.8 * (income.getLoanerIncome() + income.getPartnerIncome()), underTest.calculateMortgage(income));
    }

    @Test
    @DisplayName("Should calculate 4.8 times yearly income for a loaner and partner when combined income is 119.999")
    void lessThan120kPartner() {
        // given
        Income income = Income.builder().loanerIncome(114999).partnerIncome(5000).build();
        // when - then
        assertEquals(4.8 * (income.getLoanerIncome() + income.getPartnerIncome()), underTest.calculateMortgage(income));
    }
    /***** 90.000 <= x < 120.000 *****/

    /***** x > 120.000 *****/
     @Test
     @DisplayName("Should calculate 5.0 times yearly income for a single loaner when income is 120.000")
     void exactly120kSingle() {
         // given
         Income income = Income.builder().loanerIncome(120000).build();
         // when - then
         assertEquals(5.0 * (income.getLoanerIncome() + income.getPartnerIncome()), underTest.calculateMortgage(income));
     }

     @Test
     @DisplayName("Should calculate 5.0 times yearly income for a loaner and partner when combined income is 120.000")
     void exactly120kPartner() {
         // given
         Income income = Income.builder().loanerIncome(115000).partnerIncome(5000).build();
         // when - then
         assertEquals(5.0 * (income.getLoanerIncome() + income.getPartnerIncome()), underTest.calculateMortgage(income));
     }
     /***** x > 120.000 *****/
}
