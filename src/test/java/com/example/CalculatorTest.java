package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(15, calculator.calculate(10, 5, "add"));
        assertEquals(0, calculator.calculate(-5, 5, "add"));
        assertEquals(-5, calculator.calculate(-10, 5, "add"));
        assertEquals(5, calculator.calculate(0, 5, "add"));
    }

    @Test
    public void testSub() {
        assertEquals(5, calculator.calculate(10, 5, "sub"));
        assertEquals(-10, calculator.calculate(0, 10, "sub"));
        assertEquals(0, calculator.calculate(5, 5, "sub"));
        assertEquals(20, calculator.calculate(10, -10, "sub"));
    }

    @Test
    public void testMul() {
        assertEquals(50, calculator.calculate(10, 5, "mul"));
        assertEquals(0, calculator.calculate(0, 100, "mul"));
        assertEquals(-50, calculator.calculate(10, -5, "mul"));
        assertEquals(1, calculator.calculate(1, 1, "mul"));
    }

    @Test
    public void testDiv() {
        assertEquals(2, calculator.calculate(10, 5, "div"));
        assertEquals(1, calculator.calculate(5, 5, "div"));
        assertEquals(0, calculator.calculate(0, 5, "div"));
        assertEquals(-2, calculator.calculate(-10, 5, "div"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivByZero() {
        calculator.calculate(10, 0, "div");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivByZeroWithZeroNumerator() {
        calculator.calculate(0, 0, "div");
    }

    @Test
    public void testMod() {
        assertEquals(1, calculator.calculate(10, 3, "mod"));
        assertEquals(0, calculator.calculate(10, 5, "mod"));
        assertEquals(1, calculator.calculate(10, 3, "mod"));
        assertEquals(0, calculator.calculate(0, 5, "mod"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidOperation() {
        calculator.calculate(10, 5, "invalid");
    }

    @Test(expected = NullPointerException.class)
    public void testInvalidOperationWithNull() {
        calculator.calculate(10, 5, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidOperationWithEmptyString() {
        calculator.calculate(10, 5, "");
    }

    @Test
    public void testAddMethod() {
        assertEquals(15, calculator.add(10, 5));
        assertEquals(0, calculator.add(-5, 5));
        assertEquals(-10, calculator.add(-5, -5));
        assertEquals(1, calculator.add(0, 1));
    }

    @Test
    public void testCalculateWithNegativeNumbers() {
        assertEquals(-15, calculator.calculate(-10, -5, "add"));
        assertEquals(-5, calculator.calculate(-10, -5, "sub"));
        assertEquals(50, calculator.calculate(-10, -5, "mul"));
        assertEquals(2, calculator.calculate(-10, -5, "div"));
    }

    @Test
    public void testCalculateWithLargeNumbers() {
        assertEquals(1000000010, calculator.calculate(1000000000, 10, "add"));
        assertEquals(999999990, calculator.calculate(1000000000, 10, "sub"));
        // Note: Large multiplication causes integer overflow - 10^9 * 10 = 10^10
        // overflows int
        // The result wraps around in Java due to 32-bit int limits
        int result = calculator.calculate(1000000000, 10, "mul");
        assertEquals(1410065408, result); // Expected overflow result
    }
}
