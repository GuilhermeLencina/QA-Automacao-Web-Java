package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MenuPage extends HeaderTopBarPage{
    private WebDriver driver;
    private Waits waits;

    public MenuPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getTitlePageLabel() {
        return waits.visibilityOfElement(By.cssSelector(".title"));
    }

    public WebElement getFilterTypeSelect() {
        return waits.visibilityOfElement(By.cssSelector(".select_container"));
    }

    public void selectFilterType(String filter) {
        getFilterTypeSelect().click();
        List<WebElement> list = driver.findElements(By.cssSelector("option"));
        for (WebElement element : list) {
            if (element.getText().equals(filter)) {
                element.click();
            }
        }
    }

    public WebElement getProductOne() {
        return waits.visibilityOfElement(By.cssSelector(".inventory_list .inventory_item_name:nth-child(1)"));
    }

    public WebElement getProductTwo() {
        return waits.visibilityOfElement(By.cssSelector(".inventory_list .inventory_item_name:nth-child(2)"));
    }

    public WebElement getProductThree() {
        return waits.visibilityOfElement(By.cssSelector(".inventory_list .inventory_item_name:nth-child(3)"));
    }

    public WebElement getProductFour() {
        return waits.visibilityOfElement(By.cssSelector(".inventory_list .inventory_item_name:nth-child(4)"));
    }

    public WebElement getProductFive() {
        return waits.visibilityOfElement(By.cssSelector(".inventory_list .inventory_item_name:nth-child(5)"));
    }

    public WebElement getProductSix() {
        return waits.visibilityOfElement(By.cssSelector(".inventory_list .inventory_item_name:nth-child(6)"));
    }

}
