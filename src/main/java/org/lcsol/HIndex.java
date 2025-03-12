package org.lcsol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HIndex {
    public int hIndex(int[] citations) {
        int len = citations.length;
        doQsortRec(citations, 0, len - 1);
        int maxCited = citations[len - 1];
        int metRequirements = 0;
        int h = 0;
        if(len == 1) {
            return citations[0] == 0 ? 0 : 1;
        }
        // maybe a qsearch is possible here eh
        for(int i = len - 1; i >= 0; i--) {
            for(int j = i; j >= 0; j--) {
                if(citations[j] < maxCited) {
                    maxCited = citations[j];
                    metRequirements++;
                }
                if(citations[j] > h && h <= len - 1 - j) {
                    h = j;
                }
            }
        }
        return Math.min(h, metRequirements);
    }

    public void doQsortRec(int[]arr, int leftIdx, int rightIdx) {
        if(leftIdx >= rightIdx) {
            return;
        }

        int pivot = fragment(arr, leftIdx, rightIdx);

        doQsortRec(arr, leftIdx, pivot - 1);
        doQsortRec(arr, pivot + 1, rightIdx);
    }

    private int fragment(int[]arr, int leftIdx, int rightIdx) {
        int temp = arr[rightIdx];
        arr[rightIdx] = arr[leftIdx];
        arr[leftIdx] = temp;

        int pivotIdx = leftIdx-1;
        for(;leftIdx < rightIdx; leftIdx++) {
            if(arr[leftIdx] > arr[rightIdx]) {
                temp = arr[++pivotIdx];
                arr[pivotIdx] = arr[leftIdx];
                arr[leftIdx] = temp;
            }
        }
        temp = arr[rightIdx];
        arr[rightIdx] = arr[++pivotIdx];
        arr[pivotIdx] = temp;

        return pivotIdx;
    }

}
