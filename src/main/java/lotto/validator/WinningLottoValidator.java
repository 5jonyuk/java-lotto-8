package lotto.validator;

import lotto.parser.WinningLottoParser;
import lotto.parser.input.InputParser;
import lotto.parser.input.StringToIntParser;

import java.util.List;

public class WinningLottoValidator implements InputValidator {
    private static final String ERROR_MESSAGE_WINNING_NUMBER_SIZE = "[ERROR] 당첨 번호는 6개여야 합니다.";
    private static final String ERROR_MESSAGE_WINNING_NUMBER_RANGE = "[ERROR] 당첨 번호는 1~45 사이 숫자여야 합니다.";
    private static final String ERROR_MESSAGE_BONUS_DUPLICATE = "[ERROR] 보너스 번호는 당첨번호와 중복될 수 없습니다.";
    private static final String ERROR_MESSAGE_BONUS_RANGE = "[ERROR] 보너스 번호는 1~45 사이 숫자여야 합니다.";

    private final WinningLottoParser winningLottoParser = new WinningLottoParser();
    private final InputParser inputParser = new StringToIntParser();
    private final CommonInputValidator commonInputValidator = new CommonInputValidator();

    @Override
    public void validateInput(String input) {
        commonInputValidator.validate(input);
    }

    public List<Integer> validateWinningNumbers(String input) {
        validateWinningNumberInput(input);
        List<Integer> numbers = winningLottoParser.parseWinningNumbers(input);
        if (numbers.size() != 6) throw new IllegalArgumentException(ERROR_MESSAGE_WINNING_NUMBER_SIZE);
        numbers.forEach(n -> {
            if (n < 1 || n > 45) throw new IllegalArgumentException(ERROR_MESSAGE_WINNING_NUMBER_RANGE);
        });
        return numbers;
    }

    public int validateBonusNumber(String bonusInput, List<Integer> winningNumbers) {
        validateInput(bonusInput);
        int bonus = inputParser.parseNumber(bonusInput);
        if (bonus < 1 || bonus > 45) throw new IllegalArgumentException(ERROR_MESSAGE_BONUS_RANGE);
        if (winningNumbers.contains(bonus)) throw new IllegalArgumentException(ERROR_MESSAGE_BONUS_DUPLICATE);
        return bonus;
    }

    private void validateWinningNumberInput(String input){
        try {
            winningLottoParser.parseWinningNumbers(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표(,)로 구분된 숫자여야 합니다.");
        }
    }
}