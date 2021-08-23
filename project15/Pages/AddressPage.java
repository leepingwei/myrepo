package project15.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import project15.Base.BaseDriver;

public class AddressPage extends BaseDriver {

    public AddressPage(){

        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "processAddress")
    WebElement proceedToCheckoutButton;

    public void clickOnProceedToCheckoutButton(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", proceedToCheckoutButton);
        proceedToCheckoutButton.click();
    }
}
