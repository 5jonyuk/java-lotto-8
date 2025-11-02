package lotto.validator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CommonInputValidatorTest {
    CommonInputValidator commonInputValidator = new CommonInputValidator();

    @ParameterizedTest
    @ValueSource(strings = {"a", ",", "!"})
    void 숫자를_입력하지_않으면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> commonInputValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 빈_값이나_공백을_입력하면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> commonInputValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}