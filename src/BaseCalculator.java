public abstract class BaseCalculator {

    // Возвращает основание системы счисления (например, 10, 2, 8, 16)
    public abstract int getBase();

    // Преобразует строку в число в соответствии с системой счисления
    public abstract int parse(String value);

    // Преобразует число в строку в соответствии с системой счисления
    public abstract String format(int value);

    // Выполняет арифметическую операцию между двумя строковыми числами
    public abstract String calculate(String a, String b, String op);

    // Преобразует строку из текущей системы счисления в десятичное число
    public abstract int toDecimal(String value);

    // Возвращает имя системы счисления (например: DEC, BIN, OCT, HEX)
    public abstract String getName();
}
