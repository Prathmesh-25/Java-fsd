package com.lesson5;

import java.util.Scanner;

public class LinearSearch {

    public static void main(String[] args){

        int[] a = {5,10,15,20,25,30};

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        // searchval takes input from the user of the value to be searched
        int searchval = sc.nextInt();
            //b is storing the return value of linear method
            int b = (int) linear(a,searchval);

            if(b==-1){

                System.out.println("Number not found");
            } else {

                System.out.println("Element found at "+b+" and the search key is "+a[b]);
            }
        }

//method to perform linear search
public static int linear(int arr[], int n) {

    int arrlength = arr.length;
    for (int i = 0; i < arrlength - 1; i++) {

        if (arr[i] == n) {

            return i;
         }
     }
            return -1;
   }
}

