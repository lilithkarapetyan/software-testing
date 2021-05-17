package add;

import base.BaseTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.Add;
import pages.Profile;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class AddTest extends BaseTests {
    private Profile profilePage = null;
    
    @AfterMethod
    public void cleanUp() {
        goHome();
        profilePage.clickLogout();
        profilePage.waitForLogin();
    }

    @Test
    public void jobPreviewCorrectData() {
        profilePage = homePage.clickLogin().goProfile();
        Add addPage = profilePage.goAdd().goPostJob();
        addPage.fillFields();
        addPage.clickPreview();
        assertEquals(addPage.getPreviewData(), addPage.getExpectedData());
    }

    @Test
    public void jobCancel() {
        profilePage = homePage.clickLogin().goProfile();
        Add addPage = profilePage.goAdd().goPostJob();
        addPage.fillFields();
        addPage.clickPreview();
        Profile profilePage = addPage.clickCancelCreate();
        addPage = profilePage.goAdd().goPostJob();
        List<Boolean> expectedStates = new ArrayList<>(3);
        expectedStates.add(false);
        expectedStates.add(false);
        expectedStates.add(false);
        assertEquals(addPage.getOrganizationRadioFormStates(), expectedStates);
    }
}
