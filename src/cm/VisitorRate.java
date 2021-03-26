package cm;

import java.math.BigDecimal;

public class VisitorRate implements ReductionRates {
    @Override
    public BigDecimal cRate(BigDecimal cost) {
        int result = cost.compareTo(BigDecimal.valueOf(8));
        if(result == 1)
        {
            cost = cost.subtract(BigDecimal.valueOf(8));
            return cost = cost.divide(BigDecimal.valueOf(2));
        }
        else
        {
            return BigDecimal.valueOf(0);
        }
    }
}
