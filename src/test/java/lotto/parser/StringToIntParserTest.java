package lotto.parser;

import lotto.parser.input.StringToIntParser;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringToIntParserTest {
    private final StringToIntParser parser = new StringToIntParser();

    @ParameterizedTest
    @CsvSource(value = {"'1000':1000", "'20000':20000", "'20':20"}, delimiter = ':')
    void 정수형태의_문자열을_정수로_변환한다(String input, int expected) {
        int parseNumber = parser.parseNumber(input);
        assertThat(parseNumber).isEqualTo(expected);
    }

}