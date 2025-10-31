package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.PurchaseCount;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {
    private LottoService lottoService = new LottoService();

    @Test
    void 입력된_금액으로_PurchaseCount_객체를_생성한다(){
            int amount = 1000;
            PurchaseCount purchaseCount = lottoService.createPurchaseCount(amount);
            assertThat(purchaseCount.getCount()).isEqualTo(1);
    }

    @Test
    void 로또는_구매갯수만큼_생성된다(){
        int count = 5;
        List<Lotto> lottos = lottoService.generateLotto(count);
        assertThat(lottos.size()).isEqualTo(count);
    }

    @Test
    void 로또번호는_1부터_45까지_중복된_수가_없이_생성된다(){
        List<Lotto> lottos = lottoService.generateLotto(1);
        Lotto lotto = lottos.get(0);
        List<Integer> numbers = lotto.getNumbers();

        assertThat(numbers).doesNotHaveDuplicates();
        assertThat(numbers).allMatch(number -> number >= 1 && number <= 45);
    }
}
