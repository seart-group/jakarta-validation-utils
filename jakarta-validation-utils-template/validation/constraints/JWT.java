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
 * The string has to be a valid JSON Web Token (JWT),
 * formatted as base64url encoded strings separated into segments by dots.
 * Accepts {@code CharSequence}.
 * <p>
 * {@code null} elements are considered valid.
 *
 * @see <a href="https://www.debuggex.com/r/kisWykir_CdukRge">Regex Definition</a>
 * @author Ozren Dabić
 * @since 0.5.0
 */
@Documented
@Pattern(regexp = "^e[yw][\\w-]+\\.(?:e[yw][\\w-]+)?\\.[\\w-]{2,}(?:(?:\\.[\\w-]{2,}){2})?$")
@Constraint(validatedBy = {})
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
public @interface JWT {

    String message() default "{ch.usi.si.seart.validation.constraints.JWT.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
