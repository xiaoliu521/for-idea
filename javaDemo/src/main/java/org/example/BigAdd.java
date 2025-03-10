package org.example;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xianr
 * @date 2023-09-11
 * @Description 高精度算法
 */
public class BigAdd {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1, str2 = new String();
        str1 = sc.nextLine();
        str2 = sc.nextLine();
        int[] a = new int[str1.length()];
        int[] b = new int[str2.length()];

        int[] res = new int[Math.max(str1.length(), str2.length()) + 1];

        // 反转字符串 0,0,0,0,1
        for (int i = 0; i < str1.length(); i++) {
            a[a.length - 1 - i] = (str1.charAt(i) - 48);
        }
        for (int i = 0; i < str2.length(); i++) {
            b[b.length - 1 - i] = (str2.charAt(i) - 48);
        }





        // 相加
        for (int i = 0; i < res.length - 1; i++) {
            // i 大于任一长度，则计算完成
            int temp = 0;
            if (i >= a.length) {
                temp = res[i] + b[i];
            } else if(i >= b.length ){
                temp = res[i] + a[i];
            }else{
                temp = a[i] + b[i];
            }
            int r = temp / 10;
            res[i + 1] = r;
            res[i] = temp % 10;
        }


        if (res[res.length - 1] == 0) {
            res = Arrays.copyOfRange(res, 0, res.length - 1);
        }

        for (int q : res) {
            System.out.print(q);
        }
    }
}
