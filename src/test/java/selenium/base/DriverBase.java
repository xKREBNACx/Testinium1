package selenium.base;


import logconf.Log;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DriverBase
{

    static WebDriver driver= null;

    @Before
    public void setUp()
    {
        Log.startLog("Test is starting.");
        System.setProperty("webdriver.chrome.driver","C:/Users/cinno/Documents/selenium dependencies/drivers/chromedriver.exe");
        setWebDriver(new ChromeDriver());
        getDriver().navigate().to("https://www.gittigidiyor.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


    }
    public static WebDriver getDriver()
    {
        return driver;
    }

    public static void setWebDriver(WebDriver driver)
    {
        DriverBase.driver = driver;
    }

    @After
    public void tearDown()
    {
        Log.endLog("Test is ending.");
        if(null != driver) {
            driver.close();
            driver.quit();
        }
    }


}
