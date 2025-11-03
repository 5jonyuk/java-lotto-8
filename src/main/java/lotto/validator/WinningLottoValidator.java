package lotto.validator;

import lotto.parser.WinningLottoParser;
import lotto.parser.input.InputParser;
import lotto.parser.input.StringToIntParser;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLottoValidator implements InputValidator {
    private static final String ERROR_MESSAGE_WINNING_NUMBER_SIZE = "[ERROR] 당첨 번호는 6개여야 합니다.";
    private static final String ERROR_MESSAGE_WINNING_NUMBER_RANGE = "[ERROR] 당첨 번호는 1~45 사이 숫자여야 합니다.";
    private static final String ERROR_MESSAGE_WINNING_NUMBER_NOT_SEPERATED_COMMA = "[ERROR] 당첨 번호는 쉼표(,)로 구분된 숫자여야 합니다.";
    private static final String ERROR_MESSAGE_WINNING_NUMBER_DUPLICATE = "[ERROR] 당첨 번호는 중복될 수 없습니다.";
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
        validateWinningNumberSize(numbers.size());
        validateWinningNumberRange(numbers);
        validateDuplicateWinningNumber(numbers);
        return numbers;
    }

    public int validateBonusNumber(String bonusInput, List<Integer> winningNumbers) {
        validateInput(bonusInput);
        int bonus = inputParser.parseNumber(bonusInput);
        validateBonusNumberRange(bonus);
        validateDuplicateBonusNumber(winningNumbers, bonus);
        return bonus;
    }

    private void validateWinningNumberInput(String input) {
        try {
            winningLottoParser.parseWinningNumbers(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_WINNING_NUMBER_NOT_SEPERATED_COMMA);
        }
    }

    private void validateWinningNumberSize(int size) {
        if (size != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE_WINNING_NUMBER_SIZE);
        }
    }

    private void validateWinningNumberRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ERROR_MESSAGE_WINNING_NUMBER_RANGE);
            }
        });
    }

    private void validateBonusNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ERROR_MESSAGE_BONUS_RANGE);
        }
    }

    private void validateDuplicateBonusNumber(List<Integer> winningNumbers, int bonus) {
        if (winningNumbers.contains(bonus)) throw new IllegalArgumentException(ERROR_MESSAGE_BONUS_DUPLICATE);
    }

    private void validateDuplicateWinningNumber(List<Integer> winningNumbers) {
        Set<Integer> uniqueWinningNumber = new HashSet<>(winningNumbers);
        if(uniqueWinningNumber.size() != winningNumbers.size()){
            throw new IllegalArgumentException(ERROR_MESSAGE_WINNING_NUMBER_DUPLICATE);
        }
    }
}