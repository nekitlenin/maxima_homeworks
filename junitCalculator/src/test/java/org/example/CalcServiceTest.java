package org.example;

import org.junit.Before;
import org.junit.Test;

import java.util.InputMismatchException;

import static org.junit.Assert.assertEquals;

/**
 * Project: junitCalculator
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 24.02.2023 21:28 |
 * Created with IntelliJ IDEA
 */
public class CalcServiceTest {

    private CalcService calcService;
    private int firstNum;
    private String symbol;
    private int secondNum;

    @Before
    public void setUp() throws Exception {
        calcService = new CalcService();
    }

    @Test
    public void calcTest_whenValidParameters_thenRightResult() {
        firstNum = 2;
        symbol = "+";
        secondNum = 3;
        int expected = 5;

        assertEquals(expected, calcService.calc(firstNum, symbol, secondNum));
    }

    @Test(expected = InputMismatchException.class)
    public void calcTest_whenMaxValue_thenException() {
        firstNum = Integer.MAX_VALUE;
        symbol = "+";
        secondNum = 2;

        calcService.calc(firstNum, symbol, secondNum);
    }

    @Test(expected = ArithmeticException.class)
    public void calcTest_whenDivisionByZero_thenException() {
        firstNum = 2;
        symbol = "/";
        secondNum = 0;

        calcService.calc(firstNum, symbol, secondNum);
    }

    @Test(expected = ArithmeticException.class)
    public void calcTest_whenInvalidSymbol_thenException() {
        firstNum = 2;
        symbol = "A";
        secondNum = 5;

        calcService.calc(firstNum, symbol, secondNum);
    }
}