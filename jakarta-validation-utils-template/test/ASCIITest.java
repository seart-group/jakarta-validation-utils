package ch.usi.si.seart.validation.constraints;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import ${jakarta.validation.basePackage}.ConstraintViolation;
import java.util.Set;

class ASCIITest extends BaseTest {

    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    private static final class Contract {
        @ASCII
        String string;
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "Sverige är vackert ö",
        "J'aime le français",
        "你好",
        "नमस्ते",
        "Привет",
        "Γεια σας",
        "გამარჯობა",
        "안녕하세요",
        "สวัสดีค่ะ",
        "مرحبا",
        "こんにちは",
        "\uD83E\uDDD1\uD83C\uDFFB\u200D\uD83D\uDCBB",
    })
    void invalidTest(String value) {
        Set<ConstraintViolation<Contract>> violations = validator.validate(new Contract(value));
        Assertions.assertFalse(violations.isEmpty());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
        " ",
        "\t",
        "\n",
        "\r",
        "hello world",
        "Hello World",
        "Hello, World!",
    })
    void validTest(String value) {
        Set<ConstraintViolation<Contract>> violations = validator.validate(new Contract(value));
        Assertions.assertTrue(violations.isEmpty());
    }
}
