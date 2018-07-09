package my.pinkyo.demo.valiation;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.NotNull;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = AlphaDigitOnlyValidator.class)
@Documented
@ReportAsSingleViolation
@NotBlank
public @interface AlphaDigitOnly {
    String message() default "can only have alpha digit.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    /**
     * Defines several {@link NotNull} annotations on the same element.
     *
     * @see javax.validation.constraints.NotNull
     */
    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
    @Retention(RUNTIME)
    @Documented
    @interface List {

        NotNull[] value();
    }
}