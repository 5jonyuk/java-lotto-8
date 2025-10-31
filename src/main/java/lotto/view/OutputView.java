package lotto.view;

import lotto.domain.Lotto;
import lotto.util.FormatLottoNumbers;

import java.util.List;

public class OutputView {
    private static final String ENTER_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String ENTER_PURCHASE_COUNT_MESSAGE = "%n%d개를 구매했습니다.%n";
    private final FormatLottoNumbers formatLottoNumbers;

    public OutputView(FormatLottoNumbers formatLottoNumbers) {
        this.formatLottoNumbers = formatLottoNumbers;
    }

    public void printEnterPurchaseAmountMessage() {
        System.out.println(ENTER_PURCHASE_AMOUNT_MESSAGE);
    }

    public void printEnterPurchaseCountMessage(int amount) {
        System.out.printf((ENTER_PURCHASE_COUNT_MESSAGE), amount);
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> {
            String numbers = formatLottoNumbers.format(lotto.getNumbers());
            System.out.println(numbers);
        });
    }
}
