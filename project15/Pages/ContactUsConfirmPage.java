package project15.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import project15.Base.BaseDriver;

public class ContactUsConfirmPage extends BaseDriver {

    public ContactUsConfirmPage(){

        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "p[class='alert alert-success']")
    WebElement confirmMessage;

    public String getConfirmMessage(){

        return confirmMessage.getText();
    }
}
