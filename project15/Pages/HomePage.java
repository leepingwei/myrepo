package project15.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import project15.Base.BaseDriver;

import java.util.List;
import java.util.Set;

public class HomePage extends BaseDriver {

    public static int index;
    public static int buttonIndex;
    String xpathHead = "//ul[@id='homefeatured']/li[";
    String xpathTail = "]/div/div[2]/div[2]/a[1]/span";

    public HomePage(){

        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "contact-link")
    public WebElement contactUsLink;

    @FindAll(@FindBy(css = "ul[id='homefeatured']>li"))
    List<WebElement> selectAProduct;

    @FindBy(css = "a[class='btn btn-default button button-medium']")
    WebElement proceedToCheckout;

    @FindBy(css = "ul[class='bullet']")
    WebElement myAccount;

    @FindAll(@FindBy(css = "ul[class='bullet']>li>a"))
    List<WebElement> pageList;

    public void hoverOverToAProduct(){
        index = (int)(Math.random()*(selectAProduct.size()));
        buttonIndex = index + 1;
        WebElement selectItem = selectAProduct.get(index);
        Actions actions = new Actions(driver);
        actions.moveToElement(selectItem).perform();
    }

    public void clickOnAddToCartButton() {
        // Product list size: 7, item may start from 0
        // Button index: may start from 1
        // Or locator found extra index
        // Have to do "index + 1" to match the item from product list
        String dynamicXpath = xpathHead + buttonIndex + xpathTail;
        WebElement addToCartButton = driver.findElement(By.xpath(dynamicXpath));
        addToCartButton.click();
    }

    public void clickOnProceedToCheckoutButton(){
        Set<String> windowId = driver.getWindowHandles();
        for(String ids : windowId){
            driver.switchTo().window(ids);
        }
        proceedToCheckout.click();
    }

    public void clickOnContactUsLink(){
        wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(contactUsLink));
        contactUsLink.click();
    }

    public void clickOnMyOrdersPageLink(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", myAccount);
        for(WebElement pages : pageList){
            if(pages.getText().equalsIgnoreCase("My orders")){
                pages.click();
                break;
            }
        }
    }
}
