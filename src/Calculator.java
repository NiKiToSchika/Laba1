
/**
 * Абстрактный класс Calculator, определяющий структуру калькулятора
 * для различных систем счисления.
 */
public abstract class Calculator {

    /**
     * Преобразует строковое представление числа в целое число.
     *
     * @param input строка, содержащая число в определённой системе счисления
     * @return числовое значение
     */
    public abstract int parse(String input);

    /**
     * Преобразует целое число в строковое представление
     * в определённой системе счисления.
     *
     * @param number целое число
     * @return строка, представляющая число
     */
    public abstract String format(int number);

    /**
     * Возвращает имя системы счисления.
     *
     * @return имя системы счисления
     */
    public abstract String getSystemName();

    /**
     * Выполняет арифметическую операцию над двумя числами.
     *
     * @param a  первое число
     * @param b  второе число
     * @param op операция ('+', '-', '*', '/')
     * @return результат выполнения операции
     * @throws ArithmeticException      если происходит деление на ноль
     * @throws IllegalArgumentException если операция не поддерживается
     */
    public int calculate(final int a, final int b, final char op) {
        return switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> {
                if (b == 0) {
                    throw new ArithmeticException("Деление на ноль!");
                }
                yield a / b;
            }
            default -> throw new IllegalArgumentException("Неизвестная операция: " + op);
        };
    }
}

