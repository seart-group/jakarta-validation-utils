package ch.usi.si.seart.validation.constraints;

import ${jakarta.validation.basePackage}.Constraint;
import ${jakarta.validation.basePackage}.Payload;
import ${jakarta.validation.basePackage}.constraints.Pattern;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * The string has to be a valid semantic version tag. Accepts {@code CharSequence}.
 * <p>
 * {@code null} elements are considered valid.
 *
 * @see <a href="https://www.debuggex.com/r/zQAnYBylpPQh6vf8">Regex Definition</a>
 * @see <a href="https://semver.org/#is-there-a-suggested-regular-expression-regex-to-check-a-semver-string">SemVer Documentation</a>
 * @author Ozren Dabić
 * @since 0.4.0
 */
@Documented
@Pattern(
        regexp = "^v?(0|[1-9]\\d*)\\.(0|[1-9]\\d*)\\.(0|[1-9]\\d*)"
                + "(?:-((?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*)"
                + "(?:\\.(?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*))*))?"
                + "(?:\\+([0-9a-zA-Z-]+(?:\\.[0-9a-zA-Z-]+)*))?$"
)
@Constraint(validatedBy = {})
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
public @interface SemanticVersion {

    String message() default "{ch.usi.si.seart.validation.constraints.SemanticVersion.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
