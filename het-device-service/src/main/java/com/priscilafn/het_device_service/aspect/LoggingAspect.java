package com.priscilafn.het_device_service.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    //Pointcut: All methods in all classes inside the service package
    @Pointcut("execution(* com.priscilafn.het_device_service.service.*.*(..))")
    public void serviceMethods() {}

    /*This is just an example of how to centralize the application logs with AOP.
    When implementing something like this in real applications, be mindful to mask
    possible sensitive data from the logs */
    @Before("serviceMethods()")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Called service method: {} with arguments: {}",
                joinPoint.getSignature().getName(), joinPoint.getArgs());
    }

    @AfterReturning(pointcut = "serviceMethods()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("Service method: {} returned: {}", joinPoint.getSignature().getName(), result);
    }
}
