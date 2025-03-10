package org.example.alg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xianr
 * @date 2023-10-26
 * @Description TODO
 */
public class midTest {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 =  nums2.length;
        List<Integer> list = new LinkedList<>();
        int i = 0; int j = 0;
        while (i < len1 && j < len2){
            while (i < len1 && nums1[i] <= nums2[j]){
                list.add(nums1[i]);
                i++;
            }
            while (i < len1 && j < len2 &&  nums2[j] <= nums1[i]){
                list.add(nums2[j]);
                j++;
            }
        }
        while (i < len1){
            list.add(nums1[i]);
            i++;
        }
        while (j < len2){
            list.add(nums2[j]);
            j++;
        }
        int len = list.size();
        if(len % 2 == 0){
            int rmid = len / 2;
            int lmid = rmid -1;
            return (double) (list.get(rmid) + list.get(lmid)) /2;
        }else{
            return (double) list.get(len >> 1);
        }
    }

    public static void main(String[] args) {
        midTest midTest = new midTest();
        int[] num1 = {2};
        int[] num2 = {};
        double medianSortedArrays = midTest.findMedianSortedArrays(num1, num2);
        System.out.println(medianSortedArrays);
    }



}
