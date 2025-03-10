package org.example.spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;

/**
 * @author xianr
 * @date 2023-10-25
 * @Description TODO
 */
public class AspectClass {
    @Before("execution(* com.example.TargetClass.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("Before advice: " + joinPoint.getSignature().getName());
    }
    @After("execution(* com.example.TargetClass.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("After advice: " + joinPoint.getSignature().getName());
    }
}
