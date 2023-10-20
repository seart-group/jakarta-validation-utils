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

public class BCryptHashTest extends BaseTest {

    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    private static final class Contract {
        @BCryptHash
        String hash;
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {
            "$2b$10$3euPcmQFCiblsZeEu5s7p.",
            "dffd6021bb2bd5b0af676290809ec3a53191dd81c7f70a4b28688a362182986f"
    })
    void invalidTest(String value) {
        Set<ConstraintViolation<Contract>> violations = validator.validate(new Contract(value));
        Assertions.assertFalse(violations.isEmpty());
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {
            "$2a$10$6BMb5Pwa7mPaiyoJ82za1.KTI0y7LrUHaHqpSlpww6EfPBDCK2t8O",
            "$2b$10$t7oxiwchWGHa/B9w0AzrYO2WH2rQbA86YSuQjSTmwIrpC/0ZXN7V2",
            "$2a$16$tWT6/T6RacmU9DhOD8NG4.wvCaVAPtveN/anQTv6ry/VmyOQk6G5."
    })
    void validTest(String value) {
        Set<ConstraintViolation<Contract>> violations = validator.validate(new Contract(value));
        Assertions.assertTrue(violations.isEmpty());
    }
}
