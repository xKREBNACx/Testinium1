package selenium.pagemodel;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PageModel {
    By mainPageIcon = By.className("sc-1o6eogh-1");
    By loginIcon = By.xpath("//*[@id='main-header']/div[3]/div/div/div/div[3]/div/div[1]/div/div[2]");
    By loginButton = By.className("sc-12t95ss-3");
    By email = By.id("L-UserNameField");
    By password = By.id("L-PasswordField");
    By clickLogin = By.id("gg-login-enter");
    By searchBar = By.xpath("//*[@id='main-header']/div[3]/div/div/div/div[2]/form/div/div[1]/div[2]/input");
    By searchButton = By.xpath("//*[@id='main-header']/div[3]/div/div/div/div[2]/form/div/div[2]/button");
    By closeCookies = By.xpath("//*[@id='__next']/main/section/section/a");
    By secondPageButton = By.xpath("//ul[@class='clearfix']/li/a[text()='2']");
    By randomProduct = By.xpath("//*[@id='item-info-block-667062227']/div/div[1]/div[1]");
    By addToBasket = By.id("add-to-basket");
    By productPrice = By.id("sp-price-lowPrice");
    By goToBasket = By.xpath("//*[@id='header_wrapper']/div[4]/div[3]/a");
    By basketPrice = By.xpath("//div[contains(@class,'detail-price')]");
    By quantityOption = By.xpath("//div[contains(@class,'gg-input-select')]/select[@class='amount']");
    By setQuantity = By.xpath("//div/select/option[@value='2']");
    By clearBasket = By.xpath("//a[@data-id='667062227']");
    By basketText = By.id("empty-cart-container");





    WebDriverWait driverWait=null;
    static Actions action=null;
    WebDriver driver=null;

    public PageModel(WebDriver driver)
    {
        this.driver=driver;
        this.action=new Actions(driver);
        this.driverWait=new WebDriverWait(driver,60);

    }

    public boolean getMainPageStatus()
    {
        driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(mainPageIcon));
        WebElement webelement = driver.findElement(mainPageIcon);
        return webelement.isDisplayed();
    }
    public void hoverLoginIcon()
    {
        driver.findElement(closeCookies).click();

        driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(loginIcon));
        driverWait.until(ExpectedConditions.elementToBeClickable(loginIcon));
        WebElement webelement = driver.findElement(loginIcon);
        action.moveToElement(webelement).build().perform();
    }
    public void clickLoginButton()
    {
        driverWait.until(ExpectedConditions.elementToBeClickable(loginIcon));
        WebElement webelement = driver.findElement(loginButton);
        webelement.click();
    }
    public void setEmail()
    {
        driver.findElement(email).sendKeys("sedalib618@naymeo.com");
    }
    public void setPassword()
    {
        driver.findElement(password).sendKeys("testinium123");
    }
    public void clickLogin()
    {
        driver.findElement(clickLogin).click();
    }
    public void searchBar()
    {
        driver.findElement(searchBar).sendKeys("bilgisayar");
    }
    public void searchButton()
    {
        driver.findElement(searchButton).click();
    }
    public void secondPageButton()
    {

        driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(secondPageButton));
        driverWait.until(ExpectedConditions.elementToBeClickable(secondPageButton));
        WebElement webelement = driver.findElement(secondPageButton);
        webelement.click();
    }
    public void randomProduct()
    {
        driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(randomProduct));
        driverWait.until(ExpectedConditions.elementToBeClickable(randomProduct));
        WebElement webelement = driver.findElement(randomProduct);
        action.moveToElement(webelement).build().perform();
        driver.findElement(randomProduct).click();
    }
    public void addToBasket()
    {
        driver.findElement(addToBasket).click();
    }

    public List<String> getPrices()
    {
        List<String> prices =  new ArrayList<>();

        String pPrice =  driver.findElement(productPrice).getText();
        driver.findElement(goToBasket).click();
        driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(basketPrice));
        String bPrice = driver.findElement(basketPrice).getText();
        prices.add(pPrice);
        prices.add(bPrice);
        return prices;
    }
    public void setQuantity()
    {
        driver.findElement(quantityOption).click();
        driver.findElement(setQuantity).click();
    }
    public void deleteProductsFromBasket()
    {
        driver.findElement(clearBasket).click();
    }
    public boolean getBasketEmptyStatus()
    {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(basketText));;
        WebElement basketStatus = driver.findElement(basketText);
        return basketStatus.isDisplayed();

    }





}


