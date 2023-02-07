package Validations;

import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.MenuPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class MenuValidation {
    private WebDriver driver;
    private MenuPage menuPage;

    public MenuValidation (WebDriver driver) {
        this.driver = driver;
        menuPage = new MenuPage(this.driver);
    }

    public void ValidateFilterOptions() {
        try{
            Assertions.assertTrue(menuPage.getFilterTypeSelect().isDisplayed());
            Report.logWithCapture(Status.PASS, "Validar funcionalidade de filtro", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }
}
