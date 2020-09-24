package io.github.dannyflowerz;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Income {
    private int loanerIncome;
    private int partnerIncome;
}
