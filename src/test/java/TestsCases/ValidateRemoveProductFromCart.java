package TestsCases;

import Framework.Report.Report;
import Framework.Report.ReportType;
import Framework.Report.Screenshot;
import Framework.TestBase;
import Tasks.LoginTask;
import Tasks.MenuTask;
import Tasks.ProductTask;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;

public class ValidateRemoveProductFromCart extends TestBase {
    private WebDriver driver = this.getDriver();
    LoginTask loginTask = new LoginTask(this.driver);
    MenuTask menuTask = new MenuTask(this.driver);
    ProductTask productTask = new ProductTask(this.driver);

    @ParameterizedTest
    @Tag("regressao")
    @CsvFileSource(resources = "/Csv/connectSuccessfully.csv", numLinesToSkip = 1)
    @DisplayName("Validar remoção de produto do carrinho")
    public void validateRemoveProductFromCart(String username, String password) throws Exception{
        try {
            Report.createReportTest("Validar remomção de produto do carrinho", ReportType.GROUP);
            Report.createStep("Realizar login com sucesso");
            loginTask.accessAccount(username, password);
            Report.createStep("Selecionar produto");
            menuTask.selectProduct();
            Report.createStep("Adicioonar produto do carrinho");
            productTask.addProductToCart();
            Report.createStep("Remover produto do carrinho");
            productTask.removeProductInCart();
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }
}
