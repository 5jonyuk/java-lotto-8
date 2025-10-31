package lotto.util;

import java.util.List;
import java.util.stream.Collectors;

public class FormatLottoNumbers {
    public String format(List<Integer> numbers) {
        return String.format("[%s]",
                numbers.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", "))
        );
    }
}
