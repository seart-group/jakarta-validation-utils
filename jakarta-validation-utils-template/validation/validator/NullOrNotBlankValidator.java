package ch.usi.si.seart.validation.validator;

import ch.usi.si.seart.validation.constraints.NullOrNotBlank;

import ${jakarta.validation.basePackage}.ConstraintValidator;
import ${jakarta.validation.basePackage}.ConstraintValidatorContext;

public class NullOrNotBlankValidator implements ConstraintValidator<NullOrNotBlank, CharSequence> {

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        return value == null || !value.toString().trim().isEmpty();
    }
}
