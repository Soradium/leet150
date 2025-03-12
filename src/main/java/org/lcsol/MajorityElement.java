package org.lcsol;

import java.util.*;
import java.util.Collection;

public class MajorityElement {
    /*
    * Given an array nums of size n, return the majority element.
    The majority element is the element that appears more than ⌊n / 2⌋ times.
   *You may assume that the majority element always exists in the array.
*/
//Yes, there is a better solution, algorithm by Boyer-Moore pattern search
    public int majorityElementBadMaybe(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>(nums.length);
        for(int i : nums) {
            if(!m.containsKey(i)) {
                m.put(i, 1);
                continue;
            }
            m.put(i, m.get(i) + 1);
        }
        int mostMet = 0;
        int mostMetK = 0;
        Integer[] ks = m.keySet().toArray(new Integer[0]);
        for(int k = 0; k < ks.length; k++){
            int getRes = m.get(ks[k]);
            if(getRes > mostMet) {
                mostMet = getRes;
                mostMetK = ks[k];
            }
        }
        return mostMetK;
    }

}
