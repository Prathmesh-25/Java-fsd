package com.lesson5;

public class SelectionSort {

    public static void main(String[] args) {

    int[] a = {7,18,8,3,20,5};
    int l = a.length;
    selectionSort(a,l);
    System.out.println("The sorted array values are:");
    for(int i:a){

        System.out.println(i);
         }
     }

    public static void selectionSort(int[] arr, int length){

        for(int i=0;i<length-1;i++){

            int index =i;
            for(int j=i+1;j<length;j++){
                if(arr[j]<arr[index]){

                    index =j;
                }

            }
            int smallNumber = arr[index];
            arr[index]= arr[i];
            arr[i]= smallNumber;
        }

    }
}

