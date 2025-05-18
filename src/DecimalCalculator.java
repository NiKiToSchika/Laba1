// Калькулятор для десятичной системы счисления
public class DecimalCalculator extends BaseCalculator {

    // Возвращает основание системы счисления (10 для десятичной)
    @Override
    public int getBase() {
        return 10;
    }

    // Преобразует строку в десятичное целое число
    @Override
    public int parse(String value) {
        return Integer.parseInt(value);
    }

    // Преобразует десятичное число в строку
    @Override
    public String format(int value) {
        return Integer.toString(value);
    }

    // Выполняет математическую операцию между двумя строковыми числами
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
        return format(result); // Возвращаем результат в виде строки
    }

    // Возвращает десятичное значение из строки (в данном случае — просто parse)
    @Override
    public int toDecimal(String value) {
        return parse(value);
    }

    // Возвращает имя системы счисления
    @Override
    public String getName() {
        return "DEC";
    }
}
