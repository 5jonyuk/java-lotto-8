package lotto;

import lotto.controller.LottoController;
import lotto.parser.StringToIntParser;
import lotto.validator.input.PurchaseAmountValidator;
import lotto.view.OutputView;
import lotto.view.InputView;
import lotto.service.LottoService;
import lotto.validator.input.InputValidator;
import lotto.parser.InputParser;
import lotto.util.FormatLottoNumbers;

public class Application {
    public static void main(String[] args) {
        InputValidator inputValidator = new PurchaseAmountValidator();
        InputParser inputParser = new StringToIntParser();
        FormatLottoNumbers formatLottoNumbers = new FormatLottoNumbers();
        OutputView outputView = new OutputView(formatLottoNumbers);
        InputView inputView = new InputView(inputValidator, outputView, inputParser);
        LottoService lottoService = new LottoService();

        LottoController lottoController = new LottoController(inputView, outputView, lottoService);
        lottoController.run();
    }
}
