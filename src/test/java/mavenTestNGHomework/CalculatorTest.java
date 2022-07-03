package mavenTestNGHomework;




import homeworkNine.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatorTest {
    private Calculator calculator;

    @Test
    public void testAdd() {
        System.out.println("Summas tests");
        Assert.assertEquals(calculator.add(-5, 3), -2);
        Assert.assertEquals(calculator.add(-1, -3), -4);
        Assert.assertEquals(calculator.add(0, -8), -8);
        Assert.assertEquals(calculator.add(4, 7), 11);
        Assert.assertEquals(calculator.add(0, 0), 0);
        Assert.assertEquals(calculator.add(0, -1), -1);
    }


        @Test
        public void testSubstract(){
            System.out.println("Atņemšanas tests");
            Assert.assertEquals(calculator.substract(10,2),8);
            Assert.assertEquals(calculator.substract(-1,8),-9);
            Assert.assertEquals(calculator.substract(0,-2),2);
            Assert.assertEquals(calculator.substract(3,5),-2);
            Assert.assertEquals(calculator.substract(-9,-9),0);
        }

    @Test
    public void testMultiply(){
        System.out.println("Reizināšanas tests");
        Assert.assertEquals(calculator.multiply(1,1),1);
        Assert.assertEquals(calculator.multiply(2,0),0);
        Assert.assertEquals(calculator.multiply(5,4),20);
        Assert.assertEquals(calculator.multiply(-4,-4),16);
        Assert.assertEquals(calculator.multiply(-1,3),-3);
    }

    @Test
    public void testDivide(){
        System.out.println("Dalīšanas tests");
        Assert.assertEquals(calculator.divide(8,2),4.0);
        Assert.assertEquals(calculator.divide(5,2),2.0);
        Assert.assertEquals(calculator.divide(100,10),10.0);
        Assert.assertEquals(calculator.divide(30,1),30.0);
        Assert.assertEquals(calculator.divide(20,3),6.0);
    }

    @BeforeClass
    public void beforeMethod(){
        this.calculator = new Calculator();
    }

    @BeforeMethod
    public void izpilditPirmsKatraTesta(){
        System.out.println("Tests ir sācies..");
    }

    @AfterMethod
    public void izpilditPecKatraTesta(){
        System.out.println("Tests ir beidzies..");
    }
}
