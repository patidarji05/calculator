package com.Calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Calculator.Model.Calculator;
import com.Calculator.Service.CalcultorService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CalculatorCantroller {

	@Autowired
	CalcultorService calcultorService;

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}

	@GetMapping("/add/{previousNumber}/{currentNumber}")
	public double add(@PathVariable double previousNumber, @PathVariable double currentNumber) {
		Calculator c = new Calculator();
		c = calcultorService.add(previousNumber, currentNumber);
		return c.getResult();

	}

	@GetMapping("/sub/{previousNumber}/{currentNumber}")
	public double sub(@PathVariable double previousNumber, @PathVariable double currentNumber) {
		Calculator c = new Calculator();
		c = calcultorService.sub(previousNumber, currentNumber);

		return c.getResult();
	}

	@GetMapping("/mul/{previousNumber}/{currentNumber}")
	public double mul(@PathVariable double previousNumber, @PathVariable double currentNumber) {
		Calculator c = new Calculator();
		c = calcultorService.mul(previousNumber, currentNumber);
		return c.getResult();
	}

	@GetMapping("/div/{previousNumber}/{currentNumber}")
	public double subt(@PathVariable double previousNumber, @PathVariable double currentNumber) {

		Calculator c = new Calculator();
		c = calcultorService.subt(previousNumber, currentNumber);
		return c.getResult();
	}

	@PostMapping("/mplus/{currentNumber}")
	public void mPlus(@PathVariable double currentNumber) {
		System.out.println("currentnumber for m+ is :" + currentNumber);

		calcultorService.mplus(currentNumber);
		// return c.getResult();
	}

	@PostMapping("/mminus/{currentNumber}")
	public void mMinus(@PathVariable double currentNumber) {
		System.out.println("currentnumber for m- is :" + currentNumber);

		calcultorService.mplus(currentNumber);
		// return c.getResult();
	}

	@GetMapping("/mr")
	public double mr() {

		Calculator c = new Calculator();
		c = calcultorService.mr();
		System.out.println("result is :" + c.getResult());
		return c.getResult();
	}

	@GetMapping("/mc")
	public String mc() {
		return calcultorService.mc();
	}
	
	@GetMapping("/derivative/{currentNumber}")
	public double getDerivation(@PathVariable double currentNumber) {
		Calculator c = new Calculator();
		c= calcultorService.getDervi(currentNumber);
		return c.getResult();
	}
	
	
	@GetMapping("/power/{currentNumber}")
	public double getPower(@PathVariable double currentNumber) {
		Calculator c = new Calculator();
		c= calcultorService.getPower(currentNumber);
		return c.getResult();
	}
	
	@GetMapping("/sqrroot/{currentNumber}")
	public double getSqrRoot(@PathVariable double currentNumber) {
		Calculator c = new Calculator();
		c= calcultorService.getSqrroot(currentNumber);
		return c.getResult();
	}
	
}
