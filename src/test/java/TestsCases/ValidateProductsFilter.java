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

public class ValidateProductsFilter extends TestBase {
    private WebDriver driver = this.getDriver();
    LoginTask loginTask = new LoginTask(this.driver);
    MenuTask menuTask = new MenuTask(this.driver);
    ProductTask productTask = new ProductTask(this.driver);

    @ParameterizedTest
    @Tag("regressao")
    @CsvFileSource(resources = "/Csv/connectSuccessfully.csv", numLinesToSkip = 1)
    @DisplayName("Validar funcionalidade de filtro de produtos")
    public void validateCompletePurchaseSuccessfully(String username, String password) throws Exception {
        try {
                Report.createReportTest("Validar filtro de produtos", ReportType.GROUP);
                Report.createStep("Realizar login com sucesso");
                loginTask.accessAccount(username, password);
                Report.createStep("Filtrar produto");
                menuTask.filterProduct("Price (high to low)");
            }catch (Exception error){
                Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }
}
