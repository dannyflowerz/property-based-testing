package io.github.dannyflowerz;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

final class IncomeProviderUtil {
    static Stream<Income> lessThan20IncomeProvider() {
        Income extreme1 = Income.builder().loanerIncome(19999).partnerIncome(0).build();
        Income extreme2 = Income.builder().loanerIncome(0).partnerIncome(19999).build(); // easy to add a new test case
        Stream<Income> incomeStream = IntStream.range(0, 100).mapToObj(i -> {
            int loanerIncome = ThreadLocalRandom.current().nextInt(20000);
            int partnerBound = 19999 - loanerIncome;
            int partnerIncome = ThreadLocalRandom.current().nextInt(partnerBound);
            return Income.builder().loanerIncome(loanerIncome).partnerIncome(partnerIncome).build();
        });
        return Stream.concat(Stream.of(extreme1, extreme2), incomeStream);
    }

    static Stream<Income> between20And30IncomeProvider() {
        Income extreme1 = Income.builder().loanerIncome(20000).partnerIncome(0).build();
        Income extreme2 = Income.builder().loanerIncome(0).partnerIncome(20000).build(); // easy to add a new test case
        Income extreme3 = Income.builder().loanerIncome(29999).partnerIncome(0).build();
        Income extreme4 = Income.builder().loanerIncome(0).partnerIncome(29999).build(); // easy to add a new test case
        Stream<Income> incomeStream = IntStream.range(0, 100).mapToObj(i -> {
            int loanerIncome = ThreadLocalRandom.current().nextInt(30000);
            int partnerOrigin = 20000 - loanerIncome;
            int partnerBound = 29999 - loanerIncome;
            int partnerIncome = ThreadLocalRandom.current().nextInt(partnerOrigin, partnerBound);
            return Income.builder().loanerIncome(loanerIncome).partnerIncome(partnerIncome).build();
        });
        return Stream.concat(Stream.of(extreme1, extreme2, extreme3, extreme4), incomeStream);
    }

    static Stream<Income> between30And60IncomeProvider() {
        Income extreme1 = Income.builder().loanerIncome(30000).partnerIncome(0).build();
        Income extreme2 = Income.builder().loanerIncome(0).partnerIncome(30000).build(); // easy to add a new test case
        Income extreme3 = Income.builder().loanerIncome(59999).partnerIncome(0).build();
        Income extreme4 = Income.builder().loanerIncome(0).partnerIncome(59999).build(); // easy to add a new test case
        Stream<Income> incomeStream = IntStream.range(0, 100).mapToObj(i -> {
            int loanerIncome = ThreadLocalRandom.current().nextInt(60000);
            int partnerOrigin = 30000 - loanerIncome;
            int partnerBound = 59999 - loanerIncome;
            int partnerIncome = ThreadLocalRandom.current().nextInt(partnerOrigin, partnerBound);
            return Income.builder().loanerIncome(loanerIncome).partnerIncome(partnerIncome).build();
        });
        return Stream.concat(Stream.of(extreme1, extreme2, extreme3, extreme4), incomeStream);
    }

    static Stream<Income> between60And90IncomeProvider() {
        Income extreme1 = Income.builder().loanerIncome(60000).partnerIncome(0).build();
        Income extreme2 = Income.builder().loanerIncome(0).partnerIncome(60000).build(); // easy to add a new test case
        Income extreme3 = Income.builder().loanerIncome(89999).partnerIncome(0).build();
        Income extreme4 = Income.builder().loanerIncome(0).partnerIncome(89999).build(); // easy to add a new test case
        Stream<Income> incomeStream = IntStream.range(0, 100).mapToObj(i -> {
            int loanerIncome = ThreadLocalRandom.current().nextInt(90000);
            int partnerOrigin = 60000 - loanerIncome;
            int partnerBound = 89999 - loanerIncome;
            int partnerIncome = ThreadLocalRandom.current().nextInt(partnerOrigin, partnerBound);
            return Income.builder().loanerIncome(loanerIncome).partnerIncome(partnerIncome).build();
        });
        return Stream.concat(Stream.of(extreme1, extreme2, extreme3, extreme4), incomeStream);
    }

    static Stream<Income> between90And120IncomeProvider() {
        Income extreme1 = Income.builder().loanerIncome(90000).partnerIncome(0).build();
        Income extreme2 = Income.builder().loanerIncome(0).partnerIncome(90000).build(); // easy to add a new test case
        Income extreme3 = Income.builder().loanerIncome(119999).partnerIncome(0).build();
        Income extreme4 = Income.builder().loanerIncome(0).partnerIncome(119999).build(); // easy to add a new test case
        Stream<Income> incomeStream = IntStream.range(0, 100).mapToObj(i -> {
            int loanerIncome = ThreadLocalRandom.current().nextInt(120000);
            int partnerOrigin = 90000 - loanerIncome;
            int partnerBound = 119999 - loanerIncome;
            int partnerIncome = ThreadLocalRandom.current().nextInt(partnerOrigin, partnerBound);
            return Income.builder().loanerIncome(loanerIncome).partnerIncome(partnerIncome).build();
        });
        return Stream.concat(Stream.of(extreme1, extreme2, extreme3, extreme4), incomeStream);
    }

    static Stream<Income> moreThan120IncomeProvider() {
        Income extreme1 = Income.builder().loanerIncome(120000).partnerIncome(0).build();
        Income extreme2 = Income.builder().loanerIncome(0).partnerIncome(120000).build(); // easy to add a new test case
        Stream<Income> incomeStream = IntStream.range(0, 100).mapToObj(i -> {
            int loanerIncome = ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE);
            int partnerOrigin = 120000 - loanerIncome;
            int partnerBound = Integer.MAX_VALUE - loanerIncome + 1;
            int partnerIncome = ThreadLocalRandom.current().nextInt(partnerOrigin, partnerBound);
            return Income.builder().loanerIncome(loanerIncome).partnerIncome(partnerIncome).build();
        });
        return Stream.concat(Stream.of(extreme1, extreme2), incomeStream);
    }

    static Stream<Income> extremeLessThan20IncomeProvider() {
        return IntStream.range(0, 100).mapToObj(i -> {
            int loanerIncome = ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, 20000);
            int partnerBound = loanerIncome > 0 ? 19999 - loanerIncome : 20000; // only need to be careful if it's positive
            int partnerIncome = ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, partnerBound);
            return Income.builder().loanerIncome(loanerIncome).partnerIncome(partnerIncome).build();
        });
    }

    static Stream<Income> extremeMoreThan120IncomeProvider() {
        return IntStream.range(0, 100).mapToObj(i -> {
            int loanerIncome = ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE);
            int partnerOrigin = 120000 - loanerIncome; // just need to make sure it's above 120.000
            int partnerIncome = ThreadLocalRandom.current().nextInt(partnerOrigin, Integer.MAX_VALUE);
            return Income.builder().loanerIncome(loanerIncome).partnerIncome(partnerIncome).build();
        });
    }
}
