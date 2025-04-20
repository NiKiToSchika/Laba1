public abstract class Calculator {
    public abstract int parse(String input);
    public abstract String format(int number);
    public abstract String getSystemName();

    public int calculate(int a, int b, char op) {
        return switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> {
                if (b == 0) throw new ArithmeticException("Деление на ноль!");
                yield a / b;
            }
            default -> throw new IllegalArgumentException("Неизвестная операция: " + op);
        };
    }
}