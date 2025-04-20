public class BinaryCalculator extends Calculator {

    @Override
    public int parse(String input) {
        return Integer.parseInt(input, 2);
    }

    @Override
    public String format(int number) {
        return Integer.toBinaryString(number);
    }

    @Override
    public String getSystemName() {
        return "BIN";
    }
}