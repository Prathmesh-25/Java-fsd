package com.practice;

import java.util.Scanner;

public class EmailSearch {
	 public static void main(String[] args) {
	        // Sample array of emails
	        String employeeEmails[] = {"employee1@gmail.com", "employee2@gmail.com", "employee3@gmail.com",  "employee4@gmail.com", "employee5@gmail.com"};

	        //Creating a scanner object 
	        Scanner sc = new Scanner(System.in);
	        
	        // Get user input for the email to search
	        System.out.print("Enter the email ID to search: ");
	        String userInputEmail = sc.nextLine();

	        // Perform the search for user input email
	        if (searchEmail(employeeEmails, userInputEmail)) {
	            System.out.println("Email Id found!");
	        } else {
	            System.out.println("Email Id not found.");
	        }
	    }
	    //search method to compare input email from the list of emails
	    private static boolean searchEmail(String emails[], String inputEmail) {
	        for (String email : emails) {
	            if (email.equals(inputEmail)) {
	                return true;
	            }
	        }
	        return false;
	    }
	}
