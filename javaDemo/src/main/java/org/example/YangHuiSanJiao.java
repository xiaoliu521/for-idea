package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xianr
 * @date 2023-09-09
 * @Description TODO
 */
public class YangHuiSanJiao {


    public static int[][] generate(int numRows) {
        int[][] dp = new int[numRows][];

        for (int i = 0; i< numRows; i++){
            dp[i] = new int[i + 1];
            dp[i][0] = 1;
            dp[i][i] = 1;
            for (int j = 1; j < i; j ++){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        return dp;

    }

    public static List<List<Integer>> generate(Integer numRows) {
        List<List<Integer>> dp = new ArrayList<>(numRows);

        for (int i = 0; i< numRows; i++){
            dp.add(new ArrayList<>());
            for (int j = 0; j <= i; j ++){
                if (j == 0 || j == i) {
                    dp.get(i).add(1);
                    continue;
                }
                dp.get(i).add( dp.get(i-1).get(j-1) + dp.get(i-1).get(j));
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        List<List<Integer>> generate = generate(new Integer(5));
        System.out.println();
//        for (int[] a : generate) {
//            for (int b : a) {
//                System.out.print(b);
//                System.out.print(" ");
//            }
//            System.out.println("____");
//        }
    }
}
