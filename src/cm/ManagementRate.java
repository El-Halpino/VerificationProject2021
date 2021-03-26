package cm;

import java.math.BigDecimal;

public class ManagementRate implements ReductionRates {
    @Override
    public BigDecimal cRate(BigDecimal cost) {
        int result = cost.compareTo(BigDecimal.valueOf(3));
        if(result == -1 || result == 0)
        {
            return BigDecimal.valueOf(3);
        }
        else
        {
            return cost;
        }
    }
}