package com.Calculator.Service;

import com.Calculator.Model.Calculator;

public interface CalcultorService {

	public Calculator add(double value1, double value2);

	public Calculator sub(double value1, double value2);

	public Calculator mul(double value1, double value2);

	public Calculator subt(double value1, double value2);

	public Calculator mplus(double currentNumber);

	public Calculator mr();

	public String mc();


}
