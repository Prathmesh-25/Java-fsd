package com.practice;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	//This method will be used to find the longest increasing subsequence
	//and returns its length
    public static int findLIS(int[] nums) {
        int l = nums.length;
        int[] lis = new int[l];
        Arrays.fill(lis, 1);

        for (int i = 1; i < l; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        int maxLength = 0;
        for (int length : lis) {
            if (length > maxLength) {
                maxLength = length;
            }
        }
        return maxLength;
    }
       	
        public static void main(String[] args) {
        int[] nums = {5, 25, 6, 39, 60, 41, 90, 100};
        int result = findLIS(nums);
        System.out.println("Length of Longest Increasing Subsequence: " + result);  
    }
}


