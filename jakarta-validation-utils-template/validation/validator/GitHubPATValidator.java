package ch.usi.si.seart.validation.validator;

import ch.usi.si.seart.validation.constraints.GitHubPAT;

import ${jakarta.validation.basePackage}.ConstraintValidator;
import ${jakarta.validation.basePackage}.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class GitHubPATValidator implements ConstraintValidator<GitHubPAT, CharSequence> {

    private Pattern pattern;

    @Override
    public void initialize(GitHubPAT constraintAnnotation) {
        GitHubPAT.Type type = constraintAnnotation.type();
        pattern = Pattern.compile(type.getRegexp());
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        return value == null || pattern.matcher(value).matches();
    }
}
