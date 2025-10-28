package hslu.oop.sw06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    CalculatorImpl calculator = new CalculatorImpl();

    @Test
    void testAddition_twoZeros() {
        Assertions.assertEquals(0, calculator.addition(0,0));
    }

    @Test
    void testAddition_twoNegativeNumbers() {
        Assertions.assertEquals(-8, calculator.addition(-3,-5));
    }

    @Test
    void testAddition_twoOverflowNumbers_notNegative() {
        Assertions.assertNotEquals(-2147483648, calculator.addition(2147483647,1));
    }

    @Test
    void testAddition_twoOverflowNumbersNegative_notPositive() {
        Assertions.assertNotEquals(2147483647, calculator.addition(-2147483648,-1));
    }
}