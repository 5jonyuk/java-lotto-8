package lotto.validator;

public class PurchaseAmountValidator implements InputValidator {
    private static final String ERROR_MESSAGE_MINIMUM = "[ERROR] 구입 금액은 1,000원 이상이어야 합니다.";
    private static final String ERROR_MESSAGE_UNIT = "[ERROR] 구입 금액은 1,000원 단위여야 합니다.";
    private static final String ERROR_MESSAGE_NOT_NUMBER = "[ERROR] 숫자만 입력 가능합니다.";
    private static final String ERROR_MESSAGE_NOT_NULL_BLANK = "[ERROR] 빈 값 또는 공백은 입력되지 않습니다.";
    private static final int MINIMUM_PURCHASE_AMOUNT = 1000;

    @Override
    public void validateInput(String input) {
        if (input == null || input.isBlank()){
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_NULL_BLANK);
        }
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_NUMBER);
        }
    }

    @Override
    public void validateAmount(int amount) {
        validateMinimumAmount(amount);
        validateUnitAmount(amount);
    }

    private void validateMinimumAmount(int amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MINIMUM);
        }
    }

    private void validateUnitAmount(int amount) {
        if (amount % MINIMUM_PURCHASE_AMOUNT != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_UNIT);
        }
    }

}
