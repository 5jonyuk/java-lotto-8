package lotto;

import lotto.controller.LottoController;
import lotto.parser.PurchaseAmountParser;
import lotto.validator.PurchaseAmountValidator;
import lotto.view.OutputView;
import lotto.view.InputView;
import lotto.service.LottoService;
import lotto.validator.InputValidator;
import lotto.parser.InputParser;

public class Application {
    public static void main(String[] args) {
        InputValidator inputValidator = new PurchaseAmountValidator();
        InputParser inputParser = new PurchaseAmountParser();
        OutputView outputView = new OutputView();
        InputView inputView = new InputView(inputValidator, outputView, inputParser);
        LottoService lottoService = new LottoService();

        LottoController lottoController = new LottoController(inputView, outputView, lottoService);
        lottoController.run();
    }
}
