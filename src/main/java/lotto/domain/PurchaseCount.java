package lotto.domain;

public class PurchaseCount {
    private static final int LOTTO_PRICE = 1000;
    private final int amount;
    private int count;

    public PurchaseCount(int amount) {
        this.amount = amount;
    }

    public void calculatePurchaseCount() {
        this.count = amount / LOTTO_PRICE;
    }

    public int getCount() {
        return count;
    }
}
