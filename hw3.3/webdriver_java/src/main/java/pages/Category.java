package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Category {
    private WebDriver driver;
    private By subNavItem = By.xpath("//*[@id=\"crumb\"]/ol/li[2]");
    private By sidebar = By.xpath("//*[@id=\"ff\"]");
    private By item = By.cssSelector("#contentr > div.dl > a:nth-child(2)");
    private By filterOffer = By.xpath("//*[@id=\"ff\"]/div[1]/div[1]/div[2]/label");
    private By priceFilter = By.xpath("//*[@id=\"ff\"]/div[3]");
    private By loading = By.cssSelector("#cc_loading");

    public Category(WebDriver driver) {
        this.driver = driver;
    }

    public String getNavElementText () {
        return driver.findElement(subNavItem).getText();
    }

    public boolean sidebarExists () {
        return !driver.findElements(sidebar).isEmpty();
    }

    public void clickFilterOffer() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(filterOffer)));
        driver.findElement(filterOffer).click();
    }

    public boolean priceFilterExists() {
        // WebDriverWait wait = new WebDriverWait(driver, 10);
        // wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loading)));
        // need to check the invisibility of the loading. The loading is too fast, I can't take its path. The test fails because of this
        return !driver.findElements(priceFilter).isEmpty();
    }

    public Item clickItem() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(item)));
        driver.findElement(item).click();
        return new Item(driver);
    }
}
