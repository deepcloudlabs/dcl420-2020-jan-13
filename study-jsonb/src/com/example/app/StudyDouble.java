package com.example.app;

import java.math.BigDecimal;

public class StudyDouble {

	public static void main(String[] args) {
		
		float x = 1_000_000_000;
		x = x + 50 ;
		System.out.println(String.format("%16.3f", x));
	}

}
