package org.example.alg;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author xianr
 * @date 2023-10-17
 * @Description 最小覆盖子串
 */
public class Leetcode76 {
    Map<Character, Integer> ori = new HashMap<>();
     Map<Character, Integer> cnt = new HashMap<>();


    public  String minWindow(String s, String t) {
        Integer tlen = t.length();
        for(int i=0; i< tlen; i++){
            char c = t.charAt(i);
            if (ori.containsKey(c)) {
                ori.put(c, ori.get(c) + 1);
            }else {
                ori.put(c, 1);
            }
        }
        int mLen = Integer.MAX_VALUE;
        int ansl = -1, ansr = -1;
        int l = 0, r = -1;
        int slen = s.length();
        // 如果区域不包含t串，r右移，否则l左移;
        while (r < slen) {
            r++;
            if (r < slen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (checkContains() && l <= r) {
                // 判断是否是最短子串
                if (r - l + 1 < mLen) {
                    mLen = r - l + 1;
                    ansl = l;
                    ansr = l + mLen;
                }
                System.out.println("r" + r + "**" + "l" + l);
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.get(s.charAt(l)) - 1);
                }
                l++;
            }
        }

        return ansr == -1 ? "" : s.substring(ansl, ansr);
    }

    private  boolean checkContains() {
        Iterator<Map.Entry<Character, Integer>> iterator = ori.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> next = iterator.next();
            Character key = next.getKey();
            Integer value = next.getValue();
            if (cnt.getOrDefault(key, 0) < value) {
                // 不包含
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcode76 leetcode76 = new Leetcode76();
//        String s = "ADOBECODEBANC";
//        String t = "ABC";
        String s = "a";
        String t = "aa";
        String s1 = leetcode76.minWindow(s, t);
        System.out.println(s1);
    }
}
