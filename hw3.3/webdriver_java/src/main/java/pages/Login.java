package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
    private WebDriver driver;
    private By button = By.xpath("//*[@id=\"loginaction__form_action0\"]");
    private By emailField = By.xpath("//*[@id=\"_idyour_email\"]");
    private By passwordField = By.xpath("//*[@id=\"_idpassword\"]");
    private By errors = By.xpath("//*[@id=\"main\"]/div[1]/div[1]/div[4]/form/div[1]");
    private By forgot = By.xpath("//*[@id=\"main\"]/div[1]/div[1]/div[4]/form/div[1]/div[2]/div/a");
    private By register = By.xpath("//*[@id=\"main\"]/div[1]/div[2]/div[2]/a");

    public Login(WebDriver driver) {
            this.driver = driver;
        }

    public void setEmailField(String email) {
        WebDriverWait wait = new WebDriverWait(driver, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(emailField)));
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPasswordField(String password) {
        WebDriverWait wait = new WebDriverWait(driver, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(passwordField)));
        driver.findElement(passwordField).sendKeys(password);
    }

    public void submit() {
        WebDriverWait wait = new WebDriverWait(driver, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(button)));
        driver.findElement(button).click();
    }

    public boolean errorExists() {

        return !driver.findElements(errors).isEmpty();
    }

    public ForgotPassword goForgotPassword() {
        WebDriverWait wait = new WebDriverWait(driver, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(forgot)));
        driver.findElement(forgot).click();
        return new ForgotPassword(driver);
    }

    public Register goRegister() {
        WebDriverWait wait = new WebDriverWait(driver, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(register)));
        driver.findElement(register).click();
        return new Register(driver);
    }
}
