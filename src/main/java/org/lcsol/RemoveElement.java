package org.lcsol;

public class RemoveElement {

    public int removeEachVal(int[] nums, int val) {
        int k = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    public int removeOnceSame(int[] nums) {
        int lastSeen = nums[0];
        int k = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != lastSeen) {
                nums[k++] = nums[i];
            }
            lastSeen = nums[i];
        }
        return k;
    }

    public int removeAtLeastTwiceSame(int[]nums) {
        int lastSeen = nums[0];
        boolean seenTwice = false;
        int k = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == lastSeen) {
                if(seenTwice) {
                    continue;
                }
                nums[k++] = nums[i];
                seenTwice = true;
            }
            if(nums[i] != lastSeen) {
                nums[k++] = nums[i];
                seenTwice = false;
            }
            lastSeen = nums[i];
        }
        return k;
    }
}
