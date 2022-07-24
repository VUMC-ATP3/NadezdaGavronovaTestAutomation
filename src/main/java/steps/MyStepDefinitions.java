package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MyStepDefinitions {

    private int appleCount;
    private int eatenAppleCount;

    @Given("I have {int} apples")
    public void i_have_apples(int a) {
        System.out.println("I have" + a + " apples");
        appleCount = a;
    }
    @When("I eat {int} apples")
    public void i_eat_apples(int b) {
        System.out.println("I eat " + b + " apples");
        eatenAppleCount = b;
    }
    @Then("I have {int} apples left")
    public void i_have_apples_left(int int1) {
        System.out.println("I have " + int1 + " apples left");
        int applesLeft = appleCount - eatenAppleCount;
        Assert.assertEquals(applesLeft, int1);
    }

}
