package project15.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import project15.Base.BaseDriver;

public class OrderConfirmationPage extends BaseDriver {

    public OrderConfirmationPage(){

        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "p[class='alert alert-success']")
    WebElement orderCompleteMessage;

    @FindBy(xpath = "//div[@id='center_column']/div")
    WebElement confirmationBox;

    public String getOrderCompleteMessage(){

        return orderCompleteMessage.getText();
    }

    public String getReferenceCode(){
        String referenceCode = null;
        String sentence = confirmationBox.getText();
        String[] word = sentence.split(" |\\.");
            for (int i = 0; i < word.length; i++) {
                if(word[i].equals("reference")){
                    referenceCode = word[i + 1];
                    break;
                }
            }
        return referenceCode;
    }
}
