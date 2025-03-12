package org.lcsol;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int[]a = {-1,-100,3,99};
//        RotateArray.rotate(a,2);
//
//        System.out.println(Arrays.toString(a));
        int [] c = {0,2,0};
        HIndex h = new HIndex();
        h.doQsortRec(c, 0, c.length - 1);
        System.out.println(Arrays.toString(c));
    }
}