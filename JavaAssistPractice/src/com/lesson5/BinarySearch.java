package com.lesson5;

public class BinarySearch {

    public static  void main(String[] args){


        int[] arr = {2,4,6,8,10};
        int key = 6;
        int arrlength = arr.length;
        binarySearch(arr,0,key,arrlength);
    }
//method to perform binary search
public static void binarySearch(int[] arr, int start, int key, int length){

        int mid = (start+length)/2;
        while(start<=length){

            if(arr[mid]<key){

                start = mid + 1;
            } else if(arr[mid]==key){
                System.out.println("Element is found at index :"+mid);
                break;
            }else {

                length=mid-1;
            }
            mid = (start+length)/2;
        }
            if(start>length){

                System.out.println("Element is not found");
            }

}
}

