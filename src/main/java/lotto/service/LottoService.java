package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public PurchaseCount createPurchaseCount(int amount) {
        return new PurchaseCount(amount);
    }

    public List<Lotto> generateLotto(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    private Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE);
        return new Lotto(numbers);
    }

    public LottoResult calculateLottoResult(List<Lotto> lottos, WinningLotto winningLotto) {
        LottoResult lottoResult = new LottoResult();

        for (Lotto lotto : lottos){
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winningLotto.getWinningNumbers()::contains).count();
            boolean bonusMatch = lotto.getNumbers().contains(winningLotto.getBonusNumber());

            Rank rank = determineRank(matchCount, bonusMatch);
            lottoResult.addRank(rank);
        }

        return lottoResult;
    }

    private Rank determineRank(int matchCount, boolean bonusMatch) {
        return Rank.from(matchCount, bonusMatch);
    }
}
