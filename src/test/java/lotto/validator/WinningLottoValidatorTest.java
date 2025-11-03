package lotto.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoValidatorTest {
    WinningLottoValidator winningLottoValidator = new WinningLottoValidator();
    private List<Integer> winningNumbers;

    @Test
    void 당첨번호는_쉼표로_구분_되어야_한다() {
        String winningNumbers = "1,2,3,4,5,6";

        List<Integer> numbers = winningLottoValidator.validateWinningNumbers(winningNumbers);

        assertThat(numbers).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 2 3 4 5 6", "1,2,3,4,5,6,,,", "1,2,3,4,5,6;7"})
    void 당첨번호가_쉼표로_구분되지_않으면_예외가_발생한다(String winningNumbers) {
        assertThatThrownBy(() -> winningLottoValidator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "11,12,13,14,15,16", "21,22,23,24,25,26"})
    void 당첨번호의_갯수는_6개이여야_한다(String winningNumbers) {
        List<Integer> numbers = winningLottoValidator.validateWinningNumbers(winningNumbers);

        assertThat(numbers.size()).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3", "1,2,3,11"})
    void 당첨번호가_6개보다_적으면_예외가_발생한다(String winningNumbers) {
        assertThatThrownBy(() -> winningLottoValidator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7", "1,2,3,4,5,6,7,21"})
    void 당첨번호가_6개보다_많으면_예외가_발생한다(String winningNumbers) {
        assertThatThrownBy(() -> winningLottoValidator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "13,21,24,25,29,36", "14,23,28,39,40,43"})
    void 당첨번호의_범위는_1에서_45까지이다(String winningNumbers) {
        List<Integer> numbers = winningLottoValidator.validateWinningNumbers(winningNumbers);

        assertThat(numbers).allMatch(number -> number >= 1 && number <= 45);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,46", "0,2,3,4,5,6", "1,2,3,4444,5,6,11"})
    void 당첨번호의_범위를_벗어나면_예외가_발생한다(String winningNumbers) {
        assertThatThrownBy(() -> winningLottoValidator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호가_중복되지_않으면_성공적으로_당첨번호를_반환한다(){
        String winningNumbers = "1,2,3,4,5,6";
        List<Integer> numbers = winningLottoValidator.validateWinningNumbers(winningNumbers);
        assertThat(numbers).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 당첨번호가_중복되면_예외가_발생한다(){
        String winningNumbers = "1,2,3,4,5,5";

        assertThatThrownBy(() -> winningLottoValidator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @BeforeEach
    void 당첨번호_초기화() {
        winningNumbers = List.of(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 보너스번호의_범위는_1에서부터_45까지이다() {
        String bonusNumber = "7";

        assertThat(winningLottoValidator.validateBonusNumber(bonusNumber, winningNumbers)).isEqualTo(7);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "46"})
    void 보너스번호의_범위를_벗어나면_예외가_발생한다(String bonusNumber) {
        assertThatThrownBy(() -> winningLottoValidator.validateBonusNumber(bonusNumber, winningNumbers));
    }

    @Test
    void 보너스번호가_당첨번호와_중복되면_예외가_발생한다() {
        String bonusNumber = "6";

        assertThatThrownBy(() -> winningLottoValidator.validateBonusNumber(bonusNumber, winningNumbers));
    }
}