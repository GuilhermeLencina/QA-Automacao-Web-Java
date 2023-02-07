package TestsCases;

import Framework.Report.Report;
import Framework.Report.ReportType;
import Framework.Report.Screenshot;
import Framework.TestBase;
import Tasks.*;
import com.aventstack.extentreports.Status;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;

public class ValidateSuccessfullyCompletedPurchase extends TestBase {
    private WebDriver driver = this.getDriver();
    LoginTask loginTask = new LoginTask(this.driver);
    MenuTask menuTask = new MenuTask(this.driver);
    ProductTask productTask = new ProductTask(this.driver);
    CartTask cartTask = new CartTask(this.driver);
    CheckoutTask checkoutTask = new CheckoutTask(this.driver);
    OverviewTask overviewTask = new OverviewTask(this.driver);
    FinishTask finishTask = new FinishTask(this.driver);

    @ParameterizedTest
    @Tag("regressao")
    @CsvFileSource(resources = "/Csv/connectSuccessfully.csv", numLinesToSkip = 1)
    @DisplayName("Realizar compra completa com sucesso")
    public void validateCompletePurchaseSuccessfully(String username, String password) throws Exception{
        try {
            Report.createReportTest("Validar compra completa com sucesso", ReportType.GROUP);
            Report.createStep("Realizar login com sucesso");
            loginTask.accessAccount(username, password);
            Report.createStep("Selecionar produto");
            menuTask.selectProduct();
            Report.createStep("Adicionar produto no carrinho");
            productTask.addProductToCart();
            productTask.goToCart();
            Report.createStep("Fazer checkout do produto no carrinho");
            cartTask.checkoutProduct();
            Report.createStep("Preencher informações");
            checkoutTask.fillField();
            Report.createStep("Validar preço total");
            overviewTask.validateOverviewFields();
            Report.createStep("Validar compra concluída");
            finishTask.validatePurchaseSuccessfully();
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }
}
