package project15.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import project15.Util.CustomEventListener;

import java.util.concurrent.TimeUnit;

public class BaseDriver {

    /**
     *  Requirement:
     *  You should have a Base Driver class where you set up your WebDriver.
     *  (You should provide driver type(chrome-firefox) as a @Parameter to your @BeforeMethod)
     */

    public static WebDriver driver;
    public static EventFiringWebDriver e_driver;
    public static CustomEventListener eventListener;
    public static WebDriverWait wait;

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void setUp(String browser){
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "/Users/lipingwei/Desktop/TechnoStudy/Selenium/BrowserDriver/chromedriver");
            driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "/Users/lipingwei/Desktop/TechnoStudy/Selenium/BrowserDriver/geckodriver");
            driver = new FirefoxDriver();
        }

        // Wrapping driver and eventListener
        e_driver = new EventFiringWebDriver(driver);
        eventListener = new CustomEventListener();
        e_driver.register(eventListener);
        driver = e_driver;

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver, 10);

        driver.get("http://automationpractice.com/index.php");

        // Email address: studyTest@test.com
        // password: 123456

        WebElement signInButton = driver.findElement(By.cssSelector("div[class='header_user_info']>a"));
        signInButton.click();

        WebElement emailAddressTextBox = driver.findElement(By.id("email"));
        emailAddressTextBox.sendKeys("studyTest@test.com");

        WebElement passwordTextBox = driver.findElement(By.id("passwd"));
        passwordTextBox.sendKeys("123456");

        WebElement signInBtn = driver.findElement(By.cssSelector("i[class='icon-lock left']"));
        signInBtn.click();

        WebElement homeButton = driver.findElement(By.cssSelector("i[class='icon-chevron-left']"));
        homeButton.click();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){

        driver.quit();
    }
}
