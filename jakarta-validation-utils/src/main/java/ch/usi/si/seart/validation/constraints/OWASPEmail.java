package ch.usi.si.seart.validation.constraints;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
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
 * The string has to be an email address compliant with OWASP's recommended practices. Accepts {@code CharSequence}.
 * <p>
 * {@code null} elements are considered valid.
 *
 * @see <a href="https://owasp.org/www-community/OWASP_Validation_Regex_Repository">OWASP Validation Regex Repository</a>
 * @see <a href="https://www.debuggex.com/r/hqu5CxrBMdxdwifC">Regex Definition</a>
 * @author Ozren Dabić
 * @since 0.1.0
 */
@Documented
@Size(min = 7, max = 256)
@Email(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$")
@Constraint(validatedBy = {})
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@ReportAsSingleViolation
public @interface OWASPEmail {

    String message() default "{ch.usi.si.seart.validation.constraints.OWASPEmail.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
