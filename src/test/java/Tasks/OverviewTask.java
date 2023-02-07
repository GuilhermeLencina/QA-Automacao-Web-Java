package Tasks;

import Framework.Browser.Waits;
import PageObjects.OverviewPage;
import Validations.OverviewValidation;
import org.openqa.selenium.WebDriver;

public class OverviewTask {
    private static WebDriver driver;
    private static Waits waits;
    private static OverviewPage overviewPage;
    private static OverviewValidation overviewValidation;

    public OverviewTask(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
        overviewPage = new OverviewPage(this.driver);
        overviewValidation = new OverviewValidation(this.driver);
    }

    public void validateOverviewFields(){
        overviewValidation.validatePaymentInformation();
        overviewValidation.validateShippingInformation();
        overviewValidation.validateTotal();
        overviewPage.getFinishButton().click();
    }
}
