package Tasks;

import Framework.Browser.Waits;
import PageObjects.FinishPage;
import Validations.FinishValidation;
import org.openqa.selenium.WebDriver;

public class FinishTask {
    private static WebDriver driver;
    private static Waits waits;
    private static FinishPage finishPage;
    private static FinishValidation finishValidation;

    public FinishTask(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
        finishPage = new FinishPage(this.driver);
        finishValidation = new FinishValidation(this.driver);
    }

    public void validatePurchaseSuccessfully(){
        finishValidation.validatePurchase();
        finishPage.getBackHomeButton().click();
        finishValidation.validateHome();
    }
}
