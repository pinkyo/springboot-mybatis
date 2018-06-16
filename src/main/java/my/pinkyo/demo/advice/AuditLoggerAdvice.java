package my.pinkyo.demo.advice;

import my.pinkyo.demo.audit.RestApiAudit;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.invoke.MethodHandles;

@Component
@Aspect
public class AuditLoggerAdvice {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @AfterReturning(value = "@annotation(audit)", returning = "result")
    public void auditLog(Object result, RestApiAudit audit) {
        LOGGER.info("{}, result={}", audit.value(), result);
    }
}
