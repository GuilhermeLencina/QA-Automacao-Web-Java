package PageObjects;

import Framework.Browser.JavaScriptExecutor;
import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    private Waits waits;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getUsernameTextField(){
        return waits.visibilityOfElement(By.id("user-name"));
    }

    public WebElement getPasswordTextField(){
        return waits.visibilityOfElement(By.id("password"));
    }

    public WebElement getLoginButton(){
        return waits.visibilityOfElement(By.id("login-button"));
    }

    public WebElement getErrorMessage(){
        return waits.visibilityOfElement(By.cssSelector(".error-message-container"));
    }
}
