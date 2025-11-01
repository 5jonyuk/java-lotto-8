package lotto.parser.input;

public class StringToIntParser implements InputParser {
    @Override
    public int parseNumber(String input) {
        return Integer.parseInt(input);
    }
}
