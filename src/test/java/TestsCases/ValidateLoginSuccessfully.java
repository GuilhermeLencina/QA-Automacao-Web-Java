package TestsCases;

import Framework.Report.Report;
import Framework.Report.ReportType;
import Framework.Report.Screenshot;
import Framework.TestBase;
import Tasks.LoginTask;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;

public class ValidateLoginSuccessfully extends TestBase {
    private WebDriver driver = this.getDriver();
    LoginTask loginTask = new LoginTask(this.driver);

    @ParameterizedTest
    @Tag("regressao")
    @CsvFileSource(resources = "/Csv/connectSuccessfully.csv", numLinesToSkip = 1)
    @DisplayName("Realizar acesso com sucesso")
    public void validateAccessSuccessfullySwagLabs(String username, String password) throws Exception{
        try {
            Report.createReportTest("Validar o acesso com sucesso ao SwagLabs", ReportType.GROUP);
            Report.createStep("Realizar login com sucesso");
            loginTask.accessAccount(username, password);
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }
}
