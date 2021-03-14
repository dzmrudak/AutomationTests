import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTests {

    // a > 0, b > 0, check a + b
    @Test
    public void sumTest1() {
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.sum(2,3), 5, "Test comment");
    }

    // a < 0, b < 0, check a + b
    @Test
    public void sumTest2() {
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.sum(-2,-3), -5);
    }

    // a > 0, b < 0, check a + b
    @Test
    public void sumTest3() {
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.sum(-2,3), 1);
    }

    @Test
    public void divTest1() {
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.div(4,2), 2);
    }

    @Test
    public void divTest2() {
        Calculator calc = new Calculator();
        Assert.assertThrows(java.lang.ArithmeticException.class, () -> calc.div(4, 0));
        //Assert.assertEquals(calc.div(4,0), 0);
    }

    //Extracting of a square root Test
    // a > 0, check squareRoot(a)
    @Test
    public void squareRootTest1() {
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.squareRoot(16), 4);
    }

    //Extracting of a square root Test
    // a < 0, check squareRoot(a)
    @Test
    public void squareRootTest2() {
        Calculator calc = new Calculator();
        Assert.assertEquals(Double.NaN, calc.squareRoot(-16));
    }

    //Extracting of a square root Test
    // a is float, check squareRoot(a)
    @Test
    public void squareRootTest3() {
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.squareRoot(16.16), 4.019950248448356);
    }

    // Fraction numbers division Test
    // b != 0, c != 0, d != 0
    @Test
    public void fractDivTest1() {
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.fractDiv(3, 5, 3, 4), 0.8);
    }

    // Fraction numbers division Test
    // a != 0 && b ==0 || c == 0 || d == 0
    @Test
    public void fractDivTest2() {
        Calculator calc = new Calculator();
        Assert.assertEquals(Double.POSITIVE_INFINITY, calc.fractDiv(3, 0, 3, 4));
    }

    // Fraction numbers division Test
    // a < 0 || c < 0
    @Test
    public void fractDivTest3() {
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.fractDiv(-3, 5, 3, 4), -0.8);
    }
}
