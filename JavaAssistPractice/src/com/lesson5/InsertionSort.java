package com.lesson5;

public class InsertionSort {

    public static  void main(String[] args){

        int[] arr = {8,17,6,25,64};
        insertionSort(arr);
        System.out.println("Sorted array values are:");
        //loop to print array values
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);

        }
     }
    //method to sort the array elements
    public static void insertionSort(int[] arr){

    int l = arr.length;
    for(int j=1;j<l;j++){
    int key = arr[j];
    int i=j-1;
    while ((i>-1) && (arr[i]>key)){

        arr[i+1]=arr[i];
        i--;
    }
    arr[i+1]=key;
         }
    }
}

