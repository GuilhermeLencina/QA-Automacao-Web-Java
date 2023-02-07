package Validations;

import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.ProductPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class ProductsValidation {
    private WebDriver driver;
    private ProductPage productPage;

    public ProductsValidation (WebDriver driver) {
        this.driver = driver;
        productPage = new ProductPage(this.driver);
    }

    public void validateProduct() {
        try {
            Assertions.assertTrue(productPage.getAddToCartButton().isDisplayed());
            Report.logWithCapture(Status.PASS, "Validar produto está vísivel", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateProductName(String product) {
        try {
            Assertions.assertEquals(productPage.getProductName().getText(), product);
            Report.logWithCapture(Status.PASS, "Validar nome do produto", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateProductPrice(String price) {
        try {
            Assertions.assertEquals(productPage.getProductPrice().getText(), price);
            Report.logWithCapture(Status.PASS, "Validar preço do produto", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateRemoveProductInCart() {
        try {
            Assertions.assertTrue(productPage.getRemoveProductButton().isDisplayed());
            Report.logWithCapture(Status.PASS, "Validar botão remover produto", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateProductInCart() {
        try {
            Assertions.assertTrue(productPage.getAddToCartButton().isDisplayed());
            Report.logWithCapture(Status.PASS, "Validar botão adicionar produto", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }
}
