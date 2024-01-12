package com.project;

import java.util.*;

//Class to represent a Movie
class Movie {
 String name;
 String date;
 String showTime;
 double ticketPrice;
 char [][] seatingArrangement;
 Map<String, List<Seat>> seatingMap;
 int rows;
 int columns;

 public Movie(String name, String date, String showTime, double ticketPrice, int rows, int columns) {
     this.name = name;
     this.date = date;
     this.showTime = showTime;
     this.ticketPrice = ticketPrice;
     this.rows = rows;
     this.columns = columns;
     this.seatingArrangement = new char[rows][columns];
     this.seatingMap = new HashMap<>();
     initializeSeating(); 
 }
 
 private void initializeSeating() {
     // Assume a simple seating arrangement, you can modify this based on your needs
     for (char row = 'A'; row <= 'B'; row++) {
         List<Seat> seats = new ArrayList<>();
         for (int seatNum = 1; seatNum <= 5; seatNum++) {
             String seatNumber = row + String.valueOf(seatNum);
             seats.add(new Seat(seatNumber));
         }
         seatingMap.put(String.valueOf(row), seats);
     }
 }
 public void displaySeatingArrangement() {
     System.out.println("Seating Arrangement:");
     for (int i = 0; i < seatingArrangement.length; i++) {
         for (int j = 0; j < seatingArrangement[i].length; j++) {
             System.out.print(seatingArrangement[i][j] + " ");
         }
         System.out.println();
     }
 }

 public boolean bookSeats(int row, int startSeat, int endSeat) {
     // Check if seats are available and book them
     for (int i = startSeat; i <= endSeat; i++) {
         if (seatingArrangement[row][i] == 'X') {
             System.out.println("Seat " + (char) ('A' + i) + " in row " + (row + 1) + " is already booked.");
             return false;
         }
     }

     for (int i = startSeat; i <= endSeat; i++) {
         seatingArrangement[row][i] = 'X'; // 'X' represents a booked seat
     }

     System.out.println("Seats booked successfully.");
     return true;
 }
}
