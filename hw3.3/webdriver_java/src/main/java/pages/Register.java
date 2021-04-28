package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register {
    private WebDriver driver;
    private By title = By.xpath("//*[@id=\"main\"]/div[1]/div[1]");

    public Register(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitleText () {
        return driver.findElement(title).getText();
    }
}
