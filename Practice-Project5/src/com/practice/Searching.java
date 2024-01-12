package com.practice;

import java.util.ArrayList;
import java.util.Scanner;

public class Searching {

    private static void searchExpenses(ArrayList<Integer> arrayList) {
        int leng = arrayList.size();

        // Check if ArrayList is not empty
        if (leng > 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the expense you need to search: ");

            //  taking and initializing user input
            int expenseToSearch = scanner.nextInt();

            // method for linear search
            boolean found = false;
            for (int i = 0; i < leng; i++) {
                if (arrayList.get(i) == expenseToSearch) {
                    System.out.println("Expense found at index " + i);
                    found = true;
                    break; // Stop searching once the expense is found
                }
            }

            // If expense is not found
            if (!found) {
                System.out.println("Expense not found. ");
            }
        } else {
            System.out.println("The given expense list is empty.");
        }
    }

    public static void main(String[] args) {
        // Example usage
        ArrayList<Integer> expenses = new ArrayList<>();
        expenses.add(1000);
        expenses.add(2300);
        expenses.add(45000);
        expenses.add(32000);
        expenses.add(110);

        searchExpenses(expenses);
    }
}
