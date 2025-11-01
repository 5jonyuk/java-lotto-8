package lotto.validator;

public class PurchaseAmountValidator implements InputValidator, AmountValidator {
    private static final String ERROR_MESSAGE_MINIMUM = "[ERROR] 구입 금액은 1,000원 이상이어야 합니다.";
    private static final String ERROR_MESSAGE_UNIT = "[ERROR] 구입 금액은 1,000원 단위여야 합니다.";
    private static final int MINIMUM_PURCHASE_AMOUNT = 1000;
    private final CommonInputValidator commonInputValidator = new CommonInputValidator();

    @Override
    public void validateInput(String input) {
        commonInputValidator.validate(input);
    }

    @Override
    public void validateAmount(int amount) {
        validateMinimumAmount(amount);
        validateUnitAmount(amount);
    }

    private void validateMinimumAmount(int amount) {
        if (amount < MINIMUM_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MINIMUM);
        }
    }

    private void validateUnitAmount(int amount) {
        if (amount % MINIMUM_PURCHASE_AMOUNT != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_UNIT);
        }
    }

}
