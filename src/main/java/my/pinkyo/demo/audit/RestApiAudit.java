package my.pinkyo.demo.audit;

import java.lang.annotation.*;

/**
 * This annotation is used to mark audit log.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RestApiAudit {
    String value() default "UNKNOWN";
}
