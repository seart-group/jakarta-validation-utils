package ch.usi.si.seart.validation.constraints;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import javax.validation.ConstraintViolation;
import java.util.Set;

class NullOrNotBlankTest extends BaseTest {

    @AllArgsConstructor
    private static final class Contract {
        @NullOrNotBlank
        String token;
    }

    @ParameterizedTest
    @EmptySource
    void invalidTest(String value) {
        Set<ConstraintViolation<Contract>> violations = validator.validate(new Contract(value));
        Assertions.assertFalse(violations.isEmpty());
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = { "m", "token", "<MASK>", "!", "1234" })
    void validTest(String value) {
        Set<ConstraintViolation<Contract>> violations = validator.validate(new Contract(value));
        Assertions.assertTrue(violations.isEmpty());
    }
}
