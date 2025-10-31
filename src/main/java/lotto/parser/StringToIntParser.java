package lotto.parser;

public class StringToIntParser implements InputParser {
    @Override
    public int parseNumber(String input) {
        return Integer.parseInt(input);
    }
}
