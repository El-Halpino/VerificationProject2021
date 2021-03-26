package cm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Rate {
    private CarParkKind kind;
    private BigDecimal hourlyNormalRate;
    private BigDecimal hourlyReducedRate;
    private ArrayList<Period> reduced = new ArrayList<>();
    private ArrayList<Period> normal = new ArrayList<>();

    public Rate(CarParkKind kind, BigDecimal normalRate, BigDecimal reducedRate, ArrayList<Period> reducedPeriods
            , ArrayList<Period> normalPeriods) {
        if (reducedPeriods == null || normalPeriods == null) {
            throw new IllegalArgumentException("periods cannot be null");
        }
        if (normalRate == null || reducedRate == null) {
            throw new IllegalArgumentException("The rates cannot be null");
        }
        if (normalRate.compareTo(BigDecimal.ZERO) < 0 || reducedRate.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("A rate cannot be negative");
        }
        if (normalRate.compareTo(reducedRate) < 0) {
            throw new IllegalArgumentException("The normal rate cannot be less than the reduced rate");
        }
        if (!isValidPeriods(reducedPeriods) || !isValidPeriods(normalPeriods)) {
            throw new IllegalArgumentException("The periods are not valid individually");
        }
        if (!isValidPeriods(reducedPeriods, normalPeriods)) {
            throw new IllegalArgumentException("The periods overlaps");
        }
        this.kind = kind;
        this.hourlyNormalRate = normalRate;
        this.hourlyReducedRate = reducedRate;
        this.reduced = reducedPeriods;
        this.normal = normalPeriods;
    }

    /**
     * Checks if two collections of periods are valid together
     * @param periods1
     * @param periods2
     * @return true if the two collections of periods are valid together
     */
    private boolean isValidPeriods(ArrayList<Period> periods1, ArrayList<Period> periods2) {
        Boolean isValid = true;
        int i = 0;
        while (i < periods1.size() && isValid) {
            isValid = isValidPeriod(periods1.get(i), periods2);
            i++;
        }
        return isValid;
    }

    /**
     * checks if a collection of periods is valid
     * @param list the collection of periods to check
     * @return true if the periods do not overlap
     */
    private Boolean isValidPeriods(ArrayList<Period> list) {
        Boolean isValid = true;
        if (list.size() >= 2) {
            Period secondPeriod;
            int i = 0;
            int lastIndex = list.size()-1;
            while (i < lastIndex && isValid) {
                isValid = isValidPeriod(list.get(i), ((List<Period>)list).subList(i + 1, lastIndex+1));
                i++;
            }
        }
        return isValid;
    }

    /**
     * checks if a period is a valid addition to a collection of periods
     * @param period the Period addition
     * @param list the collection of periods to check
     * @return true if the period does not overlap in the collecton of periods
     */
    private Boolean isValidPeriod(Period period, List<Period> list) {
        Boolean isValid = true;
        int i = 0;
        while (i < list.size() && isValid) {
            isValid = !period.overlaps(list.get(i));
            i++;
        }
        return isValid;
    }

    // Strategy Pattern interface
    public interface ReductionRates {
        public BigDecimal cRate(BigDecimal normalRateHours, BigDecimal reducedRateHours, BigDecimal normalRate, BigDecimal reducedRate);
    }

    public class Context {
        private ReductionRates reductionRates;

        public Context(ReductionRates reductionRates) {
            this.reductionRates = reductionRates;
        }

        public BigDecimal findReduction(BigDecimal normalRateHours, BigDecimal reducedRateHours, BigDecimal normalRate, BigDecimal reducedRate){
            return reductionRates.cRate(normalRateHours, reducedRateHours, normalRate, reducedRate );
        }
    }

    public class vistorRate implements ReductionRates {
        @Override
        public BigDecimal cRate(BigDecimal normalRateHours, BigDecimal reducedRateHours, BigDecimal normalRate, BigDecimal reducedRate) {
            BigDecimal cost;
            cost = normalRate.multiply(normalRateHours).add(reducedRate.multiply(reducedRateHours));
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
    public class staffRate implements ReductionRates {
        @Override
        public BigDecimal cRate(BigDecimal normalRateHours, BigDecimal reducedRateHours, BigDecimal normalRate, BigDecimal reducedRate) {
            BigDecimal cost;
            cost = normalRate.multiply(normalRateHours).add(reducedRate.multiply(reducedRateHours));
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
    public class managementRate implements ReductionRates {
        @Override
        public BigDecimal cRate(BigDecimal normalRateHours, BigDecimal reducedRateHours, BigDecimal normalRate, BigDecimal reducedRate) {
            BigDecimal cost;
            cost = normalRate.multiply(normalRateHours).add(reducedRate.multiply(reducedRateHours));
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
    public class studentRate implements ReductionRates {
        @Override
        public BigDecimal cRate(BigDecimal normalRateHours, BigDecimal reducedRateHours, BigDecimal normalRate, BigDecimal reducedRate) {
            BigDecimal cost;
            BigDecimal discount;
            cost = normalRate.multiply(normalRateHours).add(reducedRate.multiply(reducedRateHours));
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

    public BigDecimal calculate(Period periodStay) {

        int normalRateHours = periodStay.occurences(normal);
        int reducedRateHours = periodStay.occurences(reduced);
        BigDecimal cost = BigDecimal.valueOf(0);
        switch(this.kind)
        {
            case VISITOR:
                Context contextVisitor = new Context(new vistorRate());
                cost = contextVisitor.findReduction(BigDecimal.valueOf(normalRateHours), BigDecimal.valueOf(reducedRateHours), this.hourlyNormalRate, this.hourlyReducedRate);
                break;
            case STAFF:
                Context contextStaff = new Context(new staffRate());
                cost = contextStaff.findReduction(BigDecimal.valueOf(normalRateHours), BigDecimal.valueOf(reducedRateHours), this.hourlyNormalRate, this.hourlyReducedRate);
                break;
            case MANAGEMENT:
                Context contextManagement = new Context(new managementRate());
                cost = contextManagement.findReduction(BigDecimal.valueOf(normalRateHours), BigDecimal.valueOf(reducedRateHours), this.hourlyNormalRate, this.hourlyReducedRate);
                break;
            case STUDENT:
                Context contextStudent = new Context(new studentRate());
                cost = contextStudent.findReduction(BigDecimal.valueOf(normalRateHours), BigDecimal.valueOf(reducedRateHours), this.hourlyNormalRate, this.hourlyReducedRate);
                break;
            default:
                break;
        }
        return cost;
    }
}
