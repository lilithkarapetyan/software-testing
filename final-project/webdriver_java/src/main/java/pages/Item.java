package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Item {
    private WebDriver driver;
    private By image = By.xpath("//*[@id=\"pcontent\"]/div/div[1]/div[1]/div[1]/div[1]");
    private By modal = By.cssSelector("#pvx");
    private By sliderDots = By.cssSelector("#pcontent > div > div.vit > div.pv > div.jumptodiv > span");
    private By arrow = By.xpath("//*[@id=\"pcontent\"]/div/div[1]/div[1]/div[4]");

    public Item(WebDriver driver) {
        this.driver = driver;
    }

    public void clickImage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(image));
        driver.findElement(image).click();
    }

    public boolean modalExists() {
        return !driver.findElements(modal).isEmpty();
    }

    public int imageCount() {
        return driver.findElements(sliderDots).size();
    }

    public boolean arrowExists() {
        // actual bug
        // the content of the page always gets shuffled,
        // that's why I couldn't know which element has 1 pic or more, that's why I wrote if-else in the test
        return driver.findElements(arrow).isEmpty();
    }

}
