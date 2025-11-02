package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    @Test
    void 당첨된_결과_순위에_따라_횟수를_증가시킨다() {
        LottoResult lottoResult = new LottoResult();

        lottoResult.addRank(Rank.FIRST);
        lottoResult.addRank(Rank.FIRST);
        lottoResult.addRank(Rank.SECOND);

        assertThat(lottoResult.getRankCount().get(Rank.FIRST)).isEqualTo(2);
        assertThat(lottoResult.getRankCount().get(Rank.SECOND)).isEqualTo(1);
    }

    @Test
    void 당첨된_결과에_따른_수익률을_계산한다() {
        LottoResult lottoResult = new LottoResult();

        lottoResult.addRank(Rank.SECOND);
        lottoResult.addRank(Rank.THIRD);

        int totalPurchaseAmount = 5000;
        double expectedProfitRate =
                Math.round(((double) (30_000_000 + 1_500_000) / totalPurchaseAmount) * 1000) / 10.0;

        assertThat(lottoResult.calculateProfitRate(totalPurchaseAmount)).isEqualTo(expectedProfitRate);
    }
}