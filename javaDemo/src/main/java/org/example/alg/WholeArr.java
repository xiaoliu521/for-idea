package org.example.alg;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xianr
 * @date 2023-10-24
 * @Description TODO
 */
public class WholeArr {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        WholeArr wholeArr = new WholeArr();
        boolean complete_array = wholeArr.is_complete_array(arr);

    }


    private boolean is_complete_array(int[] arr){
        HashSet set = new HashSet();
        for (int i = 1; i <= arr.length; i++) {
            set.add(i);
        }

        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(arr[i])) {
                return false;
            }else{
                set.remove(arr[i]);
            }
        }
        return true;
    }
}
