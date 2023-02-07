package PageObjects;

import Framework.Browser.JavaScriptExecutor;
import Framework.Browser.Waits;
import Validations.ProductsValidation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends HeaderTopBarPage{
    private static WebDriver driver;
    private static Waits waits;

    public ProductPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getProductName() {
        return waits.visibilityOfElement(By.cssSelector(".inventory_details_name"));
    }

    public WebElement getProductPrice() {
        return waits.visibilityOfElement(By.cssSelector(".inventory_details_price"));
    }

    public WebElement getAddToCartButton() {
        return waits.visibilityOfElement(By.id("add-to-cart-sauce-labs-backpack"));
    }

    public WebElement getRemoveProductButton() {
        return waits.visibilityOfElement(By.id("remove-sauce-labs-backpack"));
    }

    public WebElement getBackToProductsButton() {
        return waits.visibilityOfElement(By.id("back-to-products"));
    }
}
