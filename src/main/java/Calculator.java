public class Calculator {

    public int sum(int a, int b) {
        return a + b;
    }

    public int div(int a, int b) {
        return a / b;
    }

    public double squareRoot(double a) {
        return Math.sqrt(a);
    }

    public double fractDiv(double a, double b, double c, double d) {
        double fractDiv = (a * d) / (b * c);
        if (b == 0 || c == 0 || d == 0) {
            fractDiv = a / 0;
        }
        return fractDiv;
    }
}
