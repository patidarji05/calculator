package com.Calculator.Model;


public class Calculator {
	
	private double value1;
	private double Value2;
	private double result;
	
	public Calculator() {
		super();
	}

	public Calculator(double value1, double value2, double result) {
		super();
		this.value1 = value1;
		this.Value2 = value2;
		this.result = result;
	}
	
	

	public double getValue1() {
		return value1;
	}

	public void setValue1(double value1) {
		this.value1 = value1;
	}

	public double getValue2() {
		return Value2;
	}

	public void setValue2(double value2) {
		Value2 = value2;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}
	
	
}
