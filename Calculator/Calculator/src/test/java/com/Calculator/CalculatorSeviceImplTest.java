package com.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.Calculator.Model.Calculator;
import com.Calculator.SeviceIpml.CalculatorSeviceImpl;

public class CalculatorSeviceImplTest {
	
	@Test
	  public void addTest() {
		CalculatorSeviceImpl calculatorService = new CalculatorSeviceImpl();
	    Calculator result = calculatorService.add(10, 20);

	    assertEquals(10, result.getValue1());
	    assertEquals(20, result.getValue2());
	    assertEquals(30, result.getResult());
	  }
	
	@Test
	  public void negativeaddTest() {
		CalculatorSeviceImpl calculatorService = new CalculatorSeviceImpl();
		Calculator result = calculatorService.add(10, 20);

	    assertNotEquals(35, result.getResult());
	  }

	@Test
	  public void subTest() {
		CalculatorSeviceImpl calculatorService = new CalculatorSeviceImpl();
	    Calculator result = calculatorService.sub(76, 16);

	    assertEquals(76, result.getValue1());
	    assertEquals(16, result.getValue2());
	    assertEquals(60, result.getResult());
	  }
	
	@Test
	  public void negativeSubTest() {
		CalculatorSeviceImpl calculatorService = new CalculatorSeviceImpl();
		Calculator result = calculatorService.sub(45, 78);

	    assertNotEquals(-35, result.getResult());
	  }
	
	@Test
	  public void mulTest() {
		CalculatorSeviceImpl calculatorService = new CalculatorSeviceImpl();
	    Calculator result = calculatorService.mul(8, 8);

	    assertEquals(8, result.getValue1());
	    assertEquals(8, result.getValue2());
	    assertEquals(64, result.getResult());
	  }
	
	@Test
	  public void negativeMulTest() {
		CalculatorSeviceImpl calculatorService = new CalculatorSeviceImpl();
		Calculator result = calculatorService.mul(45, 78);

	    assertNotEquals(4646, result.getResult());
	  }
	
	
	@Test
	  public void divTest() {
		CalculatorSeviceImpl calculatorService = new CalculatorSeviceImpl();
	    Calculator result = calculatorService.subt(500, 100);

	    assertEquals(500, result.getValue1());
	    assertEquals(100, result.getValue2());
	    assertEquals(5, result.getResult());
	  }
	
	@Test
	  public void negativeDivTest() {
		CalculatorSeviceImpl calculatorService = new CalculatorSeviceImpl();
		Calculator result = calculatorService.subt(45, 78);

	    assertNotEquals(0.34, result.getResult());
	  }
	
	
	
}
