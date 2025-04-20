public class HexCalculator extends Calculator {

    @Override
    public int parse(String input) {
        return Integer.parseInt(input, 16);
    }

    @Override
    public String format(int number) {
        return Integer.toHexString(number).toUpperCase();
    }

    @Override
    public String getSystemName() {
        return "HEX";
    }
}