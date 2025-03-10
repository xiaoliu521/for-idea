package org.example.OOP;

import java.util.Objects;

/**
 * @author xianr
 * @date 2023-09-16
 * @Description TODO
 */
public class Main {

    public static void main(String[] args) {
        Object object1 = new Student();
        Object object2 = new Teacher();
        System.out.println(determineUserName(object1, object2));
    }

    public static boolean determineUserName(Object object1, Object object2) {
        String simpleName1 = object1.getClass().getSimpleName();
        String simpleName2 = object2.getClass().getSimpleName();
        System.out.println(object1.getClass().getSimpleName().equals(object2.getClass().getSimpleName()));
//        if(simpleName1.equals(simpleName2)){
        if(object1.getClass().getSimpleName().equals(object2.getClass().getSimpleName())){
           return true;
        }
        return false;
    }
}
