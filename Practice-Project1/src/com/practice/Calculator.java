package com.practice;

public class Calculator { 
	//function to perform addition 
	void add(int num1, int num2) { 
		System.out.println("Result of addition is "+(num1+num2)); 
	} 
	//function to perform substraction 
	void sub(int num1, int num2) { 
		System.out.println("Result of substraction is "+(num1-num2)); 
	} 
	//function to perform division 
	void div(int num1, int num2) { 
		if(num2 == 0) { 
			System.out.println("Error: Result will be undefined"); 
		} 
		else { 
			System.out.println("Result of division is "+(num1/num2));
		} 
	} 
 
	//function to perform multiplication 
	void prod(int num1, int num2) { 
		System.out.println("Result of multiplication is "+(num1*num2)); 
	} 
}
