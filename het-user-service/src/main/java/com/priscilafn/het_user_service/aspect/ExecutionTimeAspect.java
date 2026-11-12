package com.priscilafn.het_user_service.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Aspect
@Component
@Slf4j
public class ExecutionTimeAspect {

    //Pointcut: All methods in all classes inside the controller package
    @Pointcut("execution(* com.priscilafn.het_user_service.controller.*.*(..))")
    public void controllerMethods(){}

    @Around("controllerMethods()")
    public Object controllerMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();

        try{
            return joinPoint.proceed();
        }finally {
            long end = System.nanoTime();
            long duration = end - start;
            long durationInMs = TimeUnit.NANOSECONDS.toMillis(duration);
            log.info("Controller method {} executed in {} ms", joinPoint.getSignature().toShortString(), durationInMs);
        }
    }
}
