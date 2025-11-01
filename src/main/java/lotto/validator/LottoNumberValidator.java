package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumberValidator {
    private static final String ERROR_MESSAGE_LOTTO_NUMBER_SIZE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String ERROR_MESSAGE_LOTTO_NUMBER_DUPLICATE = "[ERROR] 로또 번호 중복될 수 없습니다.";
    private static final String ERROR_MESSAGE_LOTTO_NUMBER_RANGE = "[ERROR] 로또 번호는 1~45 사이 숫자여야 합니다.";

    public static void validate(List<Integer> numbers) {
        validateLottoNumberSize(numbers);
        validateLottoNumberDuplicate(numbers);
        validateLottoNumberRange(numbers);
    }

    private static void validateLottoNumberSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE_LOTTO_NUMBER_SIZE);
        }
    }

    private static void validateLottoNumberDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_LOTTO_NUMBER_DUPLICATE);
        }
    }

    private static void validateLottoNumberRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ERROR_MESSAGE_LOTTO_NUMBER_RANGE);
            }
        });
    }
}
