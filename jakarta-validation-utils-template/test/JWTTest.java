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

class JWTTest extends BaseTest {

    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    private static final class Contract {
        @JWT
        String token;
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {
        "e",
        "eeeee",
        "e.e",
        "e.e.e",
        "ewas.ey.eya",
        "ew.eyas.eya",
        "eyWboXzPFAxtcxDI3H22Kl6xZxD2thKu0shGeyTVM55NIDFtnaC30wzWOTasev46W6daFNH56dctBgmikbUPnC5MfLkMdceoH48wgRQaW",
        "eyWboXzPFAxtcxDI3H22Kl6xZxD2thKu0shG.eyTVM55NIDFtnaC30wzWOTasev46W6daFNH56dctBgmikbUPnC5MfLkMdceoH48wgRQaW",
        "eyWboXzPFAxtcxDI3H22Kl6xZxD2thKu0shGeyTVM55NIDFtnaC30wzWOTas.ev46W6daFNH56dctBgmikbUPnC5MfLkMdceoH48wgRQaW",
    })
    void invalidTest(String token) {
        Set<ConstraintViolation<Contract>> violations = validator.validate(new Contract(token));
        Assertions.assertFalse(violations.isEmpty());
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {
        "eyWboXzPFAxtcxDI3H22Kl6xZxD2thKu0shG.eyTVM55NIDFtnaC30wzWOTas.ev46W6daFNH56dctBgmikbUPnC5MfLkMdceoH48wgRQaW",
        "eySauKZiPBAkSQyLabD5Stw8n5Q1Vg1mnjJ9.eyJpYXQiOjE1MTYyMzkwMjJ9.tbDepxpstvGdW8TC3G.GXD4VIsURPswauTcznGi.afnio",
    })
    void validTest(String token) {
        Set<ConstraintViolation<Contract>> violations = validator.validate(new Contract(token));
        Assertions.assertTrue(violations.isEmpty());
    }
}
