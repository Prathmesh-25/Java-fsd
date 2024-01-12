
package com.practice; 
 
import java.util.Scanner; 
 
public class MainClass { 
 
 public static void main(String[] args) { 
   
  //Creating Scanner Object 
  Scanner sc = new Scanner(System.in); 
   
  //Taking input of option from user 
  System.out.println("Choose an option:\n1 Add\n2.Substract\n3.Divide\n4.Multiply\n"); 
  int option = sc.nextInt(); 
   
  //Taking in of First and Second Number 
  System.out.println("Enter First Number"); 
  int num1 = sc.nextInt(); 
  System.out.println("Enter Second Number"); 
  int num2 = sc.nextInt(); 
   
  //Creating Calculator object 
  Calculator calc = new Calculator(); 
   
  //Using if else if statement for validating option and 
  //performing associated operations 
  //by calling the functions from calculator class 
  if (option == 1) { 
            calc.add(num1, num2); 
        }  
  else if (option == 2) { 
         calc.sub(num1, num2); 
        }  
        else if (option == 3) { 
         calc.div(num1, num2);; 
        }  
        else if (option == 4) { 
         calc.prod(num1, num2); 
        }  
        else { 
            System.out.println("Invalid Choice"); 
            return; 
        } 
 
 } 
 
} 
