package project15.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import project15.Base.BaseDriver;

public class ShippingPage extends BaseDriver {

    public ShippingPage(){

        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "cgv")
    WebElement agreeCheckBox;

    @FindBy(name = "processCarrier")
    WebElement proceedToCheckoutButton;

    public void clickOnAgreeCheckBox(){
        agreeCheckBox.click();
    }

    public void clickOnProceedToCheckoutButton(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", proceedToCheckoutButton);
        proceedToCheckoutButton.click();
    }
}
