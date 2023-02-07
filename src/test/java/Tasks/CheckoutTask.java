package Tasks;

import Framework.Browser.Waits;
import Framework.Utils.FakersGeneration;
import PageObjects.CheckoutPage;
import Validations.CheckoutValidation;
import org.openqa.selenium.WebDriver;

public class CheckoutTask {
    private static WebDriver driver;
    private static Waits waits;
    private static CheckoutPage checkoutPage;
    private static CheckoutValidation checkoutValidation;
    private static FakersGeneration fakersGeneration;

    public CheckoutTask(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
        checkoutPage = new CheckoutPage(this.driver);
        checkoutValidation = new CheckoutValidation(this.driver);
        fakersGeneration = new FakersGeneration(this.driver);
    }

    public void fillField(){
        checkoutValidation.validateTitlePage();
        checkoutPage.getFirstNameTextField().sendKeys(fakersGeneration.getFirtName());
        checkoutPage.getLastNameTextField().sendKeys(fakersGeneration.getLastName());
        checkoutPage.getPostalTextField().sendKeys(fakersGeneration.getAccount());
        checkoutValidation.validateCheckoutButton();
        checkoutPage.getConntinueButton().click();
    }

}
