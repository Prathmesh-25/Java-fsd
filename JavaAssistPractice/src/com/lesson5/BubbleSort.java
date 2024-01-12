package com.lesson5;

public class BubbleSort {


    public static void main(String[] args){

     int[] a= {50,10,35,70,5,16};
     bubbleSort(a);
     System.out.println("Sorted array values are:");
     for(int i=0;i<a.length;i++){
        System.out.println(a[i]);
        }
    }
    //function to sort and array
    public static void bubbleSort(int[] arr){
        int len = arr.length;
        int temp = 0;
        for(int i=0;i<len;i++){
            for (int j=1;j<(len);j++){
                if(arr[j-1]>arr[j]){
                temp = arr[j-1];
                arr[j-1]= arr[j];
                arr[j]= temp;

                }
            }
        }
    }
}

