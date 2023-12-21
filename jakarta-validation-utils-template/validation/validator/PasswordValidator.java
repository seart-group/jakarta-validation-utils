package ch.usi.si.seart.validation.validator;

import ch.usi.si.seart.validation.constraints.Password;

import ${jakarta.validation.basePackage}.ConstraintValidator;
import ${jakarta.validation.basePackage}.ConstraintValidatorContext;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PasswordValidator implements ConstraintValidator<Password, CharSequence> {

    private static final String TEMPLATE = "^%s.%s$";

    private int min;
    private int max;

    private Pattern pattern;

    @Override
    public void initialize(Password constraintAnnotation) {
        min = constraintAnnotation.minLength();
        max = constraintAnnotation.maxLength();
        validateParameters();
        String expressions = Stream.of(constraintAnnotation.requirements())
                .map(Password.Requirement::getRegexp)
                .collect(Collectors.joining());
        String size = (max < Integer.MAX_VALUE)
                ? "{" + min + "," + max + "}"
                : "{" + min + ",}";
        String regex = String.format(TEMPLATE, expressions, size);
        pattern = Pattern.compile(regex);
    }

    private void validateParameters() {
        if (min < 1) throw new IllegalArgumentException("The min parameter cannot be negative or zero.");
        if (max < 1) throw new IllegalArgumentException("The max parameter cannot be negative or zero.");
        if (max < min) throw new IllegalArgumentException("The length cannot be negative.");
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        return value != null && pattern.matcher(value).matches();
    }
}
