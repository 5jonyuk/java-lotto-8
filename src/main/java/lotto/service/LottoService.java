package lotto.service;

import lotto.domain.PurchaseCount;

public class LottoService {
    public PurchaseCount createPurchaseCount(int amount) {
        return new PurchaseCount(amount);
    }
}
