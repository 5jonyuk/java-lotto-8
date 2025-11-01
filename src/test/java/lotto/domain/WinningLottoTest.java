package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {
    @Test
    void 입력되어_생성된_당청번호와_보너스번호는_정확히_그_값을_가진다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        assertThat(winningLotto.getWinningNumbers()).isEqualTo(winningNumbers);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(bonusNumber);
    }

    @Test
    void 생성된_당첨번호는_수정할_수_없다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        List<Integer> unmodifiableWinningNumbers = winningLotto.getWinningNumbers();

        assertThatThrownBy(() -> unmodifiableWinningNumbers.add(7))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}