package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {
    private WebDriver driver;

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    public Category clickCategory(){
        WebElement search = driver.findElement(By.xpath("//*[@id=\"idSearchBox\"]"));
        search.click();
        search.sendKeys(Keys.RETURN);
        return new Category(driver);
    }

    public Login clickLogin(){
        clickLink("Իմ էջը");
        return new Login(driver);
    }

    public Help clickHelp(){
        clickLink("Տեղեկանք");
        return new Help(driver);
    }

    public BusinessPages clickBusinessPages(){
        clickLink("Բիզնես էջեր");
        return new BusinessPages(driver);
    }

    private void clickLink(String linkText){
        WebDriverWait wait = new WebDriverWait(driver, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText(linkText))));
        driver.findElement(By.linkText(linkText)).click();
    }
}
