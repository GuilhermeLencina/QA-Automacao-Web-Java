package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OverviewPage extends HeaderTopBarPage{
    private static WebDriver driver;
    private static Waits waits;

    public OverviewPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getPaymentInformationLabel(){
        return waits.visibilityOfElement(By.cssSelector(".summary_value_label:nth-child(2)"));
    }

    public WebElement getShippingInformationLabel() {
        return waits.visibilityOfElement(By.cssSelector(".summary_value_label:nth-child(4)"));
    }

    public WebElement getTotalLabel() {
        return waits.visibilityOfElement(By.cssSelector(".summary_total_label"));
    }

    public WebElement getCancelButton() {
        return waits.visibilityOfElement(By.id("cancel"));
    }

    public WebElement getFinishButton() {
        return waits.visibilityOfElement(By.id("finish"));
    }
}
