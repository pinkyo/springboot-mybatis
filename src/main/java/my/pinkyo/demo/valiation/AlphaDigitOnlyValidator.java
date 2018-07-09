package my.pinkyo.demo.valiation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class AlphaDigitOnlyValidator implements ConstraintValidator<AlphaDigitOnly, CharSequence> {
    @Override
    public void initialize(AlphaDigitOnly constraintAnnotation) {
        // do nothing.
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        if (Objects.nonNull(value)
            && !value.toString().matches("[a-zA-Z0-9]*")) {
            return false;
        }
        return true;
    }
}
