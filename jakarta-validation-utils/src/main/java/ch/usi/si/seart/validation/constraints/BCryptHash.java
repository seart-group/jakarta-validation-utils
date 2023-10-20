package ch.usi.si.seart.validation.constraints;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Pattern;
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
 * The string has to be a valid bcrypt hash value. Accepts {@code CharSequence}.
 * <p>
 * {@code null} elements are considered valid.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Bcrypt">bcrypt</a>
 * @see <a href="https://www.debuggex.com/r/DLxkWMzmmeSbC3QH">Regex Definition</a>
 * @author Ozren Dabić
 * @since 0.1.0
 */
@Documented
@Pattern(regexp = "^\\$2[aby]?\\$\\d{1,2}\\$[./A-Za-z0-9]{53}$")
@Constraint(validatedBy = {})
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
public @interface BCryptHash {

    String message() default "{ch.usi.si.seart.validation.constraints.BCryptHash.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
