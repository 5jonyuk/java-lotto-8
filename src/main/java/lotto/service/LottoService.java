package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.PurchaseCount;
import camp.nextstep.edu.missionutils.Randoms;


import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public PurchaseCount createPurchaseCount(int amount) {
        return new PurchaseCount(amount);
    }
    public List<Lotto> generateLotto(int count){
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < count; i++){
            lottos.add(createLotto());
        }
        return lottos;
    }

    private Lotto createLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE);
        return new Lotto(numbers);
    }
}
