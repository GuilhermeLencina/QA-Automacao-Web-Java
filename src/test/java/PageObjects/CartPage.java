package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends HeaderTopBarPage{
    private static WebDriver driver;
    private static Waits waits;

    public CartPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getTitlePageLabel(){
        return waits.visibilityOfElement(By.cssSelector(".title"));
    }
    public WebElement getContinuaShoppingButton() {
        return waits.visibilityOfElement(By.id("continue-shopping"));
    }

    public WebElement getCheckoutButton() {
        return waits.visibilityOfElement(By.id("checkout"));
    }
}
