package project15.Util;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import project15.Base.BaseDriver;

public class CustomEventListener extends BaseDriver implements WebDriverEventListener {
    @Override
    public void beforeAlertAccept(WebDriver driver) {

    }

    @Override
    public void afterAlertAccept(WebDriver driver) {

    }

    @Override
    public void afterAlertDismiss(WebDriver driver) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver driver) {

    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("Trying to navigate to: " + "\"" + url + "\"");
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("Navigated to: " + "\"" + url + "\"");
    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {

    }

    @Override
    public void afterNavigateBack(WebDriver driver) {

    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {

    }

    @Override
    public void afterNavigateForward(WebDriver driver) {

    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {

    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {

    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Trying to find WebElement by: " + "\"" + by.toString() + "\"");
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Found WebElement by: " + "\"" + by.toString() + "\"");
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("Trying to click on: " + "\"" + element.toString() + "\"");
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println("Clicked on: " + "\"" + element.toString() + "\"");
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

    }

    @Override
    public void beforeScript(String script, WebDriver driver) {

    }

    @Override
    public void afterScript(String script, WebDriver driver) {

    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {
        System.out.println("Trying to change window: " + "\"" + windowName + "\"");
    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {
        System.out.println("Changed window: " + "\"" + windowName + "\"");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {

    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {

    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {
        System.out.println("Trying to get text: " + "\"" + element.toString() + "\"");
    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {
        System.out.println("Got text: " + "\"" + element.toString() + "\""
                + "\nText is: " + "\"" + text + "\"");
    }
}
