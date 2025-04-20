
public abstract class Calculator {

    // Абстрактный метод для парсинга входной строки в число
    // Этот метод должен быть реализован в классах-наследниках
    public abstract int parse(String input);

    // Абстрактный метод для форматирования числа в строку
    // Этот метод должен быть реализован в классах-наследниках
    public abstract String format(int number);

    // Абстрактный метод для получения имени системы счисления
    // Этот метод должен быть реализован в классах-наследниках
    public abstract String getSystemName();

    // Метод для выполнения математической операции между двумя числами
    // принимает два числа и операцию, возвращает результат вычисления
    public int calculate(int a, int b, char op) {
        return switch (op) {

            case '+' -> a + b;

            case '-' -> a - b;

            case '*' -> a * b;

            case '/' -> {

                if (b == 0) throw new ArithmeticException("Деление на ноль!");
                // Выполнение деления
                yield a / b;
            }
            // В случае, если операция не поддерживается, выбрасываем исключение
            default -> throw new IllegalArgumentException("Неизвестная операция: " + op);
        };
    }
}
