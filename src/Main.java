import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Map<Integer, Calculator> CALCULATORS = new HashMap<>();

    static {
        CALCULATORS.put(1, new DecimalCalculator());
        CALCULATORS.put(2, new BinaryCalculator());
        CALCULATORS.put(3, new OctalCalculator());
        CALCULATORS.put(4, new HexCalculator());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputValidator validator = new InputValidator();

        System.out.println("Калькулятор");
        System.out.println("Чтобы выйти, введи 'exit'.\n");

        while (true) {
            Calculator calc = selectCalculator(scanner);
            if (calc == null) break;

            String str1 = promptForInput(scanner, "Введите первое число:");
            if (str1 == null || !validator.isValid(str1, calc)) {
                System.out.println("Ошибка: неверный формат первого числа.");
                continue;
            }

            String opInput = promptForInput(scanner, "Введите операцию (+ - * /):");
            if (opInput == null || opInput.length() != 1 || "+-*/".indexOf(opInput.charAt(0)) == -1) {
                System.out.println("Ошибка: неверная операция.");
                continue;
            }
            char op = opInput.charAt(0);

            String str2 = promptForInput(scanner, "Введите второе число:");
            if (str2 == null || !validator.isValid(str2, calc)) {
                System.out.println("Ошибка: неверный формат второго числа.");
                continue;
            }

            try {
                int num1 = calc.parse(str1);
                int num2 = calc.parse(str2);
                int result = calc.calculate(num1, num2, op);

                System.out.println("Результат в " + calc.getSystemName() + ": " + calc.format(result));
                System.out.println("DEC: " + result);
                System.out.println("BIN: " + Integer.toBinaryString(result));
                System.out.println("OCT: " + Integer.toOctalString(result));
                System.out.println("HEX: " + Integer.toHexString(result).toUpperCase());
                System.out.println();
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }

        System.out.println("Выход из калькулятора. До встречи!");
    }

    private static Calculator selectCalculator(Scanner scanner) {
        System.out.println("Выберите систему счисления: 1-DEC, 2-BIN, 3-OCT, 4-HEX");

        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("exit")) return null;

        try {
            int choice = Integer.parseInt(input);
            Calculator calculator = CALCULATORS.get(choice);
            if (calculator != null) {
                return calculator;
            } else {
                System.out.println("Ошибка: допустимые значения — от 1 до 4.");
                return selectCalculator(scanner); // Повтор запроса
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введите число от 1 до 4 или 'exit'.");
            return selectCalculator(scanner); // Повтор запроса
        }
    }

    private static String promptForInput(Scanner scanner, String prompt) {
        System.out.println(prompt);
        String input = scanner.nextLine();
        return input.equalsIgnoreCase("exit") ? null : input;
    }
}
