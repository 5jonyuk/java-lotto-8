package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> rankCount = new EnumMap<>(Rank.class);

    public LottoResult() {
        for (Rank rank : Rank.values()) {
            rankCount.put(rank, 0);
        }
    }

    public void addRank(Rank rank) {
        rankCount.put(rank, rankCount.get(rank) + 1);
    }

    public Map<Rank, Integer> getRankCount() {
        return rankCount;
    }

    public double calculateProfitRate(int purchaseAmount) {
        long totalWinningAmount = rankCount.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();

        return Math.round((((double) totalWinningAmount / purchaseAmount)) * 1000) / 10.0;
    }
}
