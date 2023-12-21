package ch.usi.si.seart.validation.constraints;

import lombok.Cleanup;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;
import org.junit.jupiter.api.BeforeAll;

import ${jakarta.validation.basePackage}.Validation;
import ${jakarta.validation.basePackage}.Validator;
import ${jakarta.validation.basePackage}.ValidatorFactory;

abstract class BaseTest {

    protected static Validator validator;

    @BeforeAll
    static void setUp() {
        @Cleanup ValidatorFactory factory = Validation.byDefaultProvider()
                .configure()
                .messageInterpolator(new ParameterMessageInterpolator())
                .buildValidatorFactory();
        validator = factory.getValidator();
    }
}
