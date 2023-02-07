package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FinishPage extends HeaderTopBarPage{
    private static WebDriver driver;
    private static Waits waits;

    public FinishPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getFinishLabel(){
        return waits.visibilityOfElement(By.cssSelector(".complete-header"));
    }

    public WebElement getBackHomeButton(){
        return waits.visibilityOfElement(By.id("back-to-products"));
    }
}
