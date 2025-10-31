package lotto.util;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FormatLottoNumbersTest {
    FormatLottoNumbers formatLottoNumbers = new FormatLottoNumbers();

    @Test
    void 정수_리스트를_포맷된_형식으로_반환한다() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        String formattedNumbers = formatLottoNumbers.format(numbers);
        assertThat(formattedNumbers).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}