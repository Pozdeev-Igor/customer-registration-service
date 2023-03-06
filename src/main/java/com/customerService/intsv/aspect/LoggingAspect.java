package com.customerService.intsv.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Aspect
@Component
public class LoggingAspect {
    @Pointcut("within(com.customerService.intsv.controller.*)")
    public void controllers() {

    }

    @Around("controllers()")
    public ResponseEntity<?> loggingRequestAndResponse(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Parameter[] parameters = methodSignature.getMethod().getParameters();
        Object[] parameterValues = joinPoint.getArgs();
        Map<String, String> parameterNamesAndValues = new HashMap<>();
        for (int i = 0; i < parameters.length; i++) {
            if (parameters[i].isAnnotationPresent(PathVariable.class) ||
                    parameters[i].isAnnotationPresent(RequestParam.class)) {
                parameterNamesAndValues.put(parameters[i].getName(), parameterValues[i].toString());
            }
        }
        log.info("Enter: {}. {}(): argument[s] {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), parameterNamesAndValues);

        ResponseEntity<?> result = (ResponseEntity<?>) joinPoint.proceed();
        log.info("Exit: {}. {}(): result {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), result.getStatusCode());
        return result;

    }
}