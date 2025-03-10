package org.example;

/**
 * @author xianr
 * @date 2023-09-16
 * @Description TODO
 */
public class DoublePoint {

    public static boolean isSplitable(String s) {
        // --- write your code here ---
//        11133322111111
//        000111000
        int left = 0;
        int twoCount = 0;
        for (int i = 1; i < s.length(); i++) {
            if(i == s.length() -1){
                if((i + 1 - left) % 3 == 2){
                    twoCount++;
                    if(twoCount > 1){
                        return false;
                    }
                }else if((i + 1-left) % 3 == 0){
                    left = i;
                }else{
                    return false;
                }
            }

            int max1 = 0, max2 = 0;
            if (s.charAt(i) != s.charAt(left)){
                System.out.println(s.charAt(left));
                if((i - left) % 3 == 2){
                    twoCount++;
                    if(twoCount > 1){
                        return false;
                    }
                    left = i;
                }else if((i-left) % 3 == 0){
                    left = i;
                }else{
                    return false;
                }
            }
        }
        if(twoCount != 1){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(DoublePoint.class.getSimpleName());
////        System.out.println(isSplitable("11133322111111"));
//        System.out.println(isSplitable("11188877766666633322222233322222211133333377799955544411122233344422244433377788855588855555577766699911166644444499933399999911111199988866688844411"));

//        int[] a = {2, 1, 6, 9, 7, 4};
        int[] a = {2, 1, 6, 12, 11, 12};
        System.out.println(sumOfDifferences(a));
    }


    public static int sumOfDifferences(int[] arr) {
        int max1 = 0, max2 = 0;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max1){
                max2 = max1;
                max1 = arr[i];
            }else  if (arr[i] > max2 && arr[i] != max1) {
                max2 = arr[i];
            }

            if(arr[i] < min1){
                min2 = min1;
                min1 = arr[i];
            }else if (arr[i] < min2 && arr[i] != min1) {
                min2 = arr[i];
            }
        }

        return max1 -min1 + max2 - min2;
    }
}
