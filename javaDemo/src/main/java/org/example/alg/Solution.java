package org.example.alg;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xianr
 * @date 2023-11-18
 * @Description TODO
 */ 
public class Solution {
    public static int maximumSum(int[] nums) {
        int maxSum = -1;
        Map<Integer, Integer> digitalSumMap = new HashMap<Integer, Integer>();
        for(int i=0; i< nums.length; i++){
            int digitalSum = 0;
            int num = nums[i];
            while(num != 0){
                digitalSum += num % 10;
                num /= 10;
            }
            if(!digitalSumMap.containsKey(digitalSum)){
                digitalSumMap.put(digitalSum, i);
            }else{
                Integer index =  digitalSumMap.get(digitalSum);
                int sum = nums[i] + nums[index];
                if(nums[i] > nums[index]){
                    digitalSumMap.put(digitalSum, i);
                }
                if(sum > maxSum){
                    maxSum = sum;
                }
            }

        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {383,77,97,261,102,344,150,130,55,337,401,498,21,5};
        System.out.println(new Solution().maximumSum(nums));
    }
}