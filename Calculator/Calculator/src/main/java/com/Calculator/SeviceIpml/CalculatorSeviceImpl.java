package com.Calculator.SeviceIpml;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.Calculator.Model.Calculator;
import com.Calculator.Service.CalcultorService;

@Service
public class CalculatorSeviceImpl implements CalcultorService{

	java.util.logging.Logger logger =java.util.logging.Logger.getLogger(this.getClass().getName());
	
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

	


	
	
}
