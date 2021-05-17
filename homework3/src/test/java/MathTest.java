import org.testng.Assert;
import org.testng.annotations.Test;
import mathUtils.*;

public class MathTest {

    @Test
    public void absTest() {
        Assert.assertEquals(MathUtils.abs(-5), 5);
        Assert.assertEquals(MathUtils.abs(0), 0);
        Assert.assertEquals(MathUtils.abs(5), 5);
    }

    @Test
    public void signTest() {
        Assert.assertEquals(MathUtils.sign(-5), -1);
        Assert.assertEquals(MathUtils.sign(0), 0);
        Assert.assertEquals(MathUtils.sign(5), 1);
    }

    @Test
    public void isPrime() {
        Assert.assertEquals(MathUtils.isPrime(-1), false);
        Assert.assertEquals(MathUtils.isPrime(1), false);
        Assert.assertEquals(MathUtils.isPrime(5), true);
        Assert.assertEquals(MathUtils.isPrime(8), false);
    }

    @Test
    public void factorialTest() {
        Assert.assertEquals(MathUtils.factorial(-1), -1);
        Assert.assertEquals(MathUtils.factorial(2), 2);
        Assert.assertEquals(MathUtils.factorial(5), 120);
        Assert.assertEquals(MathUtils.factorial(6), 720);
    }

}
