package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(15, calculator.calculate(10, 5, "add"));
        assertEquals(0, calculator.calculate(-5, 5, "add"));
    }

    @Test
    public void testSub() {
        assertEquals(5, calculator.calculate(10, 5, "sub"));
        assertEquals(-10, calculator.calculate(0, 10, "sub"));
    }

    @Test
    public void testMul() {
        assertEquals(50, calculator.calculate(10, 5, "mul"));
        assertEquals(0, calculator.calculate(0, 100, "mul"));
    }

    @Test
    public void testDiv() {
        assertEquals(2, calculator.calculate(10, 5, "div"));
        assertEquals(1, calculator.calculate(5, 5, "div"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivByZero() {
        calculator.calculate(10, 0, "div");
    }

    @Test
    public void testMod() {
        assertEquals(1, calculator.calculate(10, 3, "mod"));
        assertEquals(0, calculator.calculate(10, 5, "mod"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidOperation() {
        calculator.calculate(10, 5, "invalid");
    }

    @Test
    public void testAddMethod() {
        assertEquals(15, calculator.add(10, 5));
        assertEquals(0, calculator.add(-5, 5));
    }
}
