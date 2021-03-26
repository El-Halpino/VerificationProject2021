package cm;

import java.math.BigDecimal;

public class StudentRate implements ReductionRates {
    @Override
    public BigDecimal cRate(BigDecimal cost) {
        BigDecimal discount;
        int result = cost.compareTo(BigDecimal.valueOf(5.50));
        if(result == 1)
        {
            discount = cost.subtract(BigDecimal.valueOf(5.50)).divide(BigDecimal.valueOf(4));
            cost = discount.add(BigDecimal.valueOf(5.50));
            return cost;
        }
        else
        {
            return cost;
        }
    }
}
