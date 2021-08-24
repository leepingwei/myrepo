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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseDriver {

    /**
     *  Requirement:
     *  You should have a Base Driver class where you set up your WebDriver.
     *  (You should provide driver type(chrome-firefox) as a @Parameter to your @BeforeMethod)
     */

    public static WebDriver driver;
    public static EventFiringWebDriver e_driver;
    public static Properties properties;
    public static CustomEventListener eventListener;
    public static WebDriverWait wait;

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void setUp(String browser){
        // Reading properties file
        properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream("/Users/lipingwei/IdeaProjects/Saturday_Projects/src/project15/Util/Config.properties");
            properties.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String browserName = properties.getProperty("browser");
        if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "/Users/lipingwei/Desktop/TechnoStudy/Selenium/BrowserDriver/chromedriver");
            driver = new ChromeDriver();
        }else if(browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "/Users/lipingwei/Desktop/TechnoStudy/Selenium/BrowserDriver/geckodriver");
            driver = new FirefoxDriver();
        }

        // Wrapping driver and eventListener
        e_driver = new EventFiringWebDriver(driver);
        eventListener = new CustomEventListener();
        e_driver.register(eventListener);
        driver = e_driver;

        long timeForPageLoad = Long.parseLong(properties.getProperty("setPageLoadTimeOut"));
        long timeForImplicitlyWait = Long.parseLong(properties.getProperty("setImplicitlyWait"));
        long timeForExplicitlyWait = Long.parseLong(properties.getProperty("setExplicitlyWait"));
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(timeForPageLoad, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(timeForImplicitlyWait, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, timeForExplicitlyWait);

        driver.get(properties.getProperty("url"));

        WebElement signInButton = driver.findElement(By.cssSelector("div[class='header_user_info']>a"));
        signInButton.click();

        WebElement emailAddressTextBox = driver.findElement(By.id("email"));
        emailAddressTextBox.sendKeys(properties.getProperty("emailAddress"));

        WebElement passwordTextBox = driver.findElement(By.id("passwd"));
        passwordTextBox.sendKeys(properties.getProperty("password"));

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
