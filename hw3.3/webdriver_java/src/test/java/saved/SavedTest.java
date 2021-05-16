package saved;

import base.BaseTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Profile;
import pages.Saved;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.*;

// works with the local webdriver, is not working with the remote webdriver
public class SavedTest extends BaseTests {
    private Profile profilePage = null;

    @BeforeMethod
    public void favoriteUserCleanup() {
        if(this.profilePage == null) {
            this.profilePage = homePage.clickLogin().goProfile();
        }
        Saved savedPage = this.profilePage.goSavedUsers();
        savedPage.removeAllFavorites();
    }

    @Test
    public void checkAddUser() {
        Saved savedPage = this.profilePage.goSavedUsers();
        savedPage.goUserPage(0);
        Boolean isHeartEmptyInitial = savedPage.isHeartEmpty();
        savedPage.addFavorite();
        assertNotEquals(savedPage.isHeartEmpty(), isHeartEmptyInitial);
    }

    @Test
    public void checkAddedUserInSaved() {
        Saved savedPage = this.profilePage.goSavedUsers();
        for(int i = 0; i < savedPage.userUrls.size(); i++) {
            savedPage.goUserPage(i);
            savedPage.addFavorite();
        }
        savedPage = this.profilePage.goSavedUsers();
        List<String> favorites = savedPage.getFavoriteUsers();
        Collections.sort(favorites);
        Collections.sort(savedPage.userUrls);
        assertEquals(favorites, savedPage.userUrls);
    }

}
