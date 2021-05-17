package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPassword {
    private WebDriver driver;
    private By title = By.xpath("//*[@id=\"main\"]/div[1]/div");

    public ForgotPassword(WebDriver driver) {
            this.driver = driver;
        }


    public String getTitleText () {
        return driver.findElement(title).getText();
    }

}
