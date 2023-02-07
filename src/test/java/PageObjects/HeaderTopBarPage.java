package PageObjects;

import Framework.Browser.JavaScriptExecutor;
import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HeaderTopBarPage {
    private WebDriver driver;
    private Waits waits;

    public HeaderTopBarPage(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getTitleTopBar(){
        return waits.visibilityOfElement(By.cssSelector(".app_logo"));
    }

    public WebElement getMenuButton() {
        return waits.visibilityOfElement(By.id("react-burger-menu-btn"));
    }

    public void selectMenuOption(String tipo) {
        getMenuButton().click();
        List<WebElement> list = driver.findElements(By.cssSelector(".bm-item-list .bm-item.menu-item"));
        for (WebElement element : list) {
            if (element.getText().equals(tipo)) {
                element.click();
            }
        }
    }

    public WebElement getCartButton(){
        return waits.visibilityOfElement(By.cssSelector(".shopping_cart_link"));
    }

}
