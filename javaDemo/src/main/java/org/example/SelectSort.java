package org.example;

public class SelectSort {

    public static void main(String[] args) {
        int[] arr = { 24, 69, 80, 57, 13 };

        sortFunc(arr);

    }

    private static void sortFunc(int[] arr) {
        int length = arr.length;
        for (int i = length -1; i >= 0; i--) {
            selectMin(arr, i);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void selectMin(int[] arr, int n) {
        int min = n;
        for (int i = n; i >= 0; i--){
            if(arr[i] < arr[min]){
                min = i;
            }
        }
        // 交换
        int temp = arr[n];
        arr[n] = arr[min];
        arr[min] = temp;
    }
}
