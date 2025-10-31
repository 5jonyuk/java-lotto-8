package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.PurchaseCount;
import lotto.parser.InputParser;
import lotto.service.LottoService;
import lotto.validator.input.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;
    private final InputValidator inputValidator;
    private final InputParser inputParser;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService,
                           InputValidator inputValidator, InputParser inputParser) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
        this.inputValidator = inputValidator;
        this.inputParser = inputParser;
    }

    public int getValidatedPurchaseAmount(){
        while(true){
            try{
                String input = inputView.readPurchaseAmount();
                inputValidator.validateInput(input);
                int amount =  inputParser.parseNumber(input);
                inputValidator.validateAmount(amount);
                return amount;
            }
            catch (IllegalArgumentException e){
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
    }
}
