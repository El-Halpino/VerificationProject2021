package cm;

import java.math.BigDecimal;

public class StaffRate implements ReductionRates {
    @Override
    public BigDecimal cRate(BigDecimal cost) {
        int result = cost.compareTo(BigDecimal.valueOf(16));
        if(result == 1)
        {
            return BigDecimal.valueOf(16);
        }
        else
        {
            return cost;
        }
    }
}
