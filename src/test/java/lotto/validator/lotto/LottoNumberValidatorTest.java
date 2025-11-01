package lotto.validator.lotto;

import lotto.validator.LottoNumberValidator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberValidatorTest {
    @Test
    void 로또번호가_6개가_초과되면_예외가_발생한다() {
        List<Integer> lottos = List.of(1, 2, 3, 4, 5, 6, 7);

        assertThatThrownBy(() -> LottoNumberValidator.validate(lottos))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또번호가_중복되면_예외가_발생한다() {
        List<Integer> lottos = List.of(1, 2, 3, 4, 5, 5);

        assertThatThrownBy(() -> LottoNumberValidator.validate(lottos))
                .isInstanceOf(IllegalArgumentException.class);
    }

}