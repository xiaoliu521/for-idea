package org.example.OOP;

import org.example.Person;

/**
 * @author xianr
 * @date 2023-09-11
 * @Description TODO
 */
public class Child  extends Person {
        public String grade = "初一";

        private String name = "大头";

//        Child(){
//            System.out.println("1");
////            super();
//        }

        public static void main(String[] args){
            Person p = new Child();
            Child c = new Child();
            System.out.println(c.getName());
//            System.out.println(p.name);
            System.out.println(c.grade);

        }
}
