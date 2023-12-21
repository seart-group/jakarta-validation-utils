package ch.usi.si.seart.validation.constraints;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import ${jakarta.validation.basePackage}.ConstraintViolation;
import java.util.Set;

class GitHubPATTest extends BaseTest {

    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    private static final class Contract {
        @GitHubPAT
        String string;
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {
        " ",
        "dVOlIJdpOoAJHyLLnBovTzhgEzm7xN54Cx3KxvKB",
    })
    void invalidTest(String value) {
        Set<ConstraintViolation<Contract>> violations = validator.validate(new Contract(value));
        Assertions.assertFalse(violations.isEmpty());
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = { "ghp_uijz0kVyO92vXELQ5sEPpNsvtRpARisu1Uuh" })
    void validTest(String value) {
        Set<ConstraintViolation<Contract>> violations = validator.validate(new Contract(value));
        Assertions.assertTrue(violations.isEmpty());
    }
}
