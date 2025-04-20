public class DecimalCalculator extends Calculator {

    @Override
    public int parse(String input) {
        return Integer.parseInt(input);
    }

    @Override
    public String format(int number) {
        return Integer.toString(number);
    }

    @Override
    public String getSystemName() {
        return "DEC";
    }
}