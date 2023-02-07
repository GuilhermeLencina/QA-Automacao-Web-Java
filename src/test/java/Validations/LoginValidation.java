package Validations;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.MenuPage;
import PageObjects.LoginPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class LoginValidation {
    private WebDriver driver;
    private Waits waits;
    private LoginPage loginPage;
    private MenuPage menuPage;

    public LoginValidation (WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
        loginPage = new LoginPage(this.driver);
        menuPage = new MenuPage(this.driver);
    }

    public void validateLogin() {
        try{
            waits.loadElement(loginPage.getLoginButton());
            Assertions.assertTrue(loginPage.getLoginButton().isDisplayed());
            Report.logWithCapture(Status.PASS, "Validar esta na página de login", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateFilledFields() {
        try {
            Assertions.assertTrue(loginPage.getUsernameTextField().isDisplayed());
            Assertions.assertTrue(loginPage.getPasswordTextField().isDisplayed());
            Report.logWithCapture(Status.PASS, "Validar campos preenchidos com sucesso", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateAccess() {
        try{
            Assertions.assertTrue(menuPage.getTitlePageLabel().isDisplayed());
            Report.logWithCapture(Status.PASS, "Validar esta na página de produtos", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateDeniedLogin(){
        try{
            Assertions.assertEquals(loginPage.getErrorMessage().getText(), "Epic sadface: Sorry, this user has been locked out.");
            Report.logWithCapture(Status.PASS, "Validar acesso com erro", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }
}
