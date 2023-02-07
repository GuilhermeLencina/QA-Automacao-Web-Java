package Validations;

import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.FinishPage;
import PageObjects.MenuPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class FinishValidation {
    private WebDriver driver;
    private FinishPage finishPage;
    private MenuPage menuPage;

    public FinishValidation (WebDriver driver) {
        this.driver = driver;
        finishPage = new FinishPage(this.driver);
        menuPage = new MenuPage(this.driver);
    }

    public void validatePurchase() {
        try {
            Assertions.assertEquals(finishPage.getFinishLabel().getText(), "THANK YOU FOR YOUR ORDER");
            Report.logWithCapture(Status.PASS, "Validar compra concluida!", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateHome() {
        try {
            Assertions.assertTrue(menuPage.getTitlePageLabel().isDisplayed());
            Report.logWithCapture(Status.PASS, "Validar de volta ao menu", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }
}
