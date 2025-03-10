//package org.example.proxy;
//
//
//import org.springframework.cglib.proxy.Enhancer;
//import org.springframework.cglib.proxy.MethodInterceptor;
//import org.springframework.cglib.proxy.MethodProxy;
//
//import java.lang.reflect.Method;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.regex.Pattern;
//
///**
// * @author xianr
// * @date 2023-11-23
// * @Description TODO
// */
//public class TestCglib{
//
//    public static Object createCglibProxyObj(Class<?> clazz){
//        Enhancer enhancer = new Enhancer();
//        // 为加强器指定要代理的业务类（即为下面生成的代理类指定父类）
//        enhancer.setSuperclass(clazz);
//        // 设置回调： 对于代理类上所有方法的调用，都会调用Callback, 而Callback则需要实现intercept()方法
//        enhancer.setCallback(new ProxyInterceptor());
//        return enhancer.create();
//    }
//
//    public static void main(String[] args) {
//        LinkedList<Object> objects = new LinkedList<>();
//        objects.set(123, "dasad");
//        System.out.println(objects);
//
//        Student cglibProxyObj = (Student) TestCglib.createCglibProxyObj(Student.class);
//        cglibProxyObj.handout();
//    }
//}
//
//
//
//class ProxyInterceptor implements MethodInterceptor {
//    @Override
//    public Object intercept(Object o, Method method, Object[] params, MethodProxy methodProxy) throws Throwable {
//        System.out.println("【增强方法】代理对象正在执行的方法：" + method.getName());
//        Object result = methodProxy.invokeSuper(o, params);
//        return result;
//    }
//}
//class Student{
//
//    public void handout(){
//        System.out.println("学生交作业");
//    }
//}
//
//
