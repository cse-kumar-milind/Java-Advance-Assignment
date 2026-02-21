package com.calculator.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import com.capgemini.junit.Calculator;

public class CalculatorTest {
	
	Calculator calculator;
	
	@BeforeEach
	void setup() {
		calculator = new Calculator();
	}

	@Test
	public void testTwoAndTwoGivesFour() {
		assertEquals(4, calculator.add(2, 2));
	}
	
	@RepeatedTest(3)
	public void testFiveAndFourGivesNine() {
		assertEquals(9, calculator.add(5, 4));
		
	}
}
