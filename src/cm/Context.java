package cm;

import java.math.BigDecimal;

public class Context {
    private ReductionRates reductionRates;

    public Context(ReductionRates reductionRates) {
        this.reductionRates = reductionRates;
    }

    public BigDecimal findReduction(BigDecimal cost){
        return reductionRates.cRate(cost);
    }
}
