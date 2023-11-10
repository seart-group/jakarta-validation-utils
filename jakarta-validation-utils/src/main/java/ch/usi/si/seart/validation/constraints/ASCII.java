package ch.usi.si.seart.validation.constraints;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
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
 * The string has to be comprised of ASCII characters. Accepts {@code CharSequence}.
 * <p>
 * {@code null} and blank elements are considered valid.
 *
 * @author Ozren Dabić
 * @since 0.2.0
 */
@Documented
@Constraint(validatedBy = {})
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
public @interface ASCII {

    String message() default "{ch.usi.si.seart.validation.constraints.ASCII.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
