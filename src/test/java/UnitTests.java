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
    @Test
    public void squareRootTest() {
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.squareRoot(16), 4);
    }

    // Fraction numbers division Test
    @Test
    public void fractDivTest() {
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.fractDiv(3, 0, 3, 4), 0.8);
    }
}
