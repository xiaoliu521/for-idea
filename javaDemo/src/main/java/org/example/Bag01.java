package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author xianr
 * @date 2023-09-09
 * @Description 01背包
 */
public class Bag01 {

    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        int read = bufferedReader.read();
//        System.out.println(read);

        int m, n = 0;  // m为背包重量 // n为物品个数


        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] w = new int[n + 1];
        int[] v = new int[n + 1];

        int[] dp = new int[m + 1 ];

        for (int i = 1; i <= n; i++) {
            // 读取物品重量和价值
            w[i] = scanner.nextInt();
            v[i] = scanner.nextInt();
            for (int j = m; j >= 1; j--) {
                if (j < w[i]) {
                    dp[j] = dp[j - 1];
                    continue;
                }
                dp[j] = Math.max(dp[j - w[i]] + v[i], dp[j - 1]);
            }
        }


        for (int va : dp) {
            System.out.println(va);
        }
    }

    private void train1() {

    }
}
