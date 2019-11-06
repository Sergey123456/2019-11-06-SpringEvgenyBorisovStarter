package com.borisov.starter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

//@Aspect
//@Component
//public class ControllerWrapper {
//    @Pointcut("within(@com.borisov.starter.MyWrapperForController *)")
//    public void anyControllerPointcut() {
//    }
//
//    @Pointcut("execution(* *(..))")
//    public void anyMethodPointcut() {
//    }
//
//    @Around("anyControllerPointcut() && anyMethodPointcut()")
//    public Object aroundFunction(ProceedingJoinPoint joinPoint) throws Throwable {
//        try {
//            System.out.println("Function");
//            Object res = joinPoint.proceed();
//            Map<String, Object> map = new HashMap<>();
//            map.put("info", "My info");
//            map.put("response", res);
//            return map;
//        } catch (Exception e) {
//            throw e;
//        }
//    }
//
//}
