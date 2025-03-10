package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author xianr
 * @date 2023-09-14
 * @Description 大精度乘法
 */
public class BigMultiplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1, str2 = new String();
        str1 = sc.nextLine();
        str2 = sc.nextLine();
        int[] a = new int[str1.length()];
        int[] b = new int[str2.length()];

        // 反转字符串 0,0,0,0,1
        for (int i = 0; i < str1.length(); i++) {
            a[a.length - 1 - i] = (str1.charAt(i) - 48);
        }
        for (int i = 0; i < str2.length(); i++) {
            b[b.length - 1 - i] = (str2.charAt(i) - 48);
        }


        int[] dp = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                dp[i + j] += a[i] * b[j];
                dp[i + j + 1] += dp[i + j] / 10;
                dp[i + j] = dp[i + j] % 10;
            }
        }

        System.out.println(Arrays.toString(dp));

        // 移除无用的0
        while (dp.length > 1 && dp[dp.length - 1] == 0) {
            dp = Arrays.copyOfRange(dp, 0, dp.length - 1);
        }

        System.out.println(Arrays.toString(dp));
    }

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int max = 0;
        Map charMap =  new HashMap<Character, Integer>();
        for(int i = 0; i< s.length(); i++){
            if(charMap.containsKey(s.charAt(i))){
                left = Math.max(left, (Integer) charMap.get(s.charAt(i) + 1));
            }
            charMap.put(s.charAt(i), i);
            max = Math.max(max, i -left + 1);
        }
        return max;

    }



    public String minWindow(String s, String t) {
//        int left = 0;
//        int min =s.length();
//
//        for (int i = 0; i < s.length(); i++){
//            if()
//        }
        return null;

    }

    private Boolean check(String a, String b) {
        boolean flag = true;
        for (int i = 0; i < b.length(); i++) {
            if (a.indexOf(b.charAt(i)) == -1) {
                flag = false;
            }
        }
        return flag;
    }
}
