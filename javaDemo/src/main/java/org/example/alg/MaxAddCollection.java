package org.example.alg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xianr
 * @date 2023-10-12
 * @Description 在一个数组中找到一个最长的子序列，是每个元素都比前一个元素大，例如对于{3, 4, 2, 8, 10, 5, 1},它的最长递增子序列就是{3,4,8,10},长度为4
 */
public class MaxAddCollection {

    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 8, 10, 5, 1};
        // dp 下标为子序列长度，值为子序列最后一个元素
        List<Integer> dp = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();
        // 存储arr对应元素的前一个元素的下标
        int[] idx = new int[arr.length];
        idx[0] = 0;
        dp.add(arr[0]);
        pos.add(0);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > dp.get(dp.size()-1)){
                idx[i] = pos.get(dp.size() -1);
                dp.add(arr[i]);
                pos.add(i);
            }else {
                // 二分查找小于等于该元素最近的一个
                int i1 = IteratorFind(dp, arr[i]);
                System.out.println(i1);
                dp.set(i1, arr[i]);
                pos.set(i1, i);
                if (i1 != 0) {
                    idx[i] = pos.get(i1-1);
                }else{
                    idx[i] = 0;
                }
            }
        }
        System.out.println(dp.toString());
        System.out.println(Arrays.toString(idx));
    }

    private static int IteratorFind(List<Integer> dp, int target) {
        int left = 0; int right = dp.size() - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (target < dp.get(mid)) {
                right = mid - 1;
            } else if (target == dp.get(mid)) {
                return mid;
            }else {
                left = mid;
            }
        }
        return left;
    }


}
