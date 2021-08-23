package project15.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import project15.Base.BaseDriver;

import java.util.List;
import java.util.Random;

public class ContactUsPage extends BaseDriver {

    public ContactUsPage(){

        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "id_contact")
    WebElement subjectHeading;

    @FindBy(id = "email")
    WebElement emailAddressTextBox;

    @FindBy(css = "select[name='id_order']")
    WebElement orderReference;

    @FindAll(@FindBy(css = "select[name='id_order']>option"))
    List<WebElement> orderReferenceList;

    @FindBy(id = "fileUpload")
    WebElement attachFile;

    @FindBy(id = "message")
    WebElement message;

    @FindBy(id = "submitMessage")
    WebElement sendButton;

    public void selectSubjectHeading(){
        Select select = new Select(subjectHeading);
        select.selectByIndex(new Random().nextInt(2)+1);
    }

    public void inputEmailAddress(){
        emailAddressTextBox.clear();
        emailAddressTextBox.sendKeys("studyTest@test.com");
    }

    public void selectOrderReference(){
        Select select = new Select(orderReference);
        select.selectByIndex((int)(Math.random()*orderReferenceList.size()));
    }

    // Upload button
    public void chooseAttachFile(){
        attachFile.sendKeys("/Users/lipingwei/IdeaProjects/Saturday_Projects/src/project15/Util/Batch4_TestNG_Project.pdf");
    }

    public void writeMessage(String text){
        message.sendKeys(text);
    }

    public void clickOnSendButton(){
        sendButton.click();
    }
}
