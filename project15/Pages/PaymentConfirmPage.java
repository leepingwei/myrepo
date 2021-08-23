package project15.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import project15.Base.BaseDriver;

public class PaymentConfirmPage extends BaseDriver {

    public PaymentConfirmPage(){

        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "button[class='button btn btn-default button-medium']")
    WebElement confirmButton;

    public void clickOnConfirmButton(){
        confirmButton.click();
    }
}
