package my.pinkyo.demo.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggerAdvice {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerAdvice.class);

    @Around("execution(public * my.pinkyo.demo.controller..*.*(..))")
    public Object logMethodInvocation(ProceedingJoinPoint pjp) throws Throwable {
        try {
            Object[] args = pjp.getArgs();

            // log before enter
            LOGGER.debug("Thread[{}] start invoking method[{}] with args[{}]",
                    Thread.currentThread().getName(), pjp.getSignature().getDeclaringTypeName(),
                    Arrays.toString(args));

            Object result = pjp.proceed(args);

            // log after return
            LOGGER.debug("Thread[{}] finish invoking method[{}], return value[{}]",
                    Thread.currentThread().getName(), pjp.getSignature().getDeclaringTypeName(), result);

            return result;
        } catch (Exception e) {
            // log after throw
            LOGGER.debug(String.format("Thread[%s] fail to invoke method[%s]",
                    Thread.currentThread().getName(), pjp.getSignature().getDeclaringTypeName()), e);

            throw e; // rethrow exception
        }
    }
}