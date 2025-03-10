package org.example;

import java.util.ArrayList;

/**
 * @author xianr
 * @date 2023-09-06
 * @Description 最大递增子序列
 */
public class LisExample {

    public static void main1(String[] args) {
        int[] arr = {1, 5, 3, 4, 0};

        int N = arr.length;
        // 定义一个dp数组，表示每个元素为结尾的最大上升子序列
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            dp[i] = 1;
            for (int j = 1; j <= i; j++) {
                if (arr[j - 1] < arr[i - 1]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        int max = 0;
        for (int num: dp){
            System.out.println(num);
            max = Math.max(num, max);
        }
        System.out.println("------------");
        System.out.println(max);
    }

    public static void main(String[] args) {
        System.out.println(Math.round(-1.2));
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(11, "小牙刷", 12.05 ));
        items.add(new Item(5, "日本马桶盖", 999.05 ));
        items.add(new Item(7, "格力空调", 888.88 ));
        items.add(new Item(17, "肥皂", 2.00 ));
        items.add(new Item(9, "冰箱", 4200.00 ));
        items.removeIf(ele -> ele.getId() == 7);
//通过 foreach 遍历，查看是否已经删除
        items.forEach(System.out::println);
        int[] arr = {1, 5, 3, 4, 0};

        int N = arr.length;
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            dp[i] = 1;
            for (int j = 1; j <= i; j++) {
                if (arr[i - 1] > arr[j - 1]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        for (int a : dp) {
            System.out.println(a);
        }
    }

    static  class Item{

        private int id;

        public Item(int id, String ya, double v) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }
}
