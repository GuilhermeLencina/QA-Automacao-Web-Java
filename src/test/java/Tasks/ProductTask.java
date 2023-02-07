package Tasks;

import Framework.Browser.Waits;
import PageObjects.ProductPage;
import Validations.ProductsValidation;
import org.openqa.selenium.WebDriver;

public class ProductTask {
    private static WebDriver driver;
    private static Waits waits;
    private static ProductPage productPage;
    private static ProductsValidation productsValidation;

    public ProductTask(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
        productPage = new ProductPage(this.driver);
        productsValidation = new ProductsValidation(this.driver);
    }

    public void validateProduct(String product, String price){
        productsValidation.validateProductName(product);
        productsValidation.validateProductPrice(price);
        productPage.getBackToProductsButton().click();
    }

    public void addProductToCart(){
        productPage.getAddToCartButton().click();
        productsValidation.validateRemoveProductInCart();
    }

    public void removeProductInCart(){
        productPage.getRemoveProductButton().click();
        productsValidation.validateProductInCart();
    }

    public void goToCart(){
        productPage.getCartButton().click();
    }
}
