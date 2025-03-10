package org.example;

/**
 * @author xianr
 * @date 2023-09-07
 * @Description 最长公共子序列
 */
public class LcsExample {

    public static void main(String[] args) {
        char[] str1 = {'G', 'A', 'C', 'C', 'T', 'A', 'G', 'C'};
        char[] str2 = {'T', 'T', 'A', 'G'};

        int len1 = str1.length;
        int len2 = str2.length;

        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        for (int i = 0; i < dp[len1].length; i++) {
            System.out.println(dp[len1][i]);
        }

    }
}
