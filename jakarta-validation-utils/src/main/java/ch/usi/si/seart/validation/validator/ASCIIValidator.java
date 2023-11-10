package ch.usi.si.seart.validation.validator;

import ch.usi.si.seart.validation.constraints.ASCII;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.nio.charset.StandardCharsets;

public class ASCIIValidator implements ConstraintValidator<ASCII, CharSequence> {

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        return value == null || StandardCharsets.US_ASCII.newEncoder().canEncode(value);
    }
}
