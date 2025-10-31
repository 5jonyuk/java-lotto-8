package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.PurchaseCount;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        outputView.printEnterPurchaseAmountMessage();
        int amount = inputView.inputPurchaseAmount();

        PurchaseCount purchaseCount = lottoService.createPurchaseCount(amount);
        outputView.printEnterPurchaseCountMessage(purchaseCount.getCount());

        List<Lotto> lottos = lottoService.generateLotto(purchaseCount.getCount());
        outputView.printLottos(lottos);

    }
}
