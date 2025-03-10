package org.example;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xianr
 * @date 2023-09-05
 * @Description 数字三角形
 */
public class num_sanjiaoxing {

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[][] arr = new int[N][N]; // 储存数字三角形的数值
        int[][] dp = new int[N + 1][N + 1]; // 储存数字三角形的最大值
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1] , dp[i - 1][j]) +  arr[i-1][j-1];
            }
        }

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum = Math.max(dp[N][i], sum);
        }
        System.out.println("sum: " + sum);
    }

    public static void main(String[] args) {
        // write your code here
        // read data from console

        // output the answer to the console according to the
        // requirements of the question
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] dp = new int[n + 1][n + 1];
        dp[0][1] = 1;
        for (int i = 1; i < dp.length -1; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j + 1] = dp[i-1][j] + dp[i-1][j+ 1];
            }
        }

        System.out.println(dp[0][1]);
        for (int i = 1; i < dp.length-1; i++) {
            for(int j = 1; j <= i;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println(dp[i][i + 1]);

        }

    }

}
