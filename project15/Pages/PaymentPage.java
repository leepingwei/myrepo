package project15.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import project15.Base.BaseDriver;

import java.util.ArrayList;

public class PaymentPage extends BaseDriver {

    public PaymentPage(){

        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[class='bankwire']")
    WebElement payByBankWireButton;

    @FindBy(css = "a[class='cheque']")
    WebElement payByCheck;

    public void paymentMethodSelector(){
        ArrayList<WebElement> paymentMethod = new ArrayList<>();
        paymentMethod.add(payByBankWireButton);
        paymentMethod.add(payByCheck);
        int paymentIndex = (int)(Math.random()*(paymentMethod.size()));
        WebElement paymentButton = paymentMethod.get(paymentIndex);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", paymentButton);
        paymentButton.click();
    }
}
