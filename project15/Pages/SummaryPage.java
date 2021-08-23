package project15.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import project15.Base.BaseDriver;

public class SummaryPage extends BaseDriver {

    public SummaryPage(){

        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[class='button btn btn-default standard-checkout button-medium']")
    WebElement proceedToCheckoutButton;

    public void clickOnProceedToCheckoutButton(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", proceedToCheckoutButton);
        proceedToCheckoutButton.click();
    }
}
