package lotto.parser;

import java.util.Arrays;
import java.util.List;

public class WinningLottoParser {
    private static final String LOTTO_NUMBER_SEPARATOR = ",";

    public List<Integer> parseWinningNumbers(String input) {
        return Arrays.stream(input.split(LOTTO_NUMBER_SEPARATOR,-1))
                .map(Integer::parseInt)
                .toList();
    }
}
