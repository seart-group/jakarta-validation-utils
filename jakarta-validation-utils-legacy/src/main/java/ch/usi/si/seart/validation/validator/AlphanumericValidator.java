package ch.usi.si.seart.validation.validator;

import ch.usi.si.seart.validation.constraints.Alphanumeric;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AlphanumericValidator implements ConstraintValidator<Alphanumeric, CharSequence> {

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        return value == null || value.toString().chars().allMatch(Character::isLetterOrDigit);
    }
}
