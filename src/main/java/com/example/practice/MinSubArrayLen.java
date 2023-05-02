package com.example.practice;

public class MinSubArrayLen {

    public static int minSubArrayLen(int target, int[] nums){
        //define pointers
        int l=0,r=0;
        //min & sum
        int min=Integer.MAX_VALUE, sum=0;
        //min sub length
        for (;r<nums.length;r++){
            //add current element to sum
            sum += nums[r];
            //if sum >= target
            while (sum >= target){
                //update min
                min = Math.min(min, r-l+1);
                // sum - l
                sum -= nums[l];
                // move the l pointer
                l++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 :min;
    }

    public static void main(String[] args) {
        System.out.println("minSubArrayLen :: " + minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
