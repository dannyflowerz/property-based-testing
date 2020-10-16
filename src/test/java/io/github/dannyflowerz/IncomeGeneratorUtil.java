package io.github.dannyflowerz;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

final class IncomeGeneratorUtil {
    static Stream<Income> lessThan20IncomeGenerator() {
        Income single = Income.builder().loaneeIncome(19999).build();
        Income edge1 = Income.builder().loaneeIncome(19999).partnerIncome(0).build();
        Income edge2 = Income.builder().loaneeIncome(0).partnerIncome(19999).build(); // easy to add new test cases
        Stream<Income> incomeStream = IntStream.range(0, 100).mapToObj(i -> {
            int loanerIncome = ThreadLocalRandom.current().nextInt(20000); // 0 <= random < 20000
            int partnerBound = 19999 - loanerIncome;
            int partnerIncome = ThreadLocalRandom.current().nextInt(partnerBound);
            return Income.builder().loaneeIncome(loanerIncome).partnerIncome(partnerIncome).build();
        });
        return Stream.concat(Stream.of(single, edge1, edge2), incomeStream);
    }

    static Stream<Income> between20And30IncomeGenerator() {
        Income singleEdge1 = Income.builder().loaneeIncome(20000).build();
        Income singleEdge2 = Income.builder().loaneeIncome(29999).build();
        Income edge1 = Income.builder().loaneeIncome(20000).partnerIncome(0).build();
        Income edge2 = Income.builder().loaneeIncome(0).partnerIncome(20000).build();
        Income edge3 = Income.builder().loaneeIncome(29999).partnerIncome(0).build();
        Income edge4 = Income.builder().loaneeIncome(0).partnerIncome(29999).build(); // easy to add new test cases
        Stream<Income> incomeStream = IntStream.range(0, 100).mapToObj(i -> {
            int loanerIncome = ThreadLocalRandom.current().nextInt(30000);
            int partnerOrigin = 20000 - loanerIncome;
            int partnerBound = 29999 - loanerIncome;
            int partnerIncome = ThreadLocalRandom.current().nextInt(partnerOrigin, partnerBound);
            return Income.builder().loaneeIncome(loanerIncome).partnerIncome(partnerIncome).build();
        });
        return Stream.concat(Stream.of(singleEdge1, singleEdge2, edge1, edge2, edge3, edge4), incomeStream);
    }

    static Stream<Income> between30And60IncomeGenerator() {
        Income singleEdge1 = Income.builder().loaneeIncome(30000).build();
        Income singleEdge2 = Income.builder().loaneeIncome(59999).build();
        Income edge1 = Income.builder().loaneeIncome(30000).partnerIncome(0).build();
        Income edge2 = Income.builder().loaneeIncome(0).partnerIncome(30000).build();
        Income edge3 = Income.builder().loaneeIncome(59999).partnerIncome(0).build();
        Income edge4 = Income.builder().loaneeIncome(0).partnerIncome(59999).build(); // easy to add new test cases
        Stream<Income> incomeStream = IntStream.range(0, 100).mapToObj(i -> {
            int loanerIncome = ThreadLocalRandom.current().nextInt(60000);
            int partnerOrigin = 30000 - loanerIncome;
            int partnerBound = 59999 - loanerIncome;
            int partnerIncome = ThreadLocalRandom.current().nextInt(partnerOrigin, partnerBound);
            return Income.builder().loaneeIncome(loanerIncome).partnerIncome(partnerIncome).build();
        });
        return Stream.concat(Stream.of(singleEdge1, singleEdge2, edge1, edge2, edge3, edge4), incomeStream);
    }

