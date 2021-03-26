package cm;

import java.math.BigDecimal;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class HalpinAlanRateTestTask2 {
     /* Task One Black Box Tests */
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

    /*  Task Two White Box Tests  */
    // Testing calculate() test changed to support new specification
    @Test
    public void testCase14()
    {
        Rate r;
        CarParkKind x = CarParkKind.STAFF;

        BigDecimal normalRate = new BigDecimal(4);
        BigDecimal reducedRate = new BigDecimal(2);

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        Period normalPeriod1 = new Period(10,18);

        reducedPeriods.add(normalPeriod1);

        r = new Rate(x, normalRate, reducedRate, normalPeriods, reducedPeriods);
        assertEquals(BigDecimal.valueOf(16), r.calculate(normalPeriod1)); // value should equal 16
    }
    // Test duration() method, expecting 1
    @Test
    public void testCase15()
    {
        Period normalPeriod1 = new Period(5,6);
        assertEquals(1, normalPeriod1.duration());
    }
    // Test free period calculate() expecting 0
    @Test
    public void testCase16()
    {
        Rate r;
        CarParkKind x = CarParkKind.STAFF;

        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        Period freePeriod = new Period(0,7);

        r = new Rate(x, normalRate, reducedRate, normalPeriods, reducedPeriods);
        assertEquals(BigDecimal.valueOf(0), r.calculate(freePeriod)); // value should equal 0
    }
    // Another free period test (period variation)
    @Test
    public void testCase17()
    {
        Rate r;
        CarParkKind x = CarParkKind.STAFF;

        BigDecimal normalRate = new BigDecimal(4);
        BigDecimal reducedRate = new BigDecimal(2);

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        Period normalPeriod1 = new Period(7,13);
        Period normalPeriod2 = new Period(14,18);

        Period reducedPeriod1 = new Period(18,20);
        Period reducedPeriod2 = new Period(20,24);

        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);

        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);

        Period freePeriod = new Period(0,6);

        r = new Rate(x, normalRate, reducedRate, reducedPeriods, normalPeriods);
        assertEquals(BigDecimal.valueOf(0), r.calculate(freePeriod)); // Value should equal 0
    }
    // Calculate() reduced period test (bug)
    @Test
    public void testCase18()
    {
        Rate r;
        CarParkKind x = CarParkKind.STAFF;

        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        Period normalPeriod1 = new Period(7,13);
        Period normalPeriod2 = new Period(14,18);

        Period reducedPeriod1 = new Period(18,20);
        Period reducedPeriod2 = new Period(20,24);

        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);

        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);

        r = new Rate(x, normalRate, reducedRate,reducedPeriods, normalPeriods);
        assertEquals(BigDecimal.valueOf(4), r.calculate(reducedPeriod2)); // Value should equal 4
    }
    // Calculate() normal period test
    @Test
    public void testCase19()
    {
        Rate r;
        CarParkKind x = CarParkKind.STAFF;

        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        Period normalPeriod1 = new Period(7,13);
        Period normalPeriod2 = new Period(14,18);

        Period reducedPeriod1 = new Period(18,20);
        Period reducedPeriod2 = new Period(20,24);

        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);

        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);

        r = new Rate(x, normalRate, reducedRate,reducedPeriods, normalPeriods);
        assertEquals(BigDecimal.valueOf(12), r.calculate(normalPeriod1)); // Value should equal 12
    }
    // Occurances() test normalperiod
    @Test
    public void testCase20()
    {
        Rate r;
        CarParkKind x = CarParkKind.STAFF;

        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        Period normalPeriod1 = new Period(7,13);
        Period normalPeriod2 = new Period(14,18);

        Period reducedPeriod1 = new Period(18,20);
        Period reducedPeriod2 = new Period(20,24);

        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);

        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);

        r = new Rate(x, normalRate, reducedRate, normalPeriods, reducedPeriods);
        assertEquals(6, normalPeriod1.occurences(normalPeriods)); // Value should equal 6
    }
    // Occurances() test reducedPeriod
    @Test
    public void testCase21()
    {
        Rate r;
        CarParkKind x = CarParkKind.STAFF;

        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        Period normalPeriod1 = new Period(7,13);
        Period normalPeriod2 = new Period(14,18);

        Period reducedPeriod1 = new Period(18,20);
        Period reducedPeriod2 = new Period(20,24);

        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);

        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);

        r = new Rate(x, normalRate, reducedRate, normalPeriods, reducedPeriods);
        assertEquals(4, reducedPeriod2.occurences(reducedPeriods)); // Value should equal 6
    }
    // overlaps() test false reducedPeriods
    @Test
    public void testCase22()
    {
        Period reducedPeriod1 = new Period(18,20);
        Period reducedPeriod2 = new Period(20,24);

        assertEquals(false, reducedPeriod2.overlaps(reducedPeriod1)); // Value should be false
    }
    // overlaps() test true normalPeriods
    @Test
    public void testCase23()
    {
        Period normalPeriod1 = new Period(7,13);
        Period normalPeriod2 = new Period(12,18);

        assertEquals(true, normalPeriod1.overlaps(normalPeriod2)); // Value should be false
    }
    // overlaps() test true normalPeriod / reducedPeriod
    @Test
    public void testCase24()
    {
        Period normalPeriod1 = new Period(7,13);
        Period reducedPeriod1 = new Period(12,18);

        assertEquals(true, normalPeriod1.overlaps(reducedPeriod1)); // Value should be true
    }
    // overlaps() test true reducedPeriod / normalPeriod
    @Test
    public void testCase25()
    {
        Period normalPeriod1 = new Period(15,19);
        Period reducedPeriod1 = new Period(17,24);

        assertEquals(true, reducedPeriod1.overlaps(normalPeriod1)); // Value should be true
    }
    // overlaps() test false normalPeriod / reducedPeriod
    @Test
    public void testCase26()
    {
        Period normalPeriod1 = new Period(7,13);
        Period reducedPeriod1 = new Period(13,18);

        assertEquals(false, normalPeriod1.overlaps(reducedPeriod1)); // Value should be false
    }
    // overlaps() test false reducedPeriod / normalPeriod
    @Test
    public void testCase27()
    {
        Period normalPeriod1 = new Period(15,19);
        Period reducedPeriod1 = new Period(19,24);

        assertEquals(false, reducedPeriod1.overlaps(normalPeriod1)); // Value should be false
    }
    // 100% branch coverage
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testCase28() throws IllegalArgumentException
    {
        Rate r;
        CarParkKind x = CarParkKind.STAFF;

        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        Period normalPeriod1 = new Period(7,13);
        Period normalPeriod2 = new Period(14,24);

        Period normalPeriod3 = new Period(18,20);
        Period normalPeriod4 = new Period(20,24);

        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);
        normalPeriods.add(normalPeriod3);
        normalPeriods.add(normalPeriod4);

        r = new Rate(x, normalRate, reducedRate, normalPeriods, reducedPeriods);
    }
    // TDD Tests
    // Acceptance Tests (Once these tests pass, functionality will be complete)
    // VISITOR first 8 free, rest is 50% off
    @Test
    public void testCase29()
    {
        Rate r;
        CarParkKind x = CarParkKind.VISITOR;

        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        Period normalPeriod1 = new Period(8,16);

        normalPeriods.add(normalPeriod1);

        r = new Rate(x, normalRate, reducedRate,reducedPeriods, normalPeriods);
        assertEquals(BigDecimal.valueOf(4), r.calculate(normalPeriod1)); // Value should equal 4
    }
    // VISITOR first 8 free, rest is 50% off
    @Test
    public void testCase30()
    {
        Rate r;
        CarParkKind x = CarParkKind.VISITOR;

        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        Period normalPeriod1 = new Period(8,11);

        normalPeriods.add(normalPeriod1);

        r = new Rate(x, normalRate, reducedRate,reducedPeriods, normalPeriods);
        assertEquals(BigDecimal.valueOf(0), r.calculate(normalPeriod1)); // Value should equal 0
    }
    // For staff, max payable is 16
    @Test
    public void testCase31()
    {
        Rate r;
        CarParkKind x = CarParkKind.STAFF;

        BigDecimal normalRate = new BigDecimal(4);
        BigDecimal reducedRate = new BigDecimal(1);

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        Period normalPeriod1 = new Period(8,13);

        normalPeriods.add(normalPeriod1);

        r = new Rate(x, normalRate, reducedRate,reducedPeriods, normalPeriods);
        assertEquals(BigDecimal.valueOf(16), r.calculate(normalPeriod1)); // Value should equal 16
    }
    // For staff, max payable is 16
    @Test(expected = AssertionError.class)
    public void testCase32()
    {
        Rate r;
        CarParkKind x = CarParkKind.STAFF;

        BigDecimal normalRate = new BigDecimal(4);
        BigDecimal reducedRate = new BigDecimal(1);

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        Period normalPeriod1 = new Period(8,14);

        normalPeriods.add(normalPeriod1);

        r = new Rate(x, normalRate, reducedRate,reducedPeriods, normalPeriods);
        assertEquals(BigDecimal.valueOf(24), r.calculate(normalPeriod1)); // Value should equal 16 so expect test fail
    }
    /*
    // Management minimum payable 3
    @Test
    public void testCase31()
    {
        Rate r;
        CarParkKind x = CarParkKind.MANAGEMENT;

        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        Period normalPeriod1 = new Period(8,9);

        normalPeriods.add(normalPeriod1);

        r = new Rate(x, normalRate, reducedRate,reducedPeriods, normalPeriods);
        assertEquals(BigDecimal.valueOf(3), r.calculate(normalPeriod1)); // Value should equal 3
    }
    // STUDENT 25% discount after 5.50
    @Test
    public void testCase32()
    {
        Rate r;
        CarParkKind x = CarParkKind.STUDENT;

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(1);

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        Period normalPeriod1 = new Period(8,10);

        normalPeriods.add(normalPeriod1);

        r = new Rate(x, normalRate, reducedRate,reducedPeriods, normalPeriods);
        assertEquals(BigDecimal.valueOf(7.75), r.calculate(normalPeriod1)); // Value should equal 7.75
    } */
}