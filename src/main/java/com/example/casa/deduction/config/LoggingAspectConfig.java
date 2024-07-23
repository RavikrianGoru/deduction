package com.example.casa.deduction.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.AfterThrowing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Configuration
public class LoggingAspectConfig {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspectConfig.class);
    private static final Logger auditLogger = LoggerFactory.getLogger("AUDIT");

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

        Map<String, Object> logDetails = new HashMap<>();
        logDetails.put("method", methodName);
        logDetails.put("requestPayload", requestPayload);
        logDetails.put("responsePayload", responsePayload);
        logDetails.put("executionTime", executionTime + "ms");

        logger.info("Method: {} | Execution Time: {} ms", methodName, executionTime);
        auditLogger.info("Audit Log: {}", logDetails);

        return proceed;
    }

    @AfterThrowing(pointcut = "execution(* com.example.casa.deduction.controller..*(..))", throwing = "exception")
    public void logAfterThrowing(Throwable exception) {
        logger.error("Exception in method execution: {}", exception.getMessage());
        auditLogger.error("Audit Exception Log: {}", exception.getMessage());
    }
}
