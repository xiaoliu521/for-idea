//package org.example.spring;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
///**
// * @author xianr
// * @date 2023-10-25
// * @Description TODO
// */
//public class TestClass {
//
//    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        TargetClass target = (TargetClass) context.getBean("target");
//        int result1 = target.doAdd(2, 3);
//        int result2 = target.doSubtract(5, 2);
//        System.out.println("Result 1: " + result1);
//        System.out.println("Result 2: " + result2);
//    }
//}
