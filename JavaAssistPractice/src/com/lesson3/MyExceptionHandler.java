package com.lesson3;

class MyExceptionHandler extends Exception{
	   String str1;
	   MyExceptionHandler(String str2) {
		str1=str2;
	   }
	   public String toString(){ 
		return ("MyException Occurred: "+str1) ;
	   }
	}

