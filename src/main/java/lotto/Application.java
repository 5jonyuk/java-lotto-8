package lotto;

import lotto.controller.LottoController;
import lotto.parser.InputParser;
import lotto.parser.StringToIntParser;
import lotto.service.LottoService;
import lotto.util.FormatLottoNumbers;
import lotto.validator.input.InputValidator;
import lotto.validator.input.PurchaseAmountValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputValidator inputValidator = new PurchaseAmountValidator();
        InputParser inputParser = new StringToIntParser();
        FormatLottoNumbers formatLottoNumbers = new FormatLottoNumbers();
        OutputView outputView = new OutputView(formatLottoNumbers);
        InputView inputView = new InputView();
        LottoService lottoService = new LottoService();
        LottoController lottoController = new LottoController(inputView, outputView, lottoService,
                inputValidator, inputParser);

        lottoController.run();
    }
}
