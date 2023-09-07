package com.example.JuniLog4j;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.JuniLog4j.Calculator.Calculator;

@SpringBootTest
class JuniLog4jApplicationTests {

	@Test
	void contextLoads() {
		
	}
	
	@Test
	public void calculatorTest()
	{
		Calculator cal = new Calculator();
		assertEquals(5,cal.sum(9, -4));
	}

}
