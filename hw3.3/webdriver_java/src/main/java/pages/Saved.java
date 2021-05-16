package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Saved {
    private WebDriver driver;
    private By heart = By.id("sstar");
    private By emptyHeart = By.cssSelector(".off");
    private By fullHeart = By.cssSelector(".on");
    private By favoriteUsers = By.cssSelector("#contentr > div a");
    private By favoriteHeart = By.cssSelector(".star");
    private By noResult = By.cssSelector("#contentr > div > div:nth-child(2)");
    private String noResultText = "Պահպանված օգտատերներ չկան";
    public List<String> userUrls = Arrays.asList(new String[]{"https://www.list.am/user/55842", "https://www.list.am/user/178317", "https://www.list.am/user/1892260"});


    public Saved(WebDriver driver) {
        this.driver = driver;
    }

    public void goUserPage(int userIndex) {
//        driver.navigate().to(userUrls.get(userIndex));
        driver.get(userUrls.get(userIndex));
    }

    public void addFavorite() {
        (new WebDriverWait(driver, 100)).until(ExpectedConditions.elementToBeClickable(driver.findElement(heart)));
        driver.findElement(heart).click();
    }

    public boolean isHeartEmpty() {
        return driver.findElement(heart).findElements(emptyHeart).size() > 0;
    }

    public void removeAllFavorites() {
        List<WebElement> hearts = driver.findElements(favoriteHeart);
        for(int i = 0; i < hearts.size(); i++ ){
            hearts.get(i).click();
        }
    }

    public List<String> getFavoriteUsers () {
        List<String> userUrls = new ArrayList<>();
        List<WebElement> users = driver.findElements(favoriteUsers);
        (new WebDriverWait(driver, 100)).until(ExpectedConditions.visibilityOfAllElements(users));
        for(int  i = 0; i < users.size(); i++){
            userUrls.add(users.get(i).getAttribute("href"));
        }
        return userUrls;
    }
}
