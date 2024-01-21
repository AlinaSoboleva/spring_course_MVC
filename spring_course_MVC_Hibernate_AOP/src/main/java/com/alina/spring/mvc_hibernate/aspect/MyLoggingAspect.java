package com.alina.spring.mvc_hibernate.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class MyLoggingAspect {

    @Around("@annotation(com.alina.spring.mvc_hibernate.aspect.RepositoryLog)")
    public Object aroundAllRepositoryMethodsAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();
        System.out.println(LocalDateTime.now() + " INFO Begin of " + methodName);

        Object targetMethodResult = proceedingJoinPoint.proceed();

        System.out.println(LocalDateTime.now() + " INFO End of " + methodName);

        return targetMethodResult;
    }
}
