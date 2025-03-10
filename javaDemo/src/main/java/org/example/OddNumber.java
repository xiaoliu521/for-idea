package org.example;

import java.util.Arrays;

/**
 * @author xianr
 * @date 2023-09-12
 * @Description 差分
 */
public class OddNumber {

    public static void main(String[] args) {
        int[] l = {1, 2, 1};
        int[] r = {2,3, 3};
        oddnumber(3, 3, l, r);   // 2 3 2

    }

    public static int oddnumber (int n, int m, int[] l, int[] r) {
        // write code here
        int[] arr = new int[n];
        int[] dp = new int[n];
        Arrays.fill(arr, m);

        int[] difference = new int[n];
        Arrays.fill(difference, 0);

        for (int i = 0; i < m; i++) {
//            int[] arr = new int[n];
            int start = l[i] -1;
            int end = r[i];
            difference[start] = difference[start] + 1;
            if (end < difference.length) {
                difference[end ] = difference[end] - 1;
            }
        }
        // 前缀和
        dp[0] = difference[0];
        for (int i = 1; i < difference.length; i++) {
            dp[i] = dp[i -1] + difference[i];
        }

        int oddnum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] += dp[i];
            if (arr[i] % 2 != 0) {
                oddnum++;
            }
        }

        System.out.println(oddnum);
        System.out.println(Arrays.toString(dp));

        System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.toString(difference));



        return oddnum;
    }
}
