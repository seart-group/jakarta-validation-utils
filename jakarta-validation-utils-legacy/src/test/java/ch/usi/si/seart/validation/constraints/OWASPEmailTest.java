package ch.usi.si.seart.validation.constraints;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import javax.validation.ConstraintViolation;
import java.util.Set;

class OWASPEmailTest extends BaseTest {

    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    private static final class Contract {
        @OWASPEmail
        String email;
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {
            " ",
            "a@b.xy",
            "username",
            "@domain.xy",
            "username@domain",
            ".username@domain.xy",
            "username.@domain.xy",
            "username@domain.xy.",
    })
    void invalidTest(String value) {
        Set<ConstraintViolation<Contract>> violations = validator.validate(new Contract(value));
        Assertions.assertFalse(violations.isEmpty());
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = { "dabico@usi.ch", "ozren.dabic@usi.ch" })
    void validTest(String value) {
        Set<ConstraintViolation<Contract>> violations = validator.validate(new Contract(value));
        Assertions.assertTrue(violations.isEmpty());
    }
}
