package lotto.validator;

public class CommonInputValidator {
    private static final String ERROR_MESSAGE_NOT_NUMBER = "[ERROR] 숫자만 입력 가능합니다.";
    private static final String ERROR_MESSAGE_NOT_NULL_BLANK = "[ERROR] 빈 값 또는 공백은 입력되지 않습니다.";

    public void validate(String input) {
        validateNotNullOrBlank(input);
        validateNumber(input);
    }

    private void validateNotNullOrBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_NULL_BLANK);
        }
    }

    private void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_NUMBER);
        }
    }
}