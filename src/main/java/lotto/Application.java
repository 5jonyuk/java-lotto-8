package lotto;

import lotto.controller.LottoController;
import lotto.parser.WinningLottoParser;
import lotto.parser.input.InputParser;
import lotto.parser.input.StringToIntParser;
import lotto.service.LottoService;
import lotto.util.FormatLottoNumbers;
import lotto.validator.AmountValidator;
import lotto.validator.PurchaseAmountValidator;
import lotto.validator.WinningLottoValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        FormatLottoNumbers formatLottoNumbers = new FormatLottoNumbers();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView(formatLottoNumbers);

        PurchaseAmountValidator purchaseAmountValidator = new PurchaseAmountValidator();
        AmountValidator amountValidator = new PurchaseAmountValidator();
        WinningLottoValidator winningLottoValidator = new WinningLottoValidator();

        InputParser inputParser = new StringToIntParser();
        WinningLottoParser winningLottoParser = new WinningLottoParser();

        LottoService lottoService = new LottoService();

        LottoController lottoController = new LottoController(inputView, outputView, lottoService,
                purchaseAmountValidator, inputParser, amountValidator, winningLottoValidator, winningLottoParser);

        lottoController.run();
    }
}
