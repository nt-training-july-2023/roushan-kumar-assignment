package com.example.JuniLog4j.Calculator;

import org.apache.log4j.Logger;

public class Calculator {

	private static final Logger  logger = Logger.getLogger(Calculator.class);
	public int sum(int a,int b)
	{
		logger.debug("sum");
		return (a+b);
	}
}
