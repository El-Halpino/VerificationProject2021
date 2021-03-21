
package cm;

import java.math.BigDecimal;
import java.util.ArrayList;

public class HalpinAlanRateTestTask1 {
    // Invalid Rates (Negative)
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testCase1() throws IllegalArgumentException {
        Rate r;

        CarParkKind x = CarParkKind.STAFF;

        BigDecimal normalRate = new BigDecimal(-5);
        BigDecimal reducedRate = new BigDecimal(-6);

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        Period normalPeriod1 = new Period(5,6);
        Period normalPeriod2 = new Period(1,4);
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);

        Period reducedPeriod1 = new Period(7,9);
        Period reducedPeriod2 = new Period(10,15);
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);

        r = new Rate(x, normalRate, reducedRate, normalPeriods, reducedPeriods);
    }
    // Invalid Reduced rate (Negative)
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testCase2() throws IllegalArgumentException {
        Rate r;

        CarParkKind x = CarParkKind.STAFF;

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(-6);

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        Period normalPeriod1 = new Period(5,6);
        Period normalPeriod2 = new Period(1,4);
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);

        Period reducedPeriod1 = new Period(7,9);
        Period reducedPeriod2 = new Period(10,15);
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);

        r = new Rate(x, normalRate, reducedRate, normalPeriods, reducedPeriods);
    }

    // Null Normal Periods
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testCase3() {
        Rate r;

        CarParkKind x = CarParkKind.STAFF;

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(6);

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        Period reducedPeriod1 = new Period(7,9);
        Period reducedPeriod2 = new Period(10,15);
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);

        normalPeriods = null;

        r = new Rate(x, normalRate, reducedRate, normalPeriods, reducedPeriods);
    }
    // Null Reduced Periods
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testCase4() throws IllegalArgumentException {
        Rate r;

        CarParkKind x = CarParkKind.STAFF;

        BigDecimal normalRate = new BigDecimal(9);
        BigDecimal reducedRate = new BigDecimal(10);

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        Period normalPeriod1 = new Period(7,9);
        Period normalPeriod2 = new Period(12,18);
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);

        reducedPeriods = null;

        r = new Rate(x, normalRate, reducedRate, normalPeriods, reducedPeriods);
    }
    // Invalid Normal Rate(normalRate < reducedRate)
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testCase5() throws IllegalArgumentException {
        Rate r;

        CarParkKind x = CarParkKind.STAFF;

        BigDecimal normalRate = new BigDecimal(8);
        BigDecimal reducedRate = new BigDecimal(9);

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        Period normalPeriod1 = new Period(5,6);
        Period normalPeriod2 = new Period(1,4);
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);

        Period reducedPeriod1 = new Period(7,9);
        Period reducedPeriod2 = new Period(10,15);
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);

        r = new Rate(x, normalRate, reducedRate, normalPeriods, reducedPeriods);
    }

    // Invalid Normal Rate (NULL)
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testCase6() throws IllegalArgumentException {
        Rate r;

        CarParkKind x = CarParkKind.STAFF;

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(3);

        normalRate = null;

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        Period normalPeriod1 = new Period(5,6);
        Period normalPeriod2 = new Period(1,4);
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);

        Period reducedPeriod1 = new Period(7,9);
        Period reducedPeriod2 = new Period(10,15);
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);

        r = new Rate(x, normalRate, reducedRate, normalPeriods, reducedPeriods);
    }

    // Invalid reduced Rate (NULL)
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testCase7() throws IllegalArgumentException {
        Rate r;

        CarParkKind x = CarParkKind.STAFF;

        BigDecimal normalRate = new BigDecimal(1);
        BigDecimal reducedRate = new BigDecimal(0);

        reducedRate = null;

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        Period normalPeriod1 = new Period(5,6);
        Period normalPeriod2 = new Period(1,4);
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);

        Period reducedPeriod1 = new Period(7,9);
        Period reducedPeriod2 = new Period(10,15);
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);

        r = new Rate(x, normalRate, reducedRate, normalPeriods, reducedPeriods);
    }

    // Reduced and Normal Periods cannot be equal
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testCase8() throws IllegalArgumentException {
        Rate r;

        CarParkKind x = CarParkKind.STAFF;

        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        Period normalPeriod1 = new Period(5,6);
        Period normalPeriod2 = new Period(1,4);
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);

        Period reducedPeriod1 = new Period(5,6);
        Period reducedPeriod2 = new Period(1,4);
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);

        reducedPeriods = normalPeriods;

        r = new Rate(x, normalRate, reducedRate, normalPeriods, reducedPeriods);
    }
    //Invalid Start time
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testCase9() throws IllegalArgumentException {
        Rate r;

        CarParkKind x = CarParkKind.STAFF;

        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        Period normalPeriod1 = new Period(26,6);
        normalPeriods.add(normalPeriod1);

        Period reducedPeriod1 = new Period(1,9);
        reducedPeriods.add(reducedPeriod1);

        r = new Rate(x, normalRate, reducedRate, normalPeriods, reducedPeriods);
    }

    //Invalid End time
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testCase10() throws IllegalArgumentException {
        Rate r;

        CarParkKind x = CarParkKind.STAFF;

        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        Period normalPeriod1 = new Period(6,26);
        normalPeriods.add(normalPeriod1);

        Period reducedPeriod1 = new Period(1,9);
        reducedPeriods.add(reducedPeriod1);

        r = new Rate(x, normalRate, reducedRate, normalPeriods, reducedPeriods);
    }
    //Overlapping periods
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testCase11() throws IllegalArgumentException {
        Rate r;

        CarParkKind x = CarParkKind.STAFF;

        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        Period normalPeriod1 = new Period(6,10);
        normalPeriods.add(normalPeriod1);

        Period reducedPeriod1 = new Period(9,12);
        reducedPeriods.add(reducedPeriod1);

        r = new Rate(x, normalRate, reducedRate, normalPeriods, reducedPeriods);
    }
    //Overlapping periods (Normal Periods) 2
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testCase12() throws IllegalArgumentException {
        Rate r;

        CarParkKind x = CarParkKind.STAFF;

        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        Period normalPeriod1 = new Period(6,10);
        Period normalPeriod2 = new Period(8,12);
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);

        Period reducedPeriod1 = new Period(9,12);
        Period reducedPeriod2 = new Period(14,16);
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);

        r = new Rate(x, normalRate, reducedRate, normalPeriods, reducedPeriods);
    }
    //Overlapping periods (Reduced Periods) 2
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testCase13() throws IllegalArgumentException {
        Rate r;

        CarParkKind x = CarParkKind.STAFF;

        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        Period normalPeriod1 = new Period(6,10);
        Period normalPeriod2 = new Period(11,12);
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);

        Period reducedPeriod1 = new Period(13,15);
        Period reducedPeriod2 = new Period(14,16);
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);

        r = new Rate(x, normalRate, reducedRate, normalPeriods, reducedPeriods);
    }
}