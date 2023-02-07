package Validations;

import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.OverviewPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class OverviewValidation {
    private WebDriver driver;
    private OverviewPage overviewPage;

    public OverviewValidation (WebDriver driver) {
        this.driver = driver;
        overviewPage = new OverviewPage(this.driver);
    }

    public void validatePaymentInformation() {
        try {
            Assertions.assertEquals(overviewPage.getPaymentInformationLabel().getText(), "SauceCard #31337");
            Report.logWithCapture(Status.PASS, "Validar método de pagamento", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateShippingInformation() {
        try {
            Assertions.assertEquals(overviewPage.getShippingInformationLabel().getText(), "FREE PONY EXPRESS DELIVERY!");
            Report.logWithCapture(Status.PASS, "Validar transporadora do produto", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateTotal() {
        try {
            Assertions.assertEquals(overviewPage.getTotalLabel().getText(), "Total: $32.39");
            Report.logWithCapture(Status.PASS, "Validar preço total da compra", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }
}
