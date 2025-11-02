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

    public void addRank(Rank rank){
        rankCount.put(rank, rankCount.get(rank) + 1);
    }

}
