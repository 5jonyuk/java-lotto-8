package lotto.view;

public class OutputView {
    private final String ENTER_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private final String ENTER_PURCHASE_COUNT_MESSAGE = "%n%d개를 구매했습니다.";

    public void printEnterPurchaseAmountMessage() {
        System.out.println(ENTER_PURCHASE_AMOUNT_MESSAGE);
    }

    public void printEnterPurchaseCountMessage(int amount) {
        System.out.printf((ENTER_PURCHASE_COUNT_MESSAGE), amount);
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
