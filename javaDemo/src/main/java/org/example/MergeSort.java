package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = { 24, 69, 80, 57, 13 };

        int[] ints = mergeSort(arr);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    private static int[] mergeSort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int middle = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
        return merge(mergeSort(left), left.length, mergeSort(right), right.length);
    }

    private static int[] merge(int[] left, int ln,  int[] right, int rn) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] res = new int[ln + rn];
        while (i < ln && j < rn) {
            if (left[i] < right[j]) {
                res[k++] = left[i++];
            }else{
                res[k++] = right[j++];
            }
        }

        while (i < ln){
            res[k++] = left[i++];
        }
        while (j < rn){
            res[k++] = right[j++];
        }
        return res;
    }
}
