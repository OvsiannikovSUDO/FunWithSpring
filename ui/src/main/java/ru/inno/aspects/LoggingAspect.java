package ru.inno.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component

public class LoggingAspect {

    @Around("@annotation(PerfLogging)")
    public Object invoke(final ProceedingJoinPoint invocation) throws Throwable {
        log.info("Method invoked: {}", invocation.getSignature().getName());
        final long start = System.currentTimeMillis();
        final var result = invocation.proceed();
        log.info("Method stats: {}, execution time: {}", invocation.getSignature().getName(), System.currentTimeMillis() - start);
        return result;
    }
}
