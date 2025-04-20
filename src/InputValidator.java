public class InputValidator {

    public boolean isValid(String input, Calculator calculator) {
        int base = switch (calculator.getSystemName()) {
            case "BIN" -> 2;
            case "OCT" -> 8;
            case "HEX" -> 16;
            default -> 10; // DEC или всё остальное по умолчанию — десятичная
        };

        try {
            Integer.parseInt(input, base);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
