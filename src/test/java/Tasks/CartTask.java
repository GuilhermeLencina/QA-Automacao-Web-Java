package Tasks;

import Framework.Browser.Waits;
import PageObjects.CartPage;
import Validations.CartValidation;
import org.openqa.selenium.WebDriver;

public class CartTask {

    private static WebDriver driver;
    private static Waits waits;
    private static CartPage cartPage;
    private static CartValidation cartValidation;

    public CartTask(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
        cartPage = new CartPage(this.driver);
        cartValidation = new CartValidation(this.driver);
    }

    public void checkoutProduct(){
        cartValidation.validateTitlePage();
        cartPage.getCheckoutButton().click();
    }
}
