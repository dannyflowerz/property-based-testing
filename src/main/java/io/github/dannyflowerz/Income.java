package io.github.dannyflowerz;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Income {
    private int loaneeIncome;
    private int partnerIncome;
}
