package org.lcsol;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Product Except Self
        int[] a = {1,2,3,4};
        int[] b = {-1,1,0,-3,3};
        ProductExceptSelf.productExceptSelf(a);
        System.out.println("[24, 12, 8, 6] result");
        System.out.println();
        ProductExceptSelf.productExceptSelf(b);
        System.out.println("[0, 0, 9, 0, 0] result");

        //Roman To Int
//        int a = RomanToInteger.romanToIntMap("MCMXCIV");
//        int b = RomanToInteger.romanToIntMap("XXX");
//        int c = RomanToInteger.romanToIntMap("LXXX");
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
        // Rotate Array
//        int[]a = {-1,-100,3,99};
//        RotateArray.rotate(a,2);
//
//        System.out.println(Arrays.toString(a));
        // Hindex
//        int [] c = {0,2,0};
//        HIndex h = new HIndex();
//        h.doQsortRec(c, 0, c.length - 1);
//        System.out.println(Arrays.toString(c));
    }
}