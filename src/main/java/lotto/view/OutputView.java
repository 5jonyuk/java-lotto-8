package lotto.view;

import lotto.domain.Lotto;
import lotto.util.FormatLottoNumbers;

import java.util.List;

public class OutputView {
    private static final String ENTER_MESSAGE_PURCHASE_AMOUNT_ = "구입금액을 입력해 주세요.";
    private static final String ENTER_MESSAGE_PURCHASE_COUNT = "%n%d개를 구매했습니다.%n";
    private static final String ENTER_MESSAGE_WINNING_NUMBER = "%n당첨 번호를 입력해 주세요.%n";
    private static final String ENTER_MESSAGE_BONUS_NUMBER = "%n보너스 번호를 입력해 주세요.%n";
    private final FormatLottoNumbers formatLottoNumbers;

    public OutputView(FormatLottoNumbers formatLottoNumbers) {
        this.formatLottoNumbers = formatLottoNumbers;
    }

    public void printEnterPurchaseAmountMessage() {
        System.out.println(ENTER_MESSAGE_PURCHASE_AMOUNT_);
    }

    public void printEnterPurchaseCountMessage(int amount) {
        System.out.printf((ENTER_MESSAGE_PURCHASE_COUNT), amount);
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

    public void printWinningNumber(){
        System.out.printf(ENTER_MESSAGE_WINNING_NUMBER);
    }

    public void printBonusNumber(){
        System.out.printf(ENTER_MESSAGE_BONUS_NUMBER);
    }
}
