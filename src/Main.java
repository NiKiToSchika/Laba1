import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputValidator validator = new InputValidator();

        System.out.println("=== Многоразовый калькулятор ===");
        System.out.println("Чтобы выйти, введи 'exit' вместо числа.\n");

        while (true) {
            System.out.println("Выберите систему счисления: 1-DEC, 2-BIN, 3-OCT, 4-HEX");
            String choiceInput = scanner.nextLine();
            if (choiceInput.equalsIgnoreCase("exit")) break;

            int choice;
            try {
                choice = Integer.parseInt(choiceInput);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите число от 1 до 4 или 'exit'.");
                continue;
            }


            Calculator calc = switch (choice) {
                case 1 -> new DecimalCalculator();
                case 2 -> new BinaryCalculator();
                case 3 -> new OctalCalculator();
                case 4 -> new HexCalculator();
                default -> throw new IllegalArgumentException("Неверный выбор");
            };

            System.out.println("Введите первое число:");
            String str1 = scanner.nextLine();
            if (str1.equalsIgnoreCase("exit")) break;
            if (!validator.isValid(str1, calc)) {
                System.out.println("Ошибка: неверный формат первого числа.");
                continue;
            }

            System.out.println("Введите операцию (+ - * /):");
            char op = scanner.nextLine().charAt(0);

            System.out.println("Введите второе число:");
            String str2 = scanner.nextLine();
            if (str2.equalsIgnoreCase("exit")) break;
            if (!validator.isValid(str2, calc)) {
                System.out.println("Ошибка: неверный формат второго числа.");
                continue;
            }

            int num1 = calc.parse(str1);
            int num2 = calc.parse(str2);
            int result = calc.calculate(num1, num2, op);

            System.out.println("Результат в " + calc.getSystemName() + ": " + calc.format(result));
            System.out.println("DEC: " + result);
            System.out.println("BIN: " + Integer.toBinaryString(result));
            System.out.println("OCT: " + Integer.toOctalString(result));
            System.out.println("HEX: " + Integer.toHexString(result).toUpperCase());
            System.out.println();
        }

        System.out.println("Выход из калькулятора. До встречи!");
    }
}
