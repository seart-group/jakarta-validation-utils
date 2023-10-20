package ch.usi.si.seart.validation.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;
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
 * The string has to be a valid SHA hash value. Accepts {@code CharSequence}.
 * <p>
 * {@code null} elements are considered valid.
 *
 * @see <a href="https://www.debuggex.com/r/7QTTG9mm4UhyZ2_i">Regex Definition</a>
 * @author Ozren Dabić
 * @since 0.1.0
 */
@Documented
@Pattern(regexp = "^[0-9a-fA-F]{32,128}$")
@Constraint(validatedBy = {})
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
public @interface SHAHash {

    String message() default "{ch.usi.si.seart.validation.constraints.SHAHash.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
