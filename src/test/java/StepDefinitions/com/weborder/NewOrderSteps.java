package StepDefinitions.com.weborder;

import Pages.WebOrderPages.HomePage;
import Pages.WebOrderPages.OrderPage;
import Utils.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NewOrderSteps {

    WebDriver driver= Driver.getDriver();
    HomePage homePage= new HomePage(driver);
    OrderPage orderPage=new OrderPage(driver);

    @Then("the user enter product info {string} and {string}")
    public void the_user_enter_product_info_and(String product, String quantity) throws InterruptedException {

        homePage.orderButton.click();
        Select select=new Select(orderPage.productName);
        select.selectByVisibleText(product);

        orderPage.quantitiy.clear();
        Thread.sleep(1000);
        orderPage.quantitiy.sendKeys(quantity);

    }

    @Then("the user address info {string} , {string}, {string}, {string}, {string}")
    public void the_user_address_info(String customerName , String street, String city, String state, String zipCode) {
        orderPage.customerName.sendKeys(customerName);
        orderPage.street.sendKeys(street);
        orderPage.city.sendKeys(city);
        orderPage.state.sendKeys(state);
        orderPage.zipCode.sendKeys(zipCode);
    }

    @Then("the user enter payment information {string} , {string}, {string}")
    public void the_user_enter_payment_information(String card, String cardNum, String expiration) throws InterruptedException {

        switch (card){
            case "Visa":
                orderPage.visa.click();
                break;
            case "MasterCard":
                orderPage.masterCard.click();
                break;
            case "American Express":
                orderPage.amex.click();
                break;

        }

        orderPage.cardNum.sendKeys(cardNum);
        orderPage.expirationDate.sendKeys(expiration);

        orderPage.processButton.click();
    }

    @Then("the user validate success message")
    public void the_user_validate_success_message() {

        Assert.assertTrue(orderPage.successMessage.isDisplayed());

    }

}
