// Класс BinaryCalculator расширяет абстрактный класс Calculator
// и реализует его методы для работы с двоичной системой счисления.
public class BinaryCalculator extends Calculator {

    // Метод parse переопределяет родительский метод и преобразует строку из двоичной системы в десятичное число
    @Override
    public int parse(String input) {
        return Integer.parseInt(input, 2); // преобразование из двоичной строки в int
    }

    // Метод format переопределяет родительский метод и преобразует десятичное число обратно в строку в двоичной системе
    @Override
    public String format(int number) {
        return Integer.toBinaryString(number); // преобразование int в строку в двоичной системе
    }

    // Метод возвращает название используемой системы счисления (для идентификации и отображения)
    @Override
    public String getSystemName() {
        return "BIN"; // обозначение двоичной системы
    }
}
