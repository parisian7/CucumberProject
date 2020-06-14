package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CucumberTestSteps {

    // we need to import the @Given, @When and @Then annotation
    @Given("the user school name")
    public void the_user_school_name() {

        System.out.println("Techtorial");
    }

    @When("the user print the name")
    public void the_user_print_the_name() {

        System.out.println("David");
    }

    @Then("the user print the last name")
    public void the_user_print_the_last_name() {

        System.out.println("Hunt");

    }

    @Then("the user print the city")
    public void the_user_print_the_city() {
        System.out.println("Des Plaines");
    }

    @Then("the user print the state")
    public void the_user_print_the_state() {
        System.out.println("Illinois");
    }


}
