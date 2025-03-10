package org.example;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] arr = { 24, 69, 80, 57, 13 };

        for (int i = 1; i < arr.length; i++) {
            int min = i;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[min] < arr[j]) {
                    // 交换
                    swap(arr, min--, j);
                }
            }
        }

        for (int k = 0; k < arr.length; k++) {
            System.out.println(arr[k]);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
