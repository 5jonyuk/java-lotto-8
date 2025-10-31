package lotto.parser;

public class PurchaseAmountParser implements InputParser {
    @Override
    public int parseNumber(String input) {
        return Integer.parseInt(input);
    }
}
