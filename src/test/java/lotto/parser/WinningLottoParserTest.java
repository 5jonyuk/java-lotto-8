package lotto.parser;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoParserTest {
    WinningLottoParser winningLottoParser = new WinningLottoParser();

    @Test
    void 쉼표로_구분된_문자열을_정수형리스트로_변환한다() {
        String input = "1,2,3,4,5,6";
        List<Integer> parsedInput = winningLottoParser.parseWinningNumbers(input);
        assertThat(parsedInput).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

}