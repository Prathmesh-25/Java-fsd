package com.project;

import java.util.*;

//Main Movie Ticket Booking Class
public class MovieBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // initialize a Theater
        Theater theater = new Theater("username", "password");

        // adding movies to the theater
        theater.addMovie(new Movie("MovieA", "2023-12-07", "15:00", 100.0,2,6));
        theater.addMovie(new Movie("MovieB", "2023-12-07", "18:00", 120.0,2,6));
        theater.addMovie(new Movie("MovieC", "2023-12-07", "20:00", 90.0,2,6));
        theater.addMovie(new Movie("MovieD", "2023-12-07", "12:00", 150.0,2,6));
        
        //login for front desk user
        System.out.print("Username: ");
        String inputUsername = sc.nextLine();
        System.out.print("Password: ");
        String inputPassword = sc.nextLine();

        if (theater.login(inputUsername, inputPassword)) {
            System.out.println("Login successful!");
            while (true) {
                //Display Menu of the Application
            	System.out.println("=======================================");
                System.out.println("\nMenu:");
                System.out.println("=======================================");
                System.out.println("1. Change Password");
                System.out.println("2. View Seating Arrangement");
                System.out.println("3. Book Movie Ticket");
                System.out.println("4. View Ticket Booking Status");
                System.out.println("5. Exit The Application\n");
                System.out.println("=======================================");
                System.out.print("Enter your choice: ");
                int option = sc.nextInt();
                System.out.print("\n");
                sc.nextLine(); //Takes new line for new input

                switch (option) {
                    case 1:
                        //Case to update application login password 
                        System.out.print("Enter a new password: ");
                        String newPassword = sc.nextLine();
                        theater.updatePassword(newPassword);
                        break;
                    case 2:
                        //Case to view seating arrangement
                        System.out.print("Enter date (YYYY-MM-DD): ");
                        String date = sc.nextLine();
                        System.out.print("Enter show time: ");
                        String showTime = sc.nextLine();
                        theater.viewSeatingArrangement(date, showTime);
                        break;
                    case 3:
                        // Case for booking movie tickets
                        System.out.print("Enter date (YYYY-MM-DD): ");
                        date = sc.nextLine();
                        System.out.print("Enter show time: ");
                        showTime = sc.nextLine();
                        System.out.print("Enter the number of seats to book: ");
                        int seatCount = sc.nextInt();
                        sc.nextLine(); // Consume newline
                        theater.bookTicket(date, showTime, seatCount);
                        break;
                    case 4:
                        // Case for viewing booking status
                        theater.viewBookingStatus();
                        break;
                    case 5:
                        // Case for exiting the application 
                        System.out.println("Exiting application. Visit Again!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Login failed. Exiting program.");
        }
    }
}
