import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BaseCalculator calculator = null;

        while (true) {
            System.out.println("\nВыберите систему счисления:");
            System.out.println("1. Десятичная");
            System.out.println("2. Двоичная");
            System.out.println("3. Восьмеричная");
            System.out.println("4. Шестнадцатеричная");
            System.out.println("0. Выход");
            System.out.print("Ваш выбор: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    calculator = new DecimalCalculator();
                    break;
                case "2":
                    calculator = new BinaryCalculator();
                    break;
                case "3":
                    calculator = new OctalCalculator();
                    break;
                case "4":
                    calculator = new HexadecimalCalculator();
                    break;
                case "0":
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Неверный выбор. Повторите попытку.");
                    continue;
            }

            System.out.print("Введите первое число: ");
            String num1 = scanner.nextLine();

            System.out.print("Введите операцию (+, -, *, /): ");
            String operation = scanner.nextLine();

            System.out.print("Введите второе число: ");
            String num2 = scanner.nextLine();

            if (!InputValidator.isValid(num1, calculator.getBase()) ||
                    !InputValidator.isValid(num2, calculator.getBase())) {
                System.out.println("Ошибка: Неверный ввод для выбранной системы счисления.");
                continue;
            }

            String resultStr = calculator.calculate(num1, num2, operation);
            int resultDecimal = calculator.toDecimal(resultStr);

            System.out.println("Результат (" + calculator.getName() + "): " + resultStr);
            System.out.println("DEC: " + resultDecimal);
            System.out.println("BIN: " + Integer.toBinaryString(resultDecimal));
            System.out.println("OCT: " + Integer.toOctalString(resultDecimal));
            System.out.println("HEX: " + Integer.toHexString(resultDecimal).toUpperCase());
        }
    }
}

