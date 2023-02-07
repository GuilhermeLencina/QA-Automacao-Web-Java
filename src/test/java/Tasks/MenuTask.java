package Tasks;

import Framework.Browser.Waits;
import PageObjects.MenuPage;
import Validations.MenuValidation;
import Validations.ProductsValidation;
import org.openqa.selenium.WebDriver;

public class MenuTask {
    private static WebDriver driver;
    private static Waits waits;
    private static MenuPage menuPage;
    private static MenuValidation menuValidation;
    private static ProductsValidation productsValidation;

    public MenuTask(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
        menuPage = new MenuPage(this.driver);
        menuValidation = new MenuValidation(this.driver);
        productsValidation = new ProductsValidation(this.driver);
    }

    public void filterProduct(String option){
        menuValidation.ValidateFilterOptions();
        menuPage.selectFilterType(option);
        menuValidation.ValidateFilterOptions();
    }

    public void selectProduct(){
        menuPage.getProductOne().click();
        productsValidation.validateProduct();
    }
}
