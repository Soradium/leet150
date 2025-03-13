package org.lcsol;

/*
Given an integer array nums, return an array answer such that answer[i]
is equal to the product of all the elements of nums except nums[i].
You must write an algorithm that runs in O(n) time
and without using the division operation.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30

Follow up: Can you solve the problem in O(1) extra space complexity?
(The output array does not count as extra space
for space complexity analysis.)
* */

import java.util.Arrays;

public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length; // len for convenience
        int[] pre = new int[len]; //prefix array
        int[] post = new int[len]; //suffix array
        int prevMultiplication = nums[0]; //set previous multiply for pre gen
        pre[0] = nums[0]; // set first element so that there is something to multiply to

        // inclusive scan
        for(int i = 1; i < len; i++) {
            pre[i] = prevMultiplication * nums[i]; //formula
            // next in order is multiplied by multiplication of all previous elements
            prevMultiplication = pre[i]; // set it to new i*prev multiplied element
            // prefix generation
        }

        prevMultiplication = nums[len - 1]; // set prev again, for suff gen now
        post[len - 1] = nums[len - 1]; // set first element for multiplying

        for(int i = len - 2; i >= 0; i--) {
            post[i] = prevMultiplication * nums[i]; //formula
            // next in order is multiplied by multiplication of all previous elements
            prevMultiplication = post[i]; // set it to new i*prev multiplied element
            // suffix generation
        }

        //Turn inclusive scan into exclusive scan by shifting (123quikmath)
        for(int i = len - 1; i - 1 >= 0; i--) {
            int temp = pre[i-1]; // shift pre to right
            pre[i-1] = pre[i];
            pre[i] = temp;
        }
        pre[0] = 1; // set the 'x_1' element

        for(int i = 0; i + 1 < len; i++) {
            int temp = post[i+1]; // shift post to left
            post[i+1] = post[i];
            post[i] = temp;
        }
        post[len - 1] = 1;  // set the 'x_1' element

        for(int i = 0; i < len; i++) {
            nums[i] = pre[i] * post[i]; // multiply pre/post value by value
        }
        pre = null;
        post = null;
        prevMultiplication = 0;
        len = 0;
        System.gc();
        return nums;
        /*
        [1, 2, 3, 4]
        pre 0 1 2 3 [1, 2, 6, 24] -> [1, 1, 2, 6] - shift ->

        post 3 2 1 0 [24, 24, 12, 4] -> [24, 12, 4, 1] - shift <-
            multiply pre/post index by index
        [24, 12, 8, 6] result
        */
    }
}


