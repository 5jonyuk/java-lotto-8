package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseCount;
import lotto.domain.WinningLotto;
import lotto.parser.WinningLottoParser;
import lotto.parser.input.InputParser;
import lotto.service.LottoService;
import lotto.validator.AmountValidator;
import lotto.validator.PurchaseAmountValidator;
import lotto.validator.WinningLottoValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;
    private final PurchaseAmountValidator purchaseAmountValidator;
    private final InputParser inputParser;
    private final AmountValidator amountValidator;
    private final WinningLottoValidator winningLottoValidator;
    private final WinningLottoParser winningLottoParser;

    public LottoController(
            InputView inputView,
            OutputView outputView,
            LottoService lottoService,
            PurchaseAmountValidator purchaseAmountValidator,
            InputParser inputParser,
            AmountValidator amountValidator,
            WinningLottoValidator winningLottoValidator,
            WinningLottoParser winningLottoParser
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
        this.purchaseAmountValidator = purchaseAmountValidator;
        this.winningLottoValidator = winningLottoValidator;
        this.inputParser = inputParser;
        this.amountValidator = amountValidator;
        this.winningLottoParser = winningLottoParser;
    }

    public int getValidatedPurchaseAmount() {
        while (true) {
            try {
                String input = inputView.readPurchaseAmount();
                purchaseAmountValidator.validateInput(input);
                int amount = inputParser.parseNumber(input);
                amountValidator.validateAmount(amount);
                return amount;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public WinningLotto getValidatedWinningNumber() {
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private List<Integer> getWinningNumbers() {
        while (true) {
            try {
                String input = inputView.readWinningNumber();
                return winningLottoValidator.validateWinningNumbers(input);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                outputView.printBonusNumber();
                String bonusInput = inputView.readBonusNumber();
                return winningLottoValidator.validateBonusNumber(bonusInput, winningNumbers);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public void run() {
        outputView.printEnterPurchaseAmountMessage();
        int amount = getValidatedPurchaseAmount();

        PurchaseCount purchaseCount = lottoService.createPurchaseCount(amount);
        outputView.printEnterPurchaseCountMessage(purchaseCount.getCount());

        List<Lotto> lottos = lottoService.generateLotto(purchaseCount.getCount());
        outputView.printLottos(lottos);

        outputView.printWinningNumber();
        WinningLotto winningLottos = getValidatedWinningNumber();

        LottoResult result = lottoService.calculateLottoResult(lottos, winningLottos);
        outputView.printLottoResult(result, amount);
    }
}