    static Stream<Income> between60And90IncomeGenerator() {
        Income singleEdge1 = Income.builder().loaneeIncome(60000).build();
        Income singleEdge2 = Income.builder().loaneeIncome(89999).build();
        Income edge1 = Income.builder().loaneeIncome(60000).partnerIncome(0).build();
        Income edge2 = Income.builder().loaneeIncome(0).partnerIncome(60000).build();
        Income edge3 = Income.builder().loaneeIncome(89999).partnerIncome(0).build();
        Income edge4 = Income.builder().loaneeIncome(0).partnerIncome(89999).build(); // easy to add new test cases
        Stream<Income> incomeStream = IntStream.range(0, 100).mapToObj(i -> {
            int loanerIncome = ThreadLocalRandom.current().nextInt(90000);
            int partnerOrigin = 60000 - loanerIncome;
            int partnerBound = 89999 - loanerIncome;
            int partnerIncome = ThreadLocalRandom.current().nextInt(partnerOrigin, partnerBound);
            return Income.builder().loaneeIncome(loanerIncome).partnerIncome(partnerIncome).build();
        });
        return Stream.concat(Stream.of(singleEdge1, singleEdge2, edge1, edge2, edge3, edge4), incomeStream);
    }

    static Stream<Income> between90And120IncomeGenerator() {
        Income singleEdge1 = Income.builder().loaneeIncome(90000).build();
        Income singleEdge2 = Income.builder().loaneeIncome(119999).build();
        Income edge1 = Income.builder().loaneeIncome(90000).partnerIncome(0).build();
        Income edge2 = Income.builder().loaneeIncome(0).partnerIncome(90000).build();
        Income edge3 = Income.builder().loaneeIncome(119999).partnerIncome(0).build();
        Income edge4 = Income.builder().loaneeIncome(0).partnerIncome(119999).build(); // easy to add new test cases
        Stream<Income> incomeStream = IntStream.range(0, 100).mapToObj(i -> {
            int loanerIncome = ThreadLocalRandom.current().nextInt(120000);
            int partnerOrigin = 90000 - loanerIncome;
            int partnerBound = 119999 - loanerIncome;
            int partnerIncome = ThreadLocalRandom.current().nextInt(partnerOrigin, partnerBound);
            return Income.builder().loaneeIncome(loanerIncome).partnerIncome(partnerIncome).build();
        });
        return Stream.concat(Stream.of(singleEdge1, singleEdge2, edge1, edge2, edge3, edge4), incomeStream);
    }

    static Stream<Income> moreThan120IncomeGenerator() {
        Income single = Income.builder().loaneeIncome(120000).build();
        Income edge1 = Income.builder().loaneeIncome(120000).partnerIncome(0).build();
        Income edge2 = Income.builder().loaneeIncome(0).partnerIncome(120000).build(); // easy to add new test cases
        Stream<Income> incomeStream = IntStream.range(0, 100).mapToObj(i -> {
            int loanerIncome = ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE);
            int partnerOrigin = 120000 - loanerIncome;
            int partnerBound = Integer.MAX_VALUE - loanerIncome + 1;
            int partnerIncome = ThreadLocalRandom.current().nextInt(partnerOrigin, partnerBound);
            return Income.builder().loaneeIncome(loanerIncome).partnerIncome(partnerIncome).build();
        });
        return Stream.concat(Stream.of(single, edge1, edge2), incomeStream);
    }

    static Stream<Income> extremeLessThan20IncomeGenerator() {
        return IntStream.range(0, 100).mapToObj(i -> {
            int loanerIncome = ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, 20000);
            int partnerBound = loanerIncome > 0 ? 19999 - loanerIncome : 20000; // only need to be careful if it's positive
            int partnerIncome = ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, partnerBound);
            return Income.builder().loaneeIncome(loanerIncome).partnerIncome(partnerIncome).build();
        });
    }

    static Stream<Income> extremeMoreThan120IncomeGenerator() {
        return IntStream.range(0, 100).mapToObj(i -> {
            int loanerIncome = ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE);
            int partnerOrigin = 120000 - loanerIncome; // just need to make sure it's above 120.000
            int partnerIncome = ThreadLocalRandom.current().nextInt(partnerOrigin, Integer.MAX_VALUE);
            return Income.builder().loaneeIncome(loanerIncome).partnerIncome(partnerIncome).build();
        });
    }
}
