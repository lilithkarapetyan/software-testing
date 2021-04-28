package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Help {
    private WebDriver driver;
    private By subNavItem = By.xpath("//*[@id=\"crumb\"]/ol/li[2]");
    private By content = By.xpath("//*[@id=\"main\"]/div[2]");

    public Help(WebDriver driver) {
        this.driver = driver;
    }

    public String getNavElementText () {
        return driver.findElement(subNavItem).getText();
    }

    public boolean contentExists () {
        return !driver.findElements(content).isEmpty();
    }

}
