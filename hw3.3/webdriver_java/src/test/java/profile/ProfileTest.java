package profile;

import base.BaseTests;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Home;
import pages.Profile;

import java.util.*;

import static org.testng.Assert.*;

public class ProfileTest extends BaseTests {
    private Profile profilePage = null;


    @AfterMethod
    public void cleanUp() {
        goHome();
        profilePage.clickLogout();
        profilePage.waitForLogin();
    }

    @Test
    public void checkEmail(){
        profilePage = homePage.clickLogin().goProfile();
        assertEquals(profilePage.getTitleText(), "lilitt.karapetyan@gmail.com");
    }

    @Test
    public void checkCheckBoxNoSave() {
        profilePage = homePage.clickLogin().goProfile();
        profilePage.clickSettings();
        profilePage.clickNotifications();
        List<WebElement> checkboxInputs = profilePage.getCheckboxInputs();
        List<WebElement> checkboxes = profilePage.getCheckboxes();
        List<Boolean> isSelected = new ArrayList<>();

        for(int i = 0; i < checkboxInputs.size(); i++) {
            isSelected.add(checkboxInputs.get(i).isSelected());
        }
        for(int i = 0; i < checkboxes.size(); i++) {
            checkboxes.get(i).click();
        }

        profilePage.clickProfile();
        profilePage.clickNotifications();

        checkboxInputs = profilePage.getCheckboxInputs();

        List<Boolean> isSelectedFinal = new ArrayList<>();

        for(int i = 0; i < checkboxInputs.size(); i++) {
            isSelectedFinal.add(checkboxInputs.get(i).isSelected());
        }
        assertEquals(isSelectedFinal, isSelected);
    }

    @Test
    public void checkCheckBoxWithSave() {
        profilePage = homePage.clickLogin().goProfile();
        profilePage.clickSettings();
        profilePage.clickNotifications();
        List<WebElement> checkboxInputs = profilePage.getCheckboxInputs();
        List<WebElement> checkboxes = profilePage.getCheckboxes();
        List<Boolean> isSelected = new ArrayList<>();

        for(int i = 0; i < checkboxInputs.size(); i++) {
            isSelected.add(checkboxInputs.get(i).isSelected());
        }
        for(int i = 0; i < checkboxes.size(); i++) {
            checkboxes.get(i).click();
        }
        profilePage.clickSave();

        checkboxInputs = profilePage.getCheckboxInputs();

        List<Boolean> isNotSelectedFinal = new ArrayList<>();

        for(int i = 0; i < checkboxInputs.size(); i++) {
            isNotSelectedFinal.add(!checkboxInputs.get(i).isSelected());
        }
        assertEquals(isNotSelectedFinal, isSelected);
    }


    @Test
    public void checkCheckBoxSaveWithLogin() {
        profilePage = homePage.clickLogin().goProfile();
        profilePage.clickSettings();
        profilePage.clickNotifications();
        List<WebElement> checkboxInputs = profilePage.getCheckboxInputs();
        List<WebElement> checkboxes = profilePage.getCheckboxes();
        List<Boolean> isSelected = new ArrayList<>();

        for(int i = 0; i < checkboxInputs.size(); i++) {
            isSelected.add(checkboxInputs.get(i).isSelected());
        }
        for(int i = 0; i < checkboxes.size(); i++) {
            checkboxes.get(i).click();
        }
        profilePage.clickSave();
        Home homePage = profilePage.clickLogout();
        profilePage.waitForLogin();
        profilePage = homePage.clickLogin().goProfile();
        profilePage.clickSettings();
        profilePage.clickNotifications();

        checkboxInputs = profilePage.getCheckboxInputs();

        List<Boolean> isNotSelectedFinal = new ArrayList<>();

        for(int i = 0; i < checkboxInputs.size(); i++) {
            isNotSelectedFinal.add(!checkboxInputs.get(i).isSelected());
        }
        assertEquals(isNotSelectedFinal, isSelected);
    }

}
