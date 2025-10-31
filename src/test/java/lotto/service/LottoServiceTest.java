package lotto.service;

import lotto.domain.PurchaseCount;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {
    private LottoService lottoService = new LottoService();

    @Test
    void 입력된_금액으로_PurchaseCount_객체를_생성한다(){
            int amount = 1000;
            PurchaseCount purchaseCount = lottoService.createPurchaseCount(amount);
            assertThat(purchaseCount.getCount()).isEqualTo(1);
    }
}
