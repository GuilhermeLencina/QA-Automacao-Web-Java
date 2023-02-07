package Validations;

import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.CheckoutPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class CheckoutValidation {
    private WebDriver driver;
    private CheckoutPage checkoutPage;

    public CheckoutValidation (WebDriver driver) {
        this.driver = driver;
        checkoutPage = new CheckoutPage(this.driver);
    }

    public void validateTitlePage() {
        try{
            Assertions.assertTrue(checkoutPage.getTitlePageLabel().isDisplayed());
            Report.logWithCapture(Status.PASS, "Validar título página", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateCheckoutButton() {
        try{
            Assertions.assertTrue(checkoutPage.getConntinueButton().isDisplayed());
            Report.logWithCapture(Status.PASS, "Validar botão de checkout", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }
}
