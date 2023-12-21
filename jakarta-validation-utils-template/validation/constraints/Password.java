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
 * The string has to be a well-formed password.
 * Exact semantics of what makes up a valid password are left to Jakarta Bean Validation providers.
 * By default, all passwords must consist of at least 6 of the following:
 *
 * <ul>
 *     <li>number</li>
 *     <li>lower-case character</li>
 *     <li>upper-case character</li>
 * </ul>
 *
 * We additionally provide an upper bound for the length, and a requirement of special symbols.
 * Accepts {@code CharSequence}.
 *
 * @author Ozren Dabić
 * @since 0.1.0
 */
@Documented
@Constraint(validatedBy = {})
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
public @interface Password {

    /**
     * @return The array of {@code Requirement} for the annotated element.
     */
    Requirement[] requirements() default {
        Requirement.NUMBER,
        Requirement.LOWERCASE_LETTER,
        Requirement.UPPERCASE_LETTER,
    };

    /**
     * Represents a password requirement.
     */
    enum Requirement {

        /**
         * Number requirement. Corresponds to the regular expression character class {@code [0-9]}.
         */
        NUMBER("\\d"),

        /**
         * Special symbol requirement. Includes the whitespace character, as well as the following:
         * {@code !"#$%&'()*+,-./:;<=>?@[\]^_`{|}~}
         */
        SYMBOL("[ !\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~]"),

        /**
         * Lower case letter requirement. Corresponds to the regular expression character class {@code [a-z]}.
         */
        LOWERCASE_LETTER("[a-z]"),

        /**
         * Upper case letter requirement. Corresponds to the regular expression character class {@code [A-Z]}.
         */
        UPPERCASE_LETTER("[A-Z]");

        private final String charClass;

        Requirement(String charClass) {
            this.charClass = charClass;
        }

        public String getRegexp() {
            return "(?=.*?" + charClass + ")";
        }
    }

    /**
     * @return The minimum password length. Can not be negative or zero.
     */
    int minLength() default 6;

    /**
     * @return The maximum password length. Can not be negative or zero.
     */
    int maxLength() default Integer.MAX_VALUE;

    String message() default "{ch.usi.si.seart.validation.constraints.Password.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
