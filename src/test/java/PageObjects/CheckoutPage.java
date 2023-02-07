package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends HeaderTopBarPage{
    private static WebDriver driver;
    private static Waits waits;

    public CheckoutPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getTitlePageLabel(){
        return waits.visibilityOfElement(By.cssSelector(".title"));
    }

    public WebElement getFirstNameTextField(){
        return waits.visibilityOfElement(By.id("first-name"));
    }

    public WebElement getLastNameTextField() {
        return waits.visibilityOfElement(By.id("last-name"));
    }

    public WebElement getPostalTextField() {
        return waits.visibilityOfElement(By.id("postal-code"));
    }

    public WebElement getCancelButton() {
        return waits.visibilityOfElement(By.id("cancel"));
    }

    public WebElement getConntinueButton() {
        return waits.visibilityOfElement(By.id("continue"));
    }
}
