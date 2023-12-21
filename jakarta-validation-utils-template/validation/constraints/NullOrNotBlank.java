package ch.usi.si.seart.validation.constraints;

import ${jakarta.validation.basePackage}.Constraint;
import ${jakarta.validation.basePackage}.Payload;
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
 * The string must either be null, or have a non-empty value.
 * This is a disjunction between {@link ${jakarta.validation.basePackage}.constraints.Null Null}
 * and {@link ${jakarta.validation.basePackage}.constraints.NotBlank NotBlank}.
 * Accepts {@code CharSequence}.
 *
 * @author Ozren Dabić
 * @since 0.1.0
 */
@Documented
@Constraint(validatedBy = {})
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
public @interface NullOrNotBlank {

    String message() default "{ch.usi.si.seart.validation.constraints.NullOrNotBlank.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
