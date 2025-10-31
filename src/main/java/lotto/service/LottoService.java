package lotto.service;

import lotto.domain.PurchaseCount;

public class LottoService {
    public PurchaseCount calculatePurchaseCount(int amount) {
        PurchaseCount purchaseCount = new PurchaseCount(amount);
        purchaseCount.calculatePurchaseCount();
        return purchaseCount;
    }
}
