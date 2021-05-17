package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Profile {
    private WebDriver driver;
    private By email = By.cssSelector("#ma > span");
    private By settings = By.cssSelector("#idTabProfile");
    private By notifications = By.cssSelector("#tabmenu > div:nth-child(3) > a");
    private By notificationCheckboxes = By.cssSelector("#tabcontent .cbox:not(.disabled)");
    private By saveButton = By.cssSelector("#notification_infoaction__form_action0");
    private By profile = By.cssSelector("#tabmenu > div:nth-child(1) > a");
    private By logout = By.cssSelector("#ma > div > a:nth-child(17)");
    private By accountInfoOptions = By.cssSelector("#ma > div");
    private By logoutSuccess = By.cssSelector("#main > div.page_info");
    private By addButton = By.cssSelector("#main > div.tabbody > div.dle > div > div > a");
    private By favoriteUsers = By.cssSelector("#ma > div > a:nth-child(8)");

    public Profile(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitleText() {
        return driver.findElement(email).getText();
    }

    public void clickSettings() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(settings)));
        driver.findElement(settings).click();
    }

    public void clickNotifications() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(notifications)));
        driver.findElement(notifications).click();
    }

    public List<WebElement> getCheckboxes() {
        return driver.findElements(notificationCheckboxes);
    }

    public List<WebElement> getCheckboxInputs() {
        List<WebElement> list = getCheckboxes();
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i).findElement(By.tagName("input")));
        }
        return list;
    }

    public void clickSave() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(saveButton)));
        driver.findElement(saveButton).click();
    }

    public void clickProfile() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(profile)));
        driver.findElement(profile).click();
    }

    public Home clickLogout() {
        WebElement options = driver.findElement(accountInfoOptions);
        ((JavascriptExecutor) driver).executeScript("var ele=arguments[0]; ele.style.display = 'block';", options);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(logout)));
        driver.findElement(logout).click();
        return new Home(driver);
    }

    public Add goAdd() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(addButton)));
        driver.findElement(addButton).click();
        return new Add(driver);
    }

    public Saved goSavedUsers() {
        WebElement options = driver.findElement(accountInfoOptions);
        ((JavascriptExecutor) driver).executeScript("var ele=arguments[0]; ele.style.display = 'block';", options);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(favoriteUsers)));
        driver.findElement(favoriteUsers).click();
        return new Saved(driver);
    }

    public void waitForLogin() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(logoutSuccess)));
    }
}
