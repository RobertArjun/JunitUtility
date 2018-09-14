package com.main.test;


import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.main.example.Calculater;

@RunWith(Parameterized.class)
public class CalcTest3 {
	private int firstNumber;
	private int secondNumber;
	private int expected;
	private Calculater cal;

	@Before
	public void init() {
		cal = new Calculater();
	}

	public CalcTest3(int firstNumber, int secondNumber,int expected) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
		this.expected = expected;
	}

	@Parameterized.Parameters
	public static Collection Adding() {
		return Arrays.asList(new Object[][] { { 2, 4, 6 }, { 6, 7, 13} });
	}
	
	@Test
	public void testAdd() {
		assertEquals(expected, cal.add(firstNumber, secondNumber));
	}
}
