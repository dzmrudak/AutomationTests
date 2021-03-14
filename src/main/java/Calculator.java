public class Calculator {

    public int sum(int a, int b) {
        return a + b;
    }

    public int div(int a, int b) {
        return a / b;
    }

    public double squareRoot(double a) {
        if (a < 0) {
            System.out.println("You can not extract the root from a negative number!");
        }
        return Math.sqrt(a);
    }

    public double fractDiv(double a, double b, double c, double d) {

        if(b <= 0 || d <= 0 || c <= 0) {
            System.out.println("Error: division by zero");
        }
        return (a * d) / (b * c);
    }
}
