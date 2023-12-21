/*
 * DO NOT EDIT THIS FILE MANUALLY! IT IS MACHINE GENERATED!
 *
 * MIT License
 *
 * Copyright (c) 2023-present SEART Research Group and Contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package ch.usi.si.seart.validation.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
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
 * The string has to be a GitHub Personal Access Token (PAT). Accepts {@code CharSequence}.
 * <p>
 * {@code null} elements are considered valid.
 *
 * @see <a href="https://gist.github.com/magnetikonline/073afe7909ffdd6f10ef06a00bc3bc88">GitHub token validation regular expressions</a>
 * @author Ozren Dabić
 * @since 0.3.0
 */
@Documented
@Constraint(validatedBy = {})
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
public @interface GitHubPAT {

    /**
     * @return The {@code Type} of the annotated element.
     */
    Type type() default Type.REGULAR;

    /**
     * Represents a personal access token type.
     */
    enum Type {

        /**
         * User-generated <em>classic</em> access tokens.
         */
        REGULAR("^ghp_[a-zA-Z0-9]{36}$"),

        /**
         * Tokens used in GitHub actions.
         */
        ACTION("^ghs_[a-zA-Z0-9]{36}$"),

        /**
         * <em>Fine-grained</em> access tokens.
         */
        FINE_GRAINED("^github_pat_[a-zA-Z0-9]{22}_[a-zA-Z0-9]{59}$");

        private final String regexp;

        Type(String regexp) {
            this.regexp = regexp;
        }

        public String getRegexp() {
            return regexp;
        }
    }

    String message() default "{ch.usi.si.seart.validation.constraints.GitHubPAT.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
