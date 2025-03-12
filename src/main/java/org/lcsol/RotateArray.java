package org.lcsol;

public class RotateArray {
    public static void rotate(int[] nums, int k) {
        int len = nums.length;

        int headIdx = k;
        int tailIdx = len + k;
        int[]arr = new int[len];

        int j = 0;
        for(; headIdx <= tailIdx; j++) {
            arr[j] = nums[++headIdx % len];
        }
        for(int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }
    }
}
