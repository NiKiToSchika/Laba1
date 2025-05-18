// Класс для проверки корректности ввода чисел в заданной системе счисления
public class InputValidator {

    // Проверяет, можно ли строку value корректно преобразовать в число с указанным основанием base
    public static boolean isValid(String value, int base) {
        try {
            // Пытаемся распарсить строку с заданным основанием
            Integer.parseInt(value, base);
            return true; // если успешно — возвращаем true
        } catch (NumberFormatException e) {
            return false; // если ошибка — ввод некорректен
        }
    }
}
