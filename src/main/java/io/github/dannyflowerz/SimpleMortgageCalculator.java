package io.github.dannyflowerz;

/**
 * Hello world!
 *
 */
public class SimpleMortgageCalculator {
    public double calculateMortgage(Income income) {
        int combinedIncome = income.getLoaneeIncome() + income.getPartnerIncome();
        if (combinedIncome < 20000.0) throw new TooLowIncomeException();
        if (combinedIncome >= 20000 && combinedIncome < 30000) return 3.5 * combinedIncome;
        if (combinedIncome >= 30000 && combinedIncome < 60000) return 4.4 * combinedIncome;
        if (combinedIncome >= 60000 && combinedIncome < 90000) return 4.6 * combinedIncome;
        if (combinedIncome >= 90000 && combinedIncome < 120000) return 4.8 * combinedIncome;
        if (combinedIncome >= 120000) return 5.0 * combinedIncome;
        return 0;
    }
}
