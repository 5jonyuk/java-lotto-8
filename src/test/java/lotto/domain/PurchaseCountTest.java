package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseCountTest {
    @Test
    @DisplayName("구매 금액이 1000원일 때 로또 1개를 구매한다")
    void 구매_금액이_1000원일_때_로또_1개를_구매한다(){
        PurchaseCount purchaseCount = new PurchaseCount(1000);
        purchaseCount.calculatePurchaseCount();
        assertThat(purchaseCount.getCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("구매 금액이 1000원 미만 일 때 로또를 구매할 수 없다")
    void 구매_금액이_1000원_미만_일_때_로또를_구매할_수_없다(){
        PurchaseCount purchaseCount = new PurchaseCount(999);
        purchaseCount.calculatePurchaseCount();
        assertThat(purchaseCount.getCount()).isEqualTo(0);
    }
}
