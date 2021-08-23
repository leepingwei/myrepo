package project15.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import project15.Base.BaseDriver;

import java.util.List;

public class MyOrdersPage extends BaseDriver {

    public MyOrdersPage(){

        PageFactory.initElements(driver, this);
    }

    @FindAll(@FindBy(xpath = "//table[@id='order-list']/tbody/tr/td/a[@class='color-myaccount']"))
    public List<WebElement> orderReferenceList;
}
