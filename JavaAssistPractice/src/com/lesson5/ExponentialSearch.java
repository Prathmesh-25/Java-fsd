package com.lesson5;

import java.util.Arrays;

public class ExponentialSearch {

public static  void main(String[] args){

    int[] a = {5,10,15,20,25};
    int l= a.length;
    int key = 15;
    int outcome = exponentialSearch(a,l,key);

    if(outcome<0){

       System.out.println( "Element is not present in the array");

    }else {

        System.out.println( "Element is  present in the array at index :"+outcome);
    }

        }
		//
	public static int exponentialSearch(int[] arr ,int length, int val ){

        if(arr[0]==val){
            return 0;
            }
        int i=1;
        while(i<length && arr[i]<=val){

            i=i*2;
        }
        return Arrays.binarySearch(arr,i/2,Math.min(i,length),val);
        }

}

