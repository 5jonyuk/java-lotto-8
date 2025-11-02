package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;
import lotto.util.FormatLottoNumbers;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String PRINT_ENTER_MESSAGE_PURCHASE_AMOUNT_ = "구입금액을 입력해 주세요.";
    private static final String PRINT_MESSAGE_PURCHASE_COUNT = "%n%d개를 구매했습니다.%n";
    private static final String PRINT_ENTER_MESSAGE_WINNING_NUMBER = "%n당첨 번호를 입력해 주세요.%n";
    private static final String PRINT_ENTER_MESSAGE_BONUS_NUMBER = "%n보너스 번호를 입력해 주세요.%n";
    private static final String PRINT_MESSAGE_WINNING_STATS = "%n당첨통계%n";
    private static final String PRINT_SEPARATE_LINE = "---";
    private static final String PRINT_WINNING_RESULT = "%d개 일치 (%s원) - %d개%n";
    private static final String PRINT_BONUS_WINNING_RESULT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개%n";
    private static final String PRINT_PROFIT_RATE = "총 수익률은 %.1f%%입니다.";

    private final FormatLottoNumbers formatLottoNumbers;

    public OutputView(FormatLottoNumbers formatLottoNumbers) {
        this.formatLottoNumbers = formatLottoNumbers;
    }

    public void printEnterPurchaseAmountMessage() {
        System.out.println(PRINT_ENTER_MESSAGE_PURCHASE_AMOUNT_);
    }

    public void printEnterPurchaseCountMessage(int amount) {
        System.out.printf((PRINT_MESSAGE_PURCHASE_COUNT), amount);
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

    public void printWinningNumber() {
        System.out.printf(PRINT_ENTER_MESSAGE_WINNING_NUMBER);
    }

    public void printBonusNumber() {
        System.out.printf(PRINT_ENTER_MESSAGE_BONUS_NUMBER);
    }

    public void printLottoResult(LottoResult result, int amount) {
        System.out.printf(PRINT_MESSAGE_WINNING_STATS);
        System.out.println(PRINT_SEPARATE_LINE);
        printStats(result);
        System.out.printf(PRINT_PROFIT_RATE, result.calculateProfitRate(amount));
    }

    private void printStats(LottoResult result){
        for (Map.Entry<Rank, Integer> entry : result.getRankCount().entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();

            if (rank.equals(Rank.NONE)) continue;

            String formatPrizeMoney = String.format("%,d", rank.getPrizeMoney());

            if(rank.isBonusMatch()){
                System.out.printf(PRINT_BONUS_WINNING_RESULT, rank.getMatchCount() , formatPrizeMoney, count);
                continue;
            }
            System.out.printf(PRINT_WINNING_RESULT, rank.getMatchCount(), formatPrizeMoney, count);
        }
    }
}
