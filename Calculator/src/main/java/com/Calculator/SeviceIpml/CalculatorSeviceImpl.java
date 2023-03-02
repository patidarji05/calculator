package com.Calculator.SeviceIpml;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.Calculator.Model.Calculator;
import com.Calculator.Service.CalcultorService;

@Service
public class CalculatorSeviceImpl implements CalcultorService{

	java.util.logging.Logger logger =java.util.logging.Logger.getLogger(this.getClass().getName());
	
	
   List<Double> li= new ArrayList<>();
	
	@Override
	@Cacheable(cacheNames = "calculator" , key="#previousNumber")
	public Calculator add(double previousNumber, double currentNumber) {
		Calculator c= new Calculator();
		try {
		c = new Calculator(previousNumber,currentNumber,previousNumber+currentNumber);
		logger.info("fatching data from addition method ");
		}catch(Exception e){
			e.printStackTrace();
		}
		return c;
	}

	@Override
	@Cacheable(cacheNames = "calculator" , key="#previousNumber")
	public Calculator sub(double previousNumber, double currentNumber) {
		// TODO Auto-generated method stub
		Calculator c= new Calculator();
		try {
			c= new Calculator(previousNumber,currentNumber,previousNumber-currentNumber);
			logger.info("fatching data from subtraction method ");
		}catch(Exception e) {
			e.printStackTrace();
		}
	return c;
	}

	@Override
	@Cacheable(cacheNames = "calculator" , key="#previousNumber")
	public Calculator mul(double previousNumber, double currentNumber) {
		// TODO Auto-generated method stub
		Calculator c= new Calculator();
		try {
		c= new Calculator(previousNumber,currentNumber,previousNumber*currentNumber);
		logger.info("fatching data from multiplication method ");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	@Cacheable(cacheNames = "calculator" , key="#previousNumber")
	public Calculator subt(double previousNumber, double currentNumber) {
		// TODO Auto-generated method stub
		Calculator c= new Calculator();
		try {
		c= new Calculator(previousNumber,currentNumber,previousNumber/currentNumber);
		logger.info("fatching data from division method ");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public Calculator mplus(double currentNumber) {
		li.add(currentNumber);
		System.out.println(li.toString());
		return null;
	}

	public Calculator mr() {
		Calculator c= new Calculator();
		Double sum = li.stream().reduce((double) 0,(a,b) -> a+b);
		c.setResult(sum);
		return c;
	}

	@Override
	public String mc() {
		if(li.size() > 0) {
			System.out.println(li.toString());
			li.clear();
			
		}
		System.out.println(li.toString());
		return "";
	}


	
	
}
