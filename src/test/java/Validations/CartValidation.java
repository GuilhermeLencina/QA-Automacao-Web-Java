package Validations;

import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.CartPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class CartValidation {
    private WebDriver driver;
    private CartPage cartPage;

    public CartValidation (WebDriver driver) {
        this.driver = driver;
        cartPage = new CartPage(this.driver);
    }

    public void validateTitlePage() {
        try{
            Assertions.assertTrue(cartPage.getTitlePageLabel().isDisplayed());
            Report.logWithCapture(Status.PASS, "Validar título página", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }
}
