package ch.usi.si.seart.validation.constraints;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import javax.validation.ConstraintViolation;
import java.util.Set;

class PasswordTest extends BaseTest {

    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    private static final class Contract {
        @Password(
                requirements = {
                        Password.Requirement.NUMBER,
                        Password.Requirement.SYMBOL,
                        Password.Requirement.LOWERCASE_LETTER,
                        Password.Requirement.UPPERCASE_LETTER,
                },
                maxLength = 20
        )
        String password;
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            "GG&j8Uw,eeZ53@6CnyD8|J?EX",
            "IAMSHOUTING",
            "ThisThing",
            "password",
            "0123456",
            "7ATE9",
            "aA0",
    })
    void invalidTest(String value) {
        Set<ConstraintViolation<Contract>> violations = validator.validate(new Contract(value));
        Assertions.assertFalse(violations.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "G&j8UweeZ3@6nD8|J?X",
            "This Is A Test 123",
            "With1SpecialChar!",
    })
    void validTest(String value) {
        Set<ConstraintViolation<Contract>> violations = validator.validate(new Contract(value));
        Assertions.assertTrue(violations.isEmpty());
    }
}
