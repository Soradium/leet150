package org.lcsol;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static int romanToInt(String s) {
        int sum = 0;
        char [] chars = s.toCharArray();
        char curr;

        int [] intVal = new int[chars.length];
        int currVal;
        int prevVal;
        for(int i = 0; i < chars.length; i++) {
            curr = chars[i];
            switch(curr) {
                case 'I': intVal[i] = 1; break;
                case 'V': intVal[i] = 5; break;
                case 'X': intVal[i] = 10; break;
                case 'L': intVal[i] = 50; break;
                case 'C': intVal[i] = 100; break;
                case 'D': intVal[i] = 500; break;
                case 'M': intVal[i] = 1000; break;
            }
        }
        currVal = intVal[intVal.length - 1];
        prevVal = intVal[intVal.length - 1];
        for(int i = intVal.length - 1; i >= 0; i--) {
            currVal = intVal[i];
            if(currVal < prevVal) {
                sum-=currVal;
                prevVal = currVal;
            }
            else {
                sum += currVal;
                prevVal = currVal;
            }
        }

        return sum;
    }

    public static int romanToIntMap(String s) {
        int sum = 0;
        char [] chars = s.toCharArray();
        char curr, prev;

        Map<Character, Integer> mp = new HashMap<>(s.length() + 1);
        int currVal;
        int prevVal;
        for(int i = 0; i < chars.length; i++) {
            curr = chars[i];
            switch(curr) {
                case 'I': mp.put('I',1); break;
                case 'V': mp.put('V',5); break;
                case 'X': mp.put('X',10);break;
                case 'L': mp.put('L',50); break;
                case 'C': mp.put('C',100); break;
                case 'D': mp.put('D',500); break;
                case 'M': mp.put('M',1000); break;
            }
        }
        prev = chars[chars.length - 1];
        for(int i = chars.length - 1; i >= 0; i--) {
            curr = chars[i];
            currVal = mp.get(curr);
            prevVal = mp.get(prev);
            if(currVal < prevVal) {
                sum -= currVal;
                prev = curr;
            }
            else {
                sum += currVal;
                prev = curr;
            }
        }

        return sum;
    }
}


/*
* switch(prevChar) {
                case 'I': {
                    switch(curr) {
                        case 'V': sum += 4; break;
                        case 'X': sum += 9; break;
                    }
                    break;
                }
                case 'X': {
                    switch(curr) {
                        case 'L': sum += 40; break;
                        case 'C': sum += 90; break;
                    }
                    break;
                }
                case 'C': {
                    switch(curr) {
                        case 'D': sum += 400; break;
                        case 'M': sum += 900; break;
                    }
                    break;
                }
                case 'V': { sum+= 5; break; }
                case 'L': { sum+=50; break; }
                case 'D': { sum+=500; break; }
                case 'M': { sum+=1000; break; }
            }*/