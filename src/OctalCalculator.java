public class OctalCalculator extends Calculator {

    @Override
    public int parse(String input) {
        return Integer.parseInt(input, 8);
    }

    @Override
    public String format(int number) {
        return Integer.toOctalString(number);
    }

    @Override
    public String getSystemName() {
        return "OCT";
    }
}