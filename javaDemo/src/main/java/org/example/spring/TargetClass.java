package org.example.spring;

/**
 * @author xianr
 * @date 2023-10-25
 * @Description TODO
 */
public class TargetClass {
    public int doAdd(int a, int b) {
        System.out.println("TargetClass doAdd method called");
        return a + b;
    }
    public int doSubtract(int a, int b) {
        System.out.println("TargetClass doSubtract method called");
        return a - b;
    }

}
