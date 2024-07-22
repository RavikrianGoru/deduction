package com.example.casa.deduction.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@Configuration
public class LoggingAspectConfig {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspectConfig.class);

    @Around("execution(* com.example.casa.deduction.controller..*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object proceed = joinPoint.proceed();

        stopWatch.stop();
        long executionTime = stopWatch.getTotalTimeMillis();

        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        String requestPayload = args != null ? args.toString() : "No payload";

        Object response = proceed instanceof ResponseEntity ? ((ResponseEntity<?>) proceed).getBody() : proceed;
        String responsePayload = response != null ? response.toString() : "No response";

        logger.info("Method: {} | Request Payload: {} | Response Payload: {} | Execution Time: {} ms",
                    methodName, requestPayload, responsePayload, executionTime);

        return proceed;
    }
}
