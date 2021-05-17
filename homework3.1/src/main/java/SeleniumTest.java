import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumTest {
    public static void main(String[] args) {
        test();
    }

    @Test
    public static void test(){
        System.setProperty("webdriver.chrome.driver", "/Users/lilitkarapetyan/Desktop/random/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.list.am/");
        WebElement search = driver.findElement(By.cssSelector("#idSearchBox"));
        search.click();
        search.sendKeys("աշխատանք");
        search.sendKeys(Keys.RETURN);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement nextPage = driver.findElement(By.cssSelector("#contentr > div.dl > div.dlf > a"));
        nextPage.click();
        WebElement pageNumber = driver.findElement(By.xpath("//*[@id=\"contentr\"]/div[2]/div[2]/span"));
        js.executeScript("arguments[0].scrollIntoView();", pageNumber);
        WebElement activePage = driver.findElement(By.xpath("//*[@id=\"contentr\"]/div[2]/div[2]/span/span"));
        assertEquals(activePage.getText(), "2");
        WebElement logo = driver.findElement(By.cssSelector("#l"));
        logo.click();
        driver.quit();
    }

}
