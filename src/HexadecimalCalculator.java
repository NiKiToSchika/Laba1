public class HexadecimalCalculator extends BaseCalculator {

    @Override
    public int getBase() {
        return 16;
    }

    @Override
    public int parse(String value) {
        return Integer.parseInt(value, 16);
    }

    @Override
    public String format(int value) {
        return Integer.toHexString(value).toUpperCase();
    }

    @Override
    public String calculate(String a, String b, String op) {
        int num1 = parse(a);
        int num2 = parse(b);
        int result = switch (op) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> {
                if (num2 == 0) throw new ArithmeticException("Деление на ноль!");
                yield num1 / num2;
            }
            default -> throw new IllegalArgumentException("Неизвестная операция: " + op);
        };
        return format(result);
    }

    @Override
    public int toDecimal(String value) {
        return parse(value);
    }

    @Override
    public String getName() {
        return "HEX";
    }
}
