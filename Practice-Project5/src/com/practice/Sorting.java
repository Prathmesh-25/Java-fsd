package com.practice;

import java.util.ArrayList;

public class Sorting {

    private static void sortExpenses(ArrayList<Integer> arrayList) {
        int arrLength = arrayList.size();

        // Check if ArrayList is not empty
        if (arrLength > 0) {
            for (int i = 0; i < arrLength - 1; i++) {
                for (int j = 0; j < arrLength - i - 1; j++) {
                    // Compare adjacent values and swap if they are not in ascending order
                    if (arrayList.get(j) > arrayList.get(j + 1)) {
                        // Swap the array elements
                        int temp = arrayList.get(j);
                        arrayList.set(j, arrayList.get(j + 1));
                        arrayList.set(j + 1, temp);
                    }
                }
            }
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

        System.out.println("Before sorting of expenses: " + expenses);
        sortExpenses(expenses);
        System.out.println("After sorting of expenses: " + expenses);
    }
}

