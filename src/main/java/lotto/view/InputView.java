package lotto.view;
import camp.nextstep.edu.missionutils.Console;
import lotto.parser.InputParser;
import lotto.validator.input.InputValidator;

public class InputView {
    private static InputValidator inputValidator;
    private static OutputView outputView;
    private static InputParser inputParser;

    public InputView(InputValidator inputValidator, OutputView outputView, InputParser inputParser) {
        this.inputValidator = inputValidator;
        this.outputView = outputView;
        this.inputParser = inputParser;
    }

    public int inputPurchaseAmount(){
        while(true){
            try{
                String input = Console.readLine();
                inputValidator.validateInput(input);
                int amount = parseAmount(input);
                inputValidator.validateAmount(amount);
                return amount;
            }
            catch (IllegalArgumentException e){
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public int parseAmount(String input){
       return inputParser.parseNumber(input);
    }
}
