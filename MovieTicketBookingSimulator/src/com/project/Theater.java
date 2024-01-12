package com.project;

import java.util.*;

//Class to represent a Theater
class Theater {
 private String username;
 private String password;
 private List<Movie> movies;
 

 public Theater(String username, String password) {
     this.username = username;
     this.password = password;
     this.movies = new ArrayList<>();
     
 }

 public boolean login(String enteredUsername, String enteredPassword) {
     return username.equals(enteredUsername) && password.equals(enteredPassword);
 }

 public void updatePassword(String newPassword) {
     password = newPassword;
     System.out.println("Password updated successfully.");
 }

 public void addMovie(Movie movie) {
     movies.add(movie);
 }

 public void viewSeatingArrangement(String date, String showTime) {
     for (Movie movie : movies) {
         if (movie.date.equals(date) && movie.showTime.equals(showTime)) { 
        	 movie.displaySeatingArrangement();
        	 return;
         }
     }  
         System.out.println("No matching movie found for the specified date and show time.");   
     
 }

 public void bookTicket(String date, String showTime, int seatCount) {
	    Scanner scanner = new Scanner(System.in);

	    boolean movieFound = false;

	    for (Movie movie : movies) {
	        if (movie.date.equals(date) && movie.showTime.equals(showTime)) {
	            movieFound = true;

	            List<String> bookedSeats = new ArrayList<>();

	            while (bookedSeats.size() < seatCount) {
	                movie.displaySeatingArrangement();
	                System.out.print("Choose seat (e.g., A1,A2,A6 or B1-B5) or 'exit' to cancel: ");
	                String input = scanner.nextLine();

	                if (input.equalsIgnoreCase("exit")) {
	                    System.out.println("Ticket booking canceled.");
	                }

	                // Split the input based on comma
	                String[] seatSelections = input.split(",");

	                try {
	                    for (String seatSelection : seatSelections) {
	                        if (seatSelection.contains("-")) {
	                            // selection of seats for a given range
	                            String[] range = seatSelection.split("-");
	                            char startRowLetter = range[0].charAt(0);
	                            char endRowLetter = range[1].charAt(0);
	                            int startRow = startRowLetter - 'A';
	                            int endRow = endRowLetter - 'A';

	                            int startSeatNum = Integer.parseInt(range[0].substring(1)) - 1;
	                            int endSeatNum = Integer.parseInt(range[1].substring(1)) - 1;

	                            for (int row = startRow; row <= endRow; row++) {
	                                for (int seatNumber = startSeatNum; seatNumber <= endSeatNum; seatNumber++) {
	                                    if (!movie.bookSeats(row, seatNumber, seatNumber)) {
	                                        System.out.println("Seat " + seatSelection + " not available or invalid. Please try again.");
	                                    }
	                                    bookedSeats.add((char) ('A' + row) + String.valueOf(seatNumber + 1));
	                                }
	                            }
	                        } else {
	                            // single seat selection
	                            char rowLetter = seatSelection.charAt(0);
	                            int row = rowLetter - 'A';
	                            int seatNumber = Integer.parseInt(seatSelection.substring(1)) - 1;
	                            
	                            if (row >= movie.rows) {
									throw new InvalidSeatException();
								}

	                            if (!movie.bookSeats(row, seatNumber, seatNumber)) {
	                                System.out.println("Seat " + seatSelection + " not available or invalid. Please try again.");
	                            }
	                            bookedSeats.add((char) ('A' + row) + String.valueOf(seatNumber + 1));
	                        }
	                    }

	                    // all the seats are booked successfully
	                    double amount = seatCount * movie.ticketPrice;
	                    System.out.println("Amount to be paid: $" + amount);
	                    System.out.println("Ticket booked successfully.");

	                } catch (NumberFormatException | StringIndexOutOfBoundsException | InvalidSeatException e) {
	                    System.out.println("Invalid seat selection. Please enter a valid selection.");
	                }
	            }
	        }
	    }
	    if (!movieFound) {
	        System.out.println("No matching movie found for the specified date and show time.");
	    }
	}



 
 //method for veiwing booking status of movies
 public void viewBookingStatus() {
     boolean bookingsExist = false;

     for (Movie movie : movies) {
         System.out.println("Movie: " + movie.name);
         System.out.println("Date: " + movie.date + " | Show Time: " + movie.showTime);
         
         boolean movieBooked = false;

         for (int i = 0; i < movie.seatingArrangement.length; i++) {
             for (int j = 0; j < movie.seatingArrangement[i].length; j++) {
                 if (movie.seatingArrangement[i][j] == 'X') {
                     if (!movieBooked) {
                         System.out.println("Booked Seats:");
                         movieBooked = true;
                     }
                     System.out.println("Row " + (char) ('A' + i) + ", Seat " + (j + 1));
                 }
             }
         }

         if (!movieBooked) {
             System.out.println("No bookings for this movie yet.");
         } else {
             System.out.println(); // Add a newline for better readability
             bookingsExist = true;
         }
     }

     if (!bookingsExist) {
         System.out.println("Booking status: No bookings yet.");
     }
 }
}
