package lotto.validator;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseAmountValidatorTest {
    private final PurchaseAmountValidator validator = new PurchaseAmountValidator();

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "  "})
    void 입력값이_null이거나_빈_값일_경우_예외가_발생한다(String input) {
        assertThatThrownBy(() -> validator.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "1000qwer", "1,000"})
    void 숫자가_아닌_값이_입력되면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> validator.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 999, 123})
    void 구입_금액이_1000원_미만일_경우_예외가_발생한다(int amount) {
        assertThatThrownBy(() -> validator.validateAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1230, 2340, 3355, 2001})
    void 구입_금액이_1000원_단위가_아니면_예외가_발생한다(int amount) {
        assertThatThrownBy(() -> validator.validateAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}