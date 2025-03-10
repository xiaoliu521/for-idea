package org.example.alg;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xianr
 * @date 2023-10-28
 * @Description TODO
 */
public class HexMagic {

    public static void main(String[] args) {
        HexMagic hexMagic = new HexMagic();
        String s = hexMagic.toHexspeak(7950);
        System.out.println(s);
    }
    public String toHexspeak(int n) {
        // write your code here
        String s = Integer.toHexString(n);
        System.out.println(s);
        StringBuilder sb = new StringBuilder(s);
        Map<Character, String> map = new HashMap();
        map.put('a', "A");
        map.put('b', "B");
        map.put('c', "C");
        map.put('d', "D");
        map.put('e', "E");
        map.put('f', "F");
        map.put('0', "O");
        map.put('1', "I");
        for (int i = 0; i < sb.length(); i++) {
            System.out.println(sb.charAt(i));
            if(map.containsKey(sb.charAt(i))){
                sb.replace(i, i+1,  map.get(sb.charAt(i)));
            }else{
                return "ERROR";
            }
        }
        return sb.toString();
    }

    /**
     * @param n: the positive number
     * @return: the string of hexspeak
     */
    public String toHexspeak2(int n) {
        // write your code here
        String s = Integer.toHexString(n);
        StringBuilder sb = new StringBuilder(s);
        HashMap<Character, String> map = new HashMap<>();
        map.put('a', "A");
        map.put('b', "B");
        map.put('c', "C");
        map.put('d', "D");
        map.put('e', "E");
        map.put('f', "F");
        map.put('0', "O");
        map.put('1', "I");
        for(int i=0;i<sb.length();i++){
            if(map.containsKey(sb.charAt(i))){
                sb.replace(i, i+1, map.get(sb.charAt(i)));
            }else{
                return "ERROR";
            }
        }
        return sb.toString();
    }
}
