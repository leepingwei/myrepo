package project15.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import project15.Base.BaseDriver;

public class PaymentPage extends BaseDriver {

    public PaymentPage(){

        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[class='bankwire']")
    WebElement payByBankWireButton;

    @FindBy(css = "a[class='cheque']")
    WebElement payByCheck;

    // 2 payment method of 1
    public void clickOnPayByBankWireButton(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", payByBankWireButton);
        payByBankWireButton.click();
    }

    // 2 payment method of 2
    public void clickOnPayByCheck(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", payByCheck);
        payByCheck.click();
    }
}
